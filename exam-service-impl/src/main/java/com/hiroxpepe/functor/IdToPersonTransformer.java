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
    protected final PersonRepository repository = null;

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
        // TODO: why null?
        if (o != null) {
            
            // get the entity from repository.
            Long id = Long.valueOf(o.toString());
            Person person = (Person) repository.findOne(id);
            
            // object mapping by dozer.
            PersonDto dto = context.getBean(PersonDto.class);
            mapper.map(person, dto);
              
            // return a mapped dto.
            return dto;
        } else {
            // return a new dto.
            return context.getBean(PersonDto.class);
        }
    }
    
}