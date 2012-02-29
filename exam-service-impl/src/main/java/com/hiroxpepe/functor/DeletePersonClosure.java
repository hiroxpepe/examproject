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

package com.hiroxpepe.functor;

import javax.inject.Inject;

import org.apache.commons.collections.Closure;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hiroxpepe.dto.PersonDto;
import com.hiroxpepe.entity.Person;
import com.hiroxpepe.repository.PersonRepository;

/**
 * @author hiroxpepe
 */
public class DeletePersonClosure  implements Closure {
    
    private static final Logger LOG = LoggerFactory.getLogger(DeletePersonClosure.class);
    
    @Inject
    private final PersonRepository repository = null;

    private DeletePersonClosure() {
    }
    
    @Override
    public void execute(Object o) {
        LOG.debug("called.");
        PersonDto personDto = (PersonDto) o;
        try {
            delete(personDto);
        } catch (RuntimeException re) {
            LOG.error("RuntimeException occurred. " + re.getMessage());
            throw re;
        }
    }
    
    private void delete(PersonDto personDto) {
        try {
            // to search the repository for delete.
            Person person = (Person) repository.findOne(personDto.getId());
            repository.delete(person.getId());
        } catch (Exception e) {
            throw new RuntimeException("delete failed. ", e);
        }
    }

}
