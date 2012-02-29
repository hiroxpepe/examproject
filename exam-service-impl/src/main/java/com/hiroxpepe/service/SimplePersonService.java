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

package com.hiroxpepe.service;

import java.util.List;

import org.apache.commons.collections.Closure;
import org.apache.commons.collections.Factory;
import org.apache.commons.collections.Transformer;

import com.hiroxpepe.dto.PersonDto;

/**
 *
 * @author hiroxpepe
 */
public class SimplePersonService implements PersonService {
    
    // logic is not nothing, it is just an adapter class..
    
    private final Transformer idToPersonTransformer;
    
    private final Factory personsFactory;
    
    private final Closure savePersonClosure;
     
    private final Closure deletePersonClosure;
    
    private SimplePersonService(
        Transformer idToPersonTransformer,
        Factory personsFactory,
        Closure savePersonClosure,
        Closure deletePersonClosure
    ) {
        this.idToPersonTransformer = idToPersonTransformer;
        this.personsFactory = personsFactory;
        this.savePersonClosure = savePersonClosure;
        this.deletePersonClosure = deletePersonClosure;
    }
    
    @Override
    public PersonDto getPersonById(Long id) {
        return (PersonDto) idToPersonTransformer.transform(id);
    }

    @Override
    public List<PersonDto> searchPersons() {
        return (List<PersonDto>) personsFactory.create();
    }

    @Override
    public void savePerson(PersonDto personDto) {
        savePersonClosure.execute(personDto);
    }

    @Override
    public void deletePerson(PersonDto personDto) {
        deletePersonClosure.execute(personDto);
    }

}
