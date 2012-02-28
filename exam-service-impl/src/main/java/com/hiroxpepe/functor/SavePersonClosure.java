package com.hiroxpepe.functor;

import java.util.Date;
import javax.inject.Inject;

import org.apache.commons.collections.Closure;
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
public class SavePersonClosure implements Closure {
    
    private static final Logger LOG = LoggerFactory.getLogger(SavePersonClosure.class);

    @Inject
    private final ApplicationContext context = null;
    
    @Inject
    private final Mapper mapper = null;
    
    @Inject
    private final PersonRepository repository = null;

    private SavePersonClosure() {
    }
    
    @Override
    public void execute(Object o) {
        LOG.debug("called.");
        PersonDto personDto = (PersonDto) o;
        try {
            save(personDto);
        } catch (RuntimeException re) {
            LOG.error("RuntimeException occurred. " + re.getMessage());
            throw re;
        }
    }
    
    private void save(PersonDto personDto) {
        LOG.debug("called save.");

        // if dto is new one, create a new date.
        if (personDto.getCreated() == null) {
            personDto.setCreated(new Date());
            LOG.debug("set personDto new Date.");
        }
        
        // object mapping by dozer.
        Person person = context.getBean(Person.class);
        mapper.map(personDto, person);

        // push the entity to repository.
        try {
            repository.save(person);
            LOG.debug("save a person.");
        } catch (Exception e) {
            throw new RuntimeException("failed save a person.", e);
        }
        
        // if dto is new one, set the entity's ID.
        if (personDto.getId() == null) {
            personDto.setId(person.getId());
        }
    }

}
