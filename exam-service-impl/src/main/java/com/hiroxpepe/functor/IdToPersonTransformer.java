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

import org.apache.commons.collections.Transformer;
import org.dozer.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;

import com.hiroxpepe.dto.PersonDto;
import com.hiroxpepe.entity.Person;
import com.hiroxpepe.repository.PersonRepository;

/**
 * @author hiroxpepe
 */
public class IdToPersonTransformer implements Transformer {

    private static final Logger LOG = LoggerFactory.getLogger(IdToPersonTransformer.class);

    @Inject
    private final ApplicationContext context = null;
    
    @Inject
    private final Mapper mapper = null;
    
    @Inject
    private final PersonRepository repository = null;

    private IdToPersonTransformer() {
    }

    @Override
    public Object transform(Object o) {
        LOG.debug("called.");
        try {
            return getPersonDto(o);
        } catch (RuntimeException re) {
            LOG.error("RuntimeException occurred. " + re.getMessage());
            throw re;
        }
    }

    private PersonDto getPersonDto(Object o) {
        
        // if ID is offered, find the entity from repository, and mapping to dto.
        if (o != null) {        
            // get the entity from repository.
            Long id = Long.valueOf(o.toString());
            Person person = (Person) repository.findOne(id);
            
            // object mapping by dozer.
            PersonDto dto = context.getBean(PersonDto.class);
            mapper.map(person, dto);
              
            // return a mapped dto.
            return dto;
            
        // if the new request, a null ID will be provided.
        } else {
            // return a new dto.
            return context.getBean(PersonDto.class);
        }
    }
    
}