package com.hiroxpepe.functor;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

import org.apache.commons.collections.Factory;
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
public class PersonsFactory implements Factory {

    private static final Logger LOG = LoggerFactory.getLogger(PersonsFactory.class);

    @Inject
    private final ApplicationContext context = null;
    
    @Inject
    private final Mapper mapper = null;
    
    @Inject
    private final PersonRepository repository = null;

    private PersonsFactory() {
    }

    @Override
    public Object create() {
        LOG.debug("called.");
        try {
            return searchPersons();
        } catch (RuntimeException re) {
            LOG.error("RuntimeException occurred. " + re.getMessage());
            throw re;
        }
    }

    private List<PersonDto> searchPersons() {
        
        // create the new dto list.
        List<PersonDto> dtoList = new ArrayList<PersonDto>();
        
        // get the entities list from repository.
        List<Person> list = repository.findAll();
        for (Person person : list) {
            
            // object mapping by dozer.
            PersonDto dto = context.getBean(PersonDto.class);
            mapper.map(person, dto);     
            
            // add to dto list.
            dtoList.add(dto);
        }
        return dtoList;
    }

}
