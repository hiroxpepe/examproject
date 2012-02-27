//package com.hiroxpepe;
//
//import java.util.Date;
//import java.util.List;
//import javax.inject.Inject;
//
//import com.hiroxpepe.entity.Person;
//import com.hiroxpepe.repository.PersonRepository;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNotNull;
//import static org.junit.Assert.assertNull;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
///**
// * @author hiroxpepe
// */
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration("test-app-config.xml")
//public class SimplePersonTest {
//
//	@Inject
//	private PersonRepository repository;
//	
//	@Test
//	public void simpleCrudTest() {
//		System.out.println("simpleCrudTest");
//		Long entityId = null;
//
//        Person entity1 = new Person();
//        entity1.setCreated(new Date());
//        entity1.setFirstName("AAA");
//        entity1.setLastName("BBB");
//
//        // test save
//        System.out.println("test save.");
//        repository.save(entity1);
//        assertNotNull(entity1.getId());
//
//        // test find
//        System.out.println("test find.");
//        entityId = entity1.getId();
//        entity1 = repository.findOne(entityId);
//        assertEquals("AAA", entity1.getFirstName());
//        assertEquals("BBB", entity1.getLastName());
//
//        // test findAll
//        System.out.println("test findAll.");
//        List<Person> personList = repository.findAll();
//        System.out.println("person count is " + personList.size());
//        assertNotNull(personList);
//        assertEquals(1, personList.size());
//
//        // test delete
//        System.out.println("test delete.");
//        repository.delete(entity1);
//        entityId = entity1.getId();
//        Person isLive = repository.findOne(entityId);
//        assertNull(isLive);
//	}
//  
//}
