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

import java.util.ArrayList
import java.util.List
import javax.inject.Inject

import org.apache.commons.collections.Factory
import org.dozer.Mapper
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.context.ApplicationContext

import org.examproject.dto.PersonDto
import org.examproject.entity.Person
import org.examproject.repository.PersonRepository

import scala.collection.JavaConversions._

/**
 * @author hiroxpepe
 */
class PersonsFactory extends Factory {

    private val LOG: Logger = LoggerFactory.getLogger(classOf[PersonsFactory])

    @Inject
    private val context: ApplicationContext = null
    
    @Inject
    private val mapper: Mapper = null
    
    @Inject
    private val repository: PersonRepository = null

    @Override
    def create(): Object = {
        LOG.debug("called.")
        try {
            return searchPersons()
        } catch {
            case re: RuntimeException => {
                LOG.error("RuntimeException occurred. " + re.getMessage())
                throw re
            }
        }
    }

    private def searchPersons(): List[PersonDto] = {
        
        // create the new dto list.
        val dtoList: List[PersonDto] = new ArrayList[PersonDto]()
        
        // get the entities list from repository.
        val list: List[Person] = repository.findAll()
        for (person: Person <- list) {
            
            // object mapping by dozer.
            val dto: PersonDto = context.getBean(classOf[PersonDto])
            mapper.map(person, dto)
            
            // add to dto list.
            dtoList.add(dto)
        }
        return dtoList
    }

}
