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
