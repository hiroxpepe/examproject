package com.hiroxpepe.dto

import java.util.Date

import scala.reflect.BeanProperty

/**
 * @author hiroxpepe
 */
trait PersonDto {
    
    @BeanProperty var id: java.lang.Long = _
    
    @BeanProperty var created: Date = _

    @BeanProperty var firstName: String = _

    @BeanProperty var lastName: String = _
    
}
