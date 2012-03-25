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
