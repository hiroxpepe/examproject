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

package org.examproject.service

import java.lang.Long
import java.util.List

import org.apache.commons.collections.Closure
import org.apache.commons.collections.Factory
import org.apache.commons.collections.Transformer

import org.examproject.dto.PersonDto
import org.examproject.service.PersonService

import scala.collection.JavaConversions._

/**
 *
 * @author hiroxpepe
 */
class SimplePersonService(
    val idToPersonTransformer: Transformer, 
    val personsFactory: Factory,
    val savePersonClosure: Closure, 
    val deletePersonClosure: Closure 
) extends PersonService {
    
    // there is nothing of a logic here, it's just an adapter class..
    
    @Override
    def getPersonById(id: Long): PersonDto = {
        return idToPersonTransformer.transform(id).asInstanceOf[PersonDto]
    }

    @Override
    def searchPersons(): List[PersonDto] = {
        return personsFactory.create().asInstanceOf[List[PersonDto]]
    }

    @Override
    def savePerson(personDto: PersonDto) {
        savePersonClosure.execute(personDto)
    }

    @Override
    def deletePerson(personDto: PersonDto) {
        deletePersonClosure.execute(personDto)
    }

}
