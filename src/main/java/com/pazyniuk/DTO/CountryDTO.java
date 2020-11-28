package com.pazyniuk.DTO;

import com.pazyniuk.controller.ArtistController;
import com.pazyniuk.domain.Artist;
import com.pazyniuk.domain.Country;
import com.pazyniuk.exceptions.NoSuchObjectException;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

public class CountryDTO extends ResourceSupport {
    Country country;

    public CountryDTO(Country country, Link selfLink) throws NoSuchObjectException {
        this.country = country;
        add(selfLink);
        add(linkTo(methodOn(ArtistController.class).getArtistsByCountryId(country.getId())).withRel("artists"));
    }

    public long getCountryId() {
        return country.getId();
    }

    public String getCountryName() {
        return country.getName();
    }

    public List<String> getCountryArtists() {
        return country.getArtists().stream().map( Artist::getName ).collect( Collectors.toList() );
    }
}
