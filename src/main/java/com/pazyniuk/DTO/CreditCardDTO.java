package com.pazyniuk.DTO;


import com.pazyniuk.domain.CreditCard;
import com.pazyniuk.domain.ItunesUser;
import com.pazyniuk.exceptions.NoSuchObjectException;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

public class CreditCardDTO extends ResourceSupport {
    CreditCard creditCard;

    public CreditCardDTO(CreditCard creditCard, Link selfLink) throws NoSuchObjectException {
        this.creditCard = creditCard;
        add(selfLink);
    }

    public long getCreditCardId() {
        return creditCard.getId();
    }

    public String getCreditCardNumber() {
        return creditCard.getNumber();
    }

    public String getCreditCardUser() {
        return creditCard.getItunesUser().getUsername();
    }
}

