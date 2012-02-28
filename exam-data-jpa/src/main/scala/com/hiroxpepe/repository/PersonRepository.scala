package com.hiroxpepe.repository

import java.lang.Long
import java.util.List

import org.springframework.data.jpa.repository.JpaRepository

import com.hiroxpepe.entity.Person

/**
 * @author hiroxpepe
 */
trait PersonRepository extends JpaRepository[Person, Long] {
}