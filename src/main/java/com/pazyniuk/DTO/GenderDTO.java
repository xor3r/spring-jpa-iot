package com.pazyniuk.DTO;

import com.pazyniuk.domain.Artist;
import com.pazyniuk.domain.Gender;
import com.pazyniuk.domain.ItunesUser;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

public class GenderDTO extends ResourceSupport {
    Gender gender;

    public GenderDTO(Gender gender, Link selfLink) {
        this.gender = gender;
        add(selfLink);
    }

    public long getGenderDTO() {
        return gender.getId();
    }

    public String getGenderType() {
        return gender.getGenderType();
    }

    public List<String> getGenderArtists() {
        return gender.getArtists().stream().map( Artist::getName ).collect( Collectors.toList() );
    }

    public List<String> getGenderUsers() {
        return gender.getItunesUsers().stream().map( ItunesUser::getUsername ).collect( Collectors.toList() );
    }
}
