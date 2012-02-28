package com.hiroxpepe.dto

import java.lang.Long
import java.util.Date

import scala.reflect.BeanProperty

/**
 * @author hiroxpepe
 */
trait PersonDto {
    
    @BeanProperty var id: Long = _
    
    @BeanProperty var created: Date = _

    @BeanProperty var firstName: String = _

    @BeanProperty var lastName: String = _
    
}
