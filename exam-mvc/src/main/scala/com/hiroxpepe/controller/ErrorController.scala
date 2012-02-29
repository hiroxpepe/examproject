package com.hiroxpepe.controller

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

import scala.collection.JavaConversions._

/**
 * an error controller class of the application.
 *
 * @author hiroxpepe
 */
@Controller
class ErrorController {

    private val LOG: Logger = LoggerFactory.getLogger(classOf[ErrorController])
    
    private val ERROR_VIEW_KEY: String = "error"
    
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
        LOG.error("error")
        // TODO: do something...
    }
    
}
