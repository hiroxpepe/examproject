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

package org.examproject.controller

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
     * if an error is occured, this method will be called.
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
     * move to the view for an error.
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
