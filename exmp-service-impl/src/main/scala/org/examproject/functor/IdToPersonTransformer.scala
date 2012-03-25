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

import java.lang.Long
import javax.inject.Inject

import org.apache.commons.collections.Transformer
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
class IdToPersonTransformer extends Transformer {

    private val LOG: Logger = LoggerFactory.getLogger(classOf[IdToPersonTransformer])

    @Inject
    private val context: ApplicationContext = null
    
    @Inject
    private val mapper: Mapper = null
    
    @Inject
    private val repository: PersonRepository = null

    @Override
    def transform(o: Object ): Object = {
        LOG.debug("called.")
        try {
            return getPersonDto(o)
        } catch {
            case re: RuntimeException => {
                LOG.error("RuntimeException occurred. " + re.getMessage())
                throw re
            }
        }
    }

    private def getPersonDto(o: Object): PersonDto = {
        
        // if ID is offered, find the entity from repository, and mapping to dto.
        if (o != null) {
            // get the entity from repository.
            val id: Long = Long.valueOf(o.toString())
            val person: Person = repository.findOne(id).asInstanceOf[Person]
            
            // object mapping by dozer.
            val dto: PersonDto = context.getBean(classOf[PersonDto])
            mapper.map(person, dto)
              
            // return a mapped dto.
            return dto
            
        // if the new request, a null ID will be provided.
        } else {
            // return a new dto.
            return context.getBean(classOf[PersonDto])
        }
    }
    
}