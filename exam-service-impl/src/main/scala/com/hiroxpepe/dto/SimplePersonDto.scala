package com.hiroxpepe.dto

import java.util.Date

import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

/**
 * just simple extends only..
 * @author hiroxpepe
 */
@Component
@Scope(value="prototype")
class SimplePersonDto() extends PersonDto {
}
