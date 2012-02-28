package com.hiroxpepe.controller

import java.lang.Long
import java.util.ArrayList
import java.util.List
import javax.inject.Inject

import org.dozer.Mapper
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.context.ApplicationContext
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam

import com.hiroxpepe.dto.PersonDto
import com.hiroxpepe.form.PersonForm
import com.hiroxpepe.service.PersonService

import scala.collection.JavaConversions._

/**
 * This controller class exposes the following URLs:
 * jetty:run
 * http://localhost:8080/
 *
 * @author hiroxpepe
 */
@Controller
class PersonController {
    
    private val LOG: Logger = LoggerFactory.getLogger(classOf[PersonController])

    private val SEARCH_VIEW_KEY: String = "redirect:search.html"
    
    private val ERROR_VIEW_KEY: String = "error"
    
    @Inject
    private val context: ApplicationContext = null

    @Inject
    private val mapper: Mapper = null

    @Inject
    private val personService: PersonService = null
    
    ///////////////////////////////////////////////////////////////////////////
    // public methods
    
    ///////////////////////////////////////////////////////////////////////////
    /**
     * for every request for this controller, this will 
     * create a person instance for the form.
     */
    @ModelAttribute
    def createForm(
        @RequestParam(required=false) id: Long 
    )
    : PersonForm = {
        LOG.debug("you get a form object from service object.")
       
        // if [id] is null, get a new dto object from service. 
        val  personDto: PersonDto = personService.getPersonById(id)

        // object mapping [dto object] to [form object] by dozer.
        val personForm: PersonForm = context.getBean(classOf[PersonForm])
        mapper.map(personDto, personForm)
        
        return personForm
    }

    ///////////////////////////////////////////////////////////////////////////
    /**
     * person form request.
     * expected HTTP GET and request '/person/form'.
     */
    @RequestMapping(
        value=Array("/person/form"),
        method=Array(RequestMethod.GET)
    )
    def showFormViaGet() = {
        LOG.debug("request '/person/form' via GET.")
    }
    
    ///////////////////////////////////////////////////////////////////////////
    /**
     * saves a person.
     * expected HTTP POST and request '/person/form'.
     */
    @RequestMapping(
        value=Array("/person/form"),
        method=Array(RequestMethod.POST)
    )
    def showFormViaPost(
        personForm: PersonForm,
        model: Model
    ) = {
        LOG.debug("request '/person/form' via POST.")
        
        // object mapping [form object] to [dto object] by dozer.
        val personDto: PersonDto = context.getBean(classOf[PersonDto])
        mapper.map(personForm, personDto)

        // save a dto object instead of form object.
        personService.savePerson(personDto)

        // add a message to model object, with message key.
        model.addAttribute(
            "statusMessageKey",
            "person.form.msg.success"
        )
    }

    ///////////////////////////////////////////////////////////////////////////
    /**
     * deletes a person.
     * expected HTTP POST and request '/person/delete'.
     */
    @RequestMapping(
        value=Array("/person/delete"),
        method=Array(RequestMethod.POST)
    )
    def delete(
        personForm: PersonForm 
    )
    : String = {     
        // object mapping [from object] to [dto object] by dozer.
        val personDto: PersonDto = context.getBean(classOf[PersonDto])
        mapper.map(personForm, personDto)

        // delete as a entity
        personService.deletePerson(personDto)

        return SEARCH_VIEW_KEY
    }

    ///////////////////////////////////////////////////////////////////////////
    /**
     * searches for all persons and returns them in a List.
     * expected HTTP GET and request '/person/search'.
     */
    @RequestMapping(
        value=Array("/person/search"),
        method=Array(RequestMethod.GET)
    )
    @ModelAttribute("persons")
    def search() 
    : List[PersonForm] =  {
        
        // object mapping [dto object] to [from object] by dozer.
        val personFormList: List[PersonForm] = new ArrayList[PersonForm]()
        val personDtoList: List[PersonDto] = personService.searchPersons()
        for (personDto: PersonDto <- personDtoList) {
            val personForm: PersonForm = context.getBean(classOf[PersonForm])
            mapper.map(personDto, personForm)
            personFormList.add(personForm)
        }
        return personFormList;
    }

    ///////////////////////////////////////////////////////////////////////////
    /**
     * if a error is occured, this method will be called.
     */
    @ExceptionHandler
    def handleException(
        e: Exception
    )
    : String = {
        return ERROR_VIEW_KEY;
    }
    
    ///////////////////////////////////////////////////////////////////////////
    /**
     * move to the view for a error.
     */
    @RequestMapping(
        value=Array("/error"),
        method=Array(RequestMethod.GET)
    )
    def onError() = {
        LOG.error("request '/error'")
        // TODO: do something...
    }
}
