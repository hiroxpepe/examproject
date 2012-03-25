/* 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */ 

package org.examproject.functor

import java.util.Date
import javax.inject.Inject

import org.apache.commons.collections.Closure
import org.dozer.Mapper
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.context.ApplicationContext

import org.examproject.dto.PersonDto
import org.examproject.entity.Person
import org.examproject.repository.PersonRepository

/**
 * @author hiroxpepe
 */
class SavePersonClosure extends Closure {
    
    private val LOG: Logger = LoggerFactory.getLogger(classOf[SavePersonClosure])

    @Inject
    private val context: ApplicationContext = null
    
    @Inject
    private val mapper: Mapper = null
    
    @Inject
    private val repository: PersonRepository = null
    
    @Override
    def execute(o: Object ) = {
        LOG.debug("called.")
        val personDto: PersonDto = o.asInstanceOf[PersonDto]
        try {
            save(personDto)
        } catch {
            case re: RuntimeException => {
                LOG.error("RuntimeException occurred. " + re.getMessage())
                throw re
            }
        }
    }
    
    private def save(personDto: PersonDto) = {
        LOG.debug("called save.")

        // if dto is new one, create a new date.
        if (personDto.getCreated() == null) {
            personDto.setCreated(new Date())
            LOG.debug("set personDto new Date.")
        }
        
        // object mapping by dozer.
        val person: Person = context.getBean(classOf[Person])
        mapper.map(personDto, person)

        // push the entity to repository.
        try {
            repository.save(person)
            LOG.debug("save a person.")
        } catch {
            case e: Exception => {
                throw new RuntimeException("failed save a person.", e)
            }
        }
        
        // if dto is new one, set the entity's ID.
        if (personDto.getId() == null) {
            personDto.setId(person.getId())
        }
    }

}
