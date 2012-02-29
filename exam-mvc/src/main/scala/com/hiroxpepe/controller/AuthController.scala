package com.hiroxpepe.controller

//import java.util.ArrayList
//import java.util.List

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

import scala.collection.JavaConversions._

/**
 * an authentication controller class of the application.
 *
 * @author hiroxpepe
 */
@Controller
class AuthContoller {

    private val LOG: Logger = LoggerFactory.getLogger(classOf[AuthContoller])
    
    ///////////////////////////////////////////////////////////////////////////
    /**
     * login this application.
     */
    @RequestMapping(
        value=Array("/login"),
        method=Array(RequestMethod.GET)
    )
    def login() = {
        LOG.debug("login")
        // TODO: do something..
    }
    
    ///////////////////////////////////////////////////////////////////////////
    /**
     * logout this application.
     */
    @RequestMapping(
        value=Array("/logout"),
        method=Array(RequestMethod.GET)
    )
    def logout() = {
        LOG.debug("logout")
        // TODO: do something..
    }
    
    ///////////////////////////////////////////////////////////////////////////
    /**
     * a handler of the application, that if the authentication is denied.
     */
    @RequestMapping(
        value=Array("/deny"),
        method=Array(RequestMethod.GET)
    )
    def deny() = {
        LOG.debug("deny")
        // TODO: do something..
    }
    
}
