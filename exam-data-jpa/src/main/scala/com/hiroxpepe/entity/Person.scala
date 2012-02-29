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

package com.hiroxpepe.entity

import java.lang.Long
import java.io.Serializable
import java.util.Date
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table
import javax.persistence.Temporal

import org.springframework.stereotype.Component

import scala.reflect.BeanProperty

/**
 * @author hiroxpepe
 */
@Entity
@Table(name="person")
@Component
class Person extends Serializable {
    
    val serialVersionUID: Long = -8712872385957386182L

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(unique=true)
    @BeanProperty
    var id: Long = _

    @Column(name="created")
    @Temporal(javax.persistence.TemporalType.DATE)
    @BeanProperty
    var created: Date = _

    @Column(name="first_name")
    @BeanProperty
    var firstName: String = _

    @Column(name="last_name")
    @BeanProperty
    var lastName: String = _
    
}
