package com.hiroxpepe.service

import java.util.List

import com.hiroxpepe.dto.PersonDto

/**
 * @author hiroxpepe
 */
trait PersonService {

    def deletePerson(personDto: PersonDto)

    def getPersonById(id: java.lang.Long): PersonDto

    def savePerson(personDto: PersonDto)

    def searchPersons(): List[PersonDto]

}
