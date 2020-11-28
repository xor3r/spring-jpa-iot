package com.pazyniuk.DTO;

import com.pazyniuk.controller.ItunesUserController;
import com.pazyniuk.domain.ItunesUser;
import com.pazyniuk.domain.Song;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

public class ItunesUserDTO extends ResourceSupport {
    ItunesUser itunesUser;

    public ItunesUserDTO(ItunesUser itunesUser, Link selfLink) {
        this.itunesUser = itunesUser;
        add(selfLink);
    }

    public long getItunesUserId() {
        return itunesUser.getId();
    }

    public String getItunesUserUsername() {
        return itunesUser.getUsername();
    }

    public String getItunesUserPassword() {
        return itunesUser.getPassword();
    }

    public String getItunesUserJoinedDate() {
        return itunesUser.getJoinedDate();
    }

    public String getItunesUserName() {
        return itunesUser.getName();
    }

    public String getItunesUserSurname() {
        return itunesUser.getSurname();
    }

    public String getItunesUserGender() {
        return itunesUser.getGender().getGenderType();
    }

    public String getItunesUserCreditCard() {
        return itunesUser.getCreditCard().getNumber();
    }

    public List<String> getItunesUserSongs() {
        return itunesUser.getUserSongs().stream().map( Song::getName ).collect( Collectors.toList() );
    }
}
