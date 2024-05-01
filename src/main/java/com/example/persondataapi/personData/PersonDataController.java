package com.example.persondataapi.personData;

import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/personData")
public class PersonDataController {

    private final PersonDataService personDataService;

    public PersonDataController(PersonDataService personDataService) {
        this.personDataService = personDataService;
    }

    @GetMapping("/{name}")
    public PersonGenderDTO getPersonGenderByName(@PathVariable String name) {
        return personDataService.getPersonGenderByName(name);
    }



}
