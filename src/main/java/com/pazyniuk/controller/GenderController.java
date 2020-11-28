package com.pazyniuk.controller;

import com.pazyniuk.DTO.GenderDTO;
import com.pazyniuk.domain.Gender;
import com.pazyniuk.exceptions.NoSuchObjectException;
import com.pazyniuk.exceptions.ReferencesPrensetException;
import com.pazyniuk.service.GenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
public class GenderController {

    @Autowired
    GenderService genderService;

    @GetMapping(value = "/api/v1/gender/{genderId}")
    public ResponseEntity<GenderDTO> getGender(@PathVariable long genderId) throws NoSuchObjectException {
        Gender gender = genderService.getGender(genderId);
        Link link = linkTo(methodOn(GenderController.class).getGender(genderId)).withSelfRel();
        GenderDTO genderDTO = new GenderDTO(gender, link);
        return new ResponseEntity<>(genderDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/api/v1/gender")
    public ResponseEntity<List<GenderDTO>> getAllGenders() throws NoSuchObjectException {
        List<Gender> genders = genderService.getAllGenders();
        Link link = linkTo(methodOn(GenderController.class).getAllGenders()).withSelfRel();
        List<GenderDTO> genderDTOS = new ArrayList<>();
        for (Gender entity:genders) {
            Link selfLink = new Link(link.getHref() + "/" + entity.getId()).withSelfRel();
            GenderDTO genderDTO = new GenderDTO(entity, selfLink);
            genderDTOS.add(genderDTO);
        }
        return new ResponseEntity<>(genderDTOS, HttpStatus.OK);
    }

    @PostMapping(value = "/api/v1/gender")
    public ResponseEntity<GenderDTO> addGender(@RequestBody Gender gender) throws NoSuchObjectException {
        genderService.createGender(gender);
        Link link = linkTo(methodOn(GenderController.class).getGender(gender.getId())).withSelfRel();
        GenderDTO genderDTO = new GenderDTO(gender, link);
        return new ResponseEntity<>(genderDTO, HttpStatus.CREATED);
    }

    @PutMapping(value = "/api/v1/gender/{genderId}")
    public ResponseEntity<GenderDTO> updateGender(@RequestBody Gender newGender, @PathVariable long genderId) throws NoSuchObjectException {
        genderService.updateGender(newGender, genderId);
        Gender gender = genderService.getGender(genderId);
        Link link = linkTo(methodOn(GenderController.class).getGender(genderId)).withSelfRel();
        GenderDTO genderDTO = new GenderDTO(gender, link);
        return new ResponseEntity<>(genderDTO, HttpStatus.OK);
    }

    @DeleteMapping(value = "/api/v1/gender/{genderId}")
    public ResponseEntity deleteGender(@PathVariable long genderId) throws NoSuchObjectException, ReferencesPrensetException {
        genderService.deleteGender(genderId);
        return new ResponseEntity(HttpStatus.OK);
    }
}
