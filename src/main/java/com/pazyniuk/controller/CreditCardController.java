package com.pazyniuk.controller;

import com.pazyniuk.DTO.CreditCardDTO;
import com.pazyniuk.domain.CreditCard;
import com.pazyniuk.exceptions.NoSuchObjectException;
import com.pazyniuk.exceptions.ReferencesPrensetException;
import com.pazyniuk.service.CreditCardService;
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
public class CreditCardController {

    @Autowired
    CreditCardService creditCardService;

    @GetMapping(value = "/api/v1/credit_card/{creditCardId}")
    public ResponseEntity<CreditCardDTO> getCreditCard(@PathVariable long creditCardId) throws NoSuchObjectException {
        CreditCard creditCard = creditCardService.getCreditCard(creditCardId);
        Link link = linkTo(methodOn(CreditCardController.class).getCreditCard(creditCardId)).withSelfRel();
        CreditCardDTO creditCardDTO = new CreditCardDTO(creditCard, link);
        return new ResponseEntity<>(creditCardDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/api/v1/credit_card")
    public ResponseEntity<List<CreditCardDTO>> getAllCreditCards() throws NoSuchObjectException {
        List<CreditCard> creditCards = creditCardService.getAllCreditCards();
        Link link = linkTo(methodOn(CreditCardController.class).getAllCreditCards()).withSelfRel();
        List<CreditCardDTO> creditCardDTOS = new ArrayList<>();
        for (CreditCard entity:creditCards) {
            Link selfLink = new Link(link.getHref() + "/" + entity.getId()).withSelfRel();
            CreditCardDTO creditCardDTO = new CreditCardDTO(entity, selfLink);
            creditCardDTOS.add(creditCardDTO);
        }
        return new ResponseEntity<>(creditCardDTOS, HttpStatus.OK);
    }

    @PostMapping(value = "/api/v1/credit_card")
    public ResponseEntity<CreditCardDTO> addCreditCard(@RequestBody CreditCard creditCard) throws NoSuchObjectException {
        creditCardService.createCreditCard(creditCard);
        Link link = linkTo(methodOn(CreditCardController.class).getCreditCard(creditCard.getId())).withSelfRel();
        CreditCardDTO creditCardDTO = new CreditCardDTO(creditCard, link);
        return new ResponseEntity<>(creditCardDTO, HttpStatus.CREATED);
    }

    @PutMapping(value = "/api/v1/credit_card/{creditCardId}")
    public ResponseEntity<CreditCardDTO> updateCreditCard(@RequestBody CreditCard newCreditCard, @PathVariable long creditCardId) throws NoSuchObjectException {
        creditCardService.updateCreditCard(newCreditCard, creditCardId);
        CreditCard creditCard = creditCardService.getCreditCard(creditCardId);
        Link link = linkTo(methodOn(CreditCardController.class).getCreditCard(creditCardId)).withSelfRel();
        CreditCardDTO creditCardDTO = new CreditCardDTO(creditCard, link);
        return new ResponseEntity<>(creditCardDTO, HttpStatus.OK);
    }

    @DeleteMapping(value = "/api/v1/credit_card/{creditCardId}")
    public ResponseEntity deleteCreditCard(@PathVariable long creditCardId) throws NoSuchObjectException, ReferencesPrensetException {
        creditCardService.deleteCreditCard(creditCardId);
        return new ResponseEntity(HttpStatus.OK);
    }
}
