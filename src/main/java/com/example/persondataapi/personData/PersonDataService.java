package com.example.persondataapi.personData;


import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;



@Service
public class PersonDataService {

    private final WebClient webClient;

    String GENDER_URL = "https://api.genderize.io";


    public  PersonDataService() {

        this.webClient = WebClient.create(GENDER_URL);

    }

    public PersonGenderDTO getPersonGender(PersonData personData) {
        String fullName = personData.getFullName();
        return getPersonGenderByName(fullName);
    }

    public PersonGenderDTO getPersonGenderByName(String name) {
        PersonGenderDTO personGenderResponse = webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .queryParam("name", name)
                        .build())
                .retrieve()
                .bodyToMono(PersonGenderDTO.class)
                .block();
        System.out.println(personGenderResponse);
        return personGenderResponse;
    }
}
