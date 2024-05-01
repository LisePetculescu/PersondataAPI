package com.example.persondataapi.personData;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonDataServiceTest {

    @Test
    void getPersonGender() {
    }

    @Test
    void getPersonGenderByName() {

        // arrange
        PersonDataService personDataService = new PersonDataService();

        // act
        PersonGenderDTO personName = personDataService.getPersonGenderByName("John");


        // assert
        assertEquals("John", personName.name());
        assertEquals("male", personName.gender());

    }
}