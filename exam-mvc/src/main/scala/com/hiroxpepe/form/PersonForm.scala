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

package com.hiroxpepe.form

import java.lang.Long
import java.util.Date

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import scala.reflect.BeanProperty

/**
 * @author hiroxpepe
 */
@Component(value="personForm")
@Scope(value="prototype")
class PersonForm {

    @BeanProperty
    var id: Long = _

    @BeanProperty
    var createdDate: Date = _

    @BeanProperty
    var firstName: String = _

    @BeanProperty
    var lastName: String = _
    
}
