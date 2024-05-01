package com.example.persondataapi.personData;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PersonData {
    private String firstName;
    private String middleName;
    private String lastName;
    private String gender;
    private float genderProbability;
//    private int age;
//    private float ageProbability;
//    private String country;
//    private float countryProbability;


    public String getFullName() {
        return getFirstName() + " " + (getMiddleName() != null ? getMiddleName() + " " : "") + getLastName();
    }

    public void setFullName(String fullName) {
        if( fullName == null || fullName.isBlank() || fullName.isEmpty() ) {
            System.out.println("Invalid name");
            return;
        }
        String[] names = fullName.split(" ");
        if (names.length == 0 || names[0].isBlank() || names[names.length - 1].isBlank()) {
            System.out.println("Invalid name");
            return;
        }
        setFirstName(names[0]) ;
        if (names.length == 3) {
            setMiddleName(names[1]);
            setLastName(names[2]);
        } else if (names.length == 2) {
            setMiddleName(null);
            setLastName(names[1]);
        } else if (names.length >= 4) {
            String middleName = names[1];
            for (int i = 2; i < names.length - 1; i++) {
                middleName += " " + names[i];
            }
            setMiddleName(middleName);
            setLastName(names[names.length - 1]);
        } else {
            setMiddleName(null);
            setLastName(null);
        }
    }
}
