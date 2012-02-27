package com.hiroxpepe.form

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
    var id: java.lang.Long = _

    @BeanProperty
    var createdDate: Date = _

    @BeanProperty
    var firstName: String = _

    @BeanProperty
    var lastName: String = _
    
}
