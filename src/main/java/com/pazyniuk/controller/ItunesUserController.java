package com.pazyniuk.controller;

import com.pazyniuk.DTO.ItunesUserDTO;
import com.pazyniuk.DTO.SongDTO;
import com.pazyniuk.domain.ItunesUser;
import com.pazyniuk.domain.Song;
import com.pazyniuk.exceptions.NoSuchObjectException;
import com.pazyniuk.exceptions.ReferencesPrensetException;
import com.pazyniuk.service.ItunesUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
public class ItunesUserController {

    @Autowired
    ItunesUserService itunesUserService;

    @GetMapping(value = "/api/v1/itunes_user/song/{songId}")
    public ResponseEntity<List<ItunesUserDTO>> getItunesUsersBySongId(@PathVariable long songId) throws NoSuchObjectException {
        List<ItunesUser> itunesUsers = itunesUserService.getItunesUsersBySong(songId);
        Link link = linkTo(methodOn(ItunesUserController.class).getAllItunesUsers()).withSelfRel();
        List<ItunesUserDTO> itunesUserDTOS = new ArrayList<>();
        for (ItunesUser entity: itunesUsers) {
            Link selfLink = new Link(link.getHref() + "/" + entity.getId()).withSelfRel();
            ItunesUserDTO itunesUserDTO = new ItunesUserDTO(entity, selfLink);
            itunesUserDTOS.add(itunesUserDTO);
        }
        return new ResponseEntity<>(itunesUserDTOS, HttpStatus.OK);
    }

    @GetMapping(value = "/api/v1/itunes_user/{userId}")
    public ResponseEntity<ItunesUserDTO> getItunesUser(@PathVariable long userId) throws NoSuchObjectException {
        ItunesUser itunesUser = itunesUserService.getItunesUser(userId);
        Link link = linkTo(methodOn(ItunesUserController.class).getItunesUser(userId)).withSelfRel();
        ItunesUserDTO itunesUserDTO = new ItunesUserDTO(itunesUser, link);
        return new ResponseEntity<>(itunesUserDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/api/v1/itunes_user")
    public ResponseEntity<List<ItunesUserDTO>> getAllItunesUsers() throws NoSuchObjectException {
        List<ItunesUser> itunesUsers = itunesUserService.getAllItunesUsers();
        Link link = linkTo(methodOn(ItunesUserController.class).getAllItunesUsers()).withSelfRel();
        List<ItunesUserDTO> itunesUserDTOS = new ArrayList<>();
        for (ItunesUser entity:itunesUsers) {
            Link selfLink = new Link(link.getHref() + "/" + entity.getId()).withSelfRel();
            ItunesUserDTO itunesUserDTO = new ItunesUserDTO(entity, selfLink);
            itunesUserDTOS.add(itunesUserDTO);
        }
        return new ResponseEntity<>(itunesUserDTOS, HttpStatus.OK);
    }

    @PostMapping(value = "/api/v1/itunes_user")
    public ResponseEntity<ItunesUserDTO> addItunesUser(@RequestBody ItunesUser itunesUser) throws NoSuchObjectException {
        itunesUserService.createItunesUser(itunesUser);
        Link link = linkTo(methodOn(ItunesUserController.class).getItunesUser(itunesUser.getId())).withSelfRel();
        ItunesUserDTO itunesUserDTO = new ItunesUserDTO(itunesUser, link);
        return new ResponseEntity<>(itunesUserDTO, HttpStatus.CREATED);
    }

    @PutMapping(value = "/api/v1/itunes_user/{userId}")
    public ResponseEntity<ItunesUserDTO> updateItunesUser(@RequestBody ItunesUser newItunesUser, @PathVariable long userId) throws NoSuchObjectException {
        itunesUserService.updateItunesUser(newItunesUser, userId);
        ItunesUser itunesUser = itunesUserService.getItunesUser(userId);
        Link link = linkTo(methodOn(ItunesUserController.class).getItunesUser(userId)).withSelfRel();
        ItunesUserDTO itunesUserDTO = new ItunesUserDTO(itunesUser, link);
        return new ResponseEntity<>(itunesUserDTO, HttpStatus.OK);
    }

    @DeleteMapping(value = "/api/v1/itunes_user/{userId}")
    public ResponseEntity deleteItunesUser(@PathVariable long userId) throws NoSuchObjectException, ReferencesPrensetException {
        itunesUserService.deleteItunesUser(userId);
        return new ResponseEntity(HttpStatus.OK);
    }
}
