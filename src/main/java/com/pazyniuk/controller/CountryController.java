package com.pazyniuk.controller;

import com.pazyniuk.DTO.CountryDTO;
import com.pazyniuk.domain.Country;
import com.pazyniuk.exceptions.NoSuchObjectException;
import com.pazyniuk.exceptions.ReferencesPrensetException;
import com.pazyniuk.service.CountryService;
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
public class CountryController {

    @Autowired
    CountryService countryService;

    @GetMapping(value = "/api/v1/country/{countryId}")
    public ResponseEntity<CountryDTO> getCountry(@PathVariable long countryId) throws NoSuchObjectException {
        Country country = countryService.getCountry(countryId);
        Link link = linkTo(methodOn(CountryController.class).getCountry(countryId)).withSelfRel();
        CountryDTO countryDTO = new CountryDTO(country, link);
        return new ResponseEntity<>(countryDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/api/v1/country")
    public ResponseEntity<List<CountryDTO>> getAllCountries() throws NoSuchObjectException {
        List<Country> countries = countryService.getAllCountries();
        Link link = linkTo(methodOn(CountryController.class).getAllCountries()).withSelfRel();
        List<CountryDTO> countryDTOS = new ArrayList<>();
        for (Country entity:countries) {
            Link selfLink = new Link(link.getHref() + "/" + entity.getId()).withSelfRel();
            CountryDTO countryDTO = new CountryDTO(entity, selfLink);
            countryDTOS.add(countryDTO);
        }
        return new ResponseEntity<>(countryDTOS, HttpStatus.OK);
    }

    @PostMapping(value = "/api/v1/country")
    public ResponseEntity<CountryDTO> addCountry(@RequestBody Country country) throws NoSuchObjectException {
        countryService.createCountry(country);
        Link link = linkTo(methodOn(CountryController.class).getCountry(country.getId())).withSelfRel();
        CountryDTO countryDTO = new CountryDTO(country, link);
        return new ResponseEntity<>(countryDTO, HttpStatus.CREATED);
    }

    @PutMapping(value = "/api/v1/country/{countryId}")
    public ResponseEntity<CountryDTO> updateCountry(@RequestBody Country newCountry, @PathVariable long countryId) throws NoSuchObjectException {
        countryService.updateCountry(newCountry, countryId);
        Country country = countryService.getCountry(countryId);
        Link link = linkTo(methodOn(CountryController.class).getCountry(countryId)).withSelfRel();
        CountryDTO countryDTO = new CountryDTO(country, link);
        return new ResponseEntity<>(countryDTO, HttpStatus.OK);
    }

    @DeleteMapping(value = "/api/v1/country/{countryId}")
    public ResponseEntity deleteCountry(@PathVariable long countryId) throws NoSuchObjectException, ReferencesPrensetException {
        countryService.deleteCountry(countryId);
        return new ResponseEntity(HttpStatus.OK);
    }
}
