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

import javax.inject.Inject

import org.apache.commons.collections.Closure
import org.slf4j.Logger
import org.slf4j.LoggerFactory

import org.examproject.dto.PersonDto
import org.examproject.entity.Person
import org.examproject.repository.PersonRepository

/**
 * @author hiroxpepe
 */
class DeletePersonClosure extends Closure {
    
    private val LOG: Logger = LoggerFactory.getLogger(classOf[DeletePersonClosure])
    
    @Inject
    private val repository: PersonRepository = null
    
    @Override
    def execute(o: Object) {
        LOG.debug("called.")
        val personDto: PersonDto = o.asInstanceOf[PersonDto]
        try {
            delete(personDto)
        } catch {
            case re: RuntimeException => {
                LOG.error("RuntimeException occurred. " + re.getMessage())
                throw re
            }
        }
    }
    
    private def delete(personDto: PersonDto) {
        try {
            // to search the repository for delete.
            val person: Person = repository.findOne(personDto.getId()).asInstanceOf[Person]
            repository.delete(person.getId())
        } catch {
            case e: Exception => {
                throw new RuntimeException("delete failed. ", e)
            }
        }
    }

}
