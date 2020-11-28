package com.pazyniuk.controller;

import com.pazyniuk.DTO.AlbumDTO;
import com.pazyniuk.domain.Album;
import com.pazyniuk.exceptions.NoSuchObjectException;
import com.pazyniuk.exceptions.ReferencesPrensetException;
import com.pazyniuk.service.AlbumService;
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
public class AlbumController {

    @Autowired
    AlbumService albumService;

    @GetMapping(value = "/api/v1/album/{albumId}")
    public ResponseEntity<AlbumDTO> getAlbum(@PathVariable long albumId) throws NoSuchObjectException {
        Album album = albumService.getAlbum(albumId);
        Link link = linkTo(methodOn(AlbumController.class).getAlbum(albumId)).withSelfRel();
        AlbumDTO albumDTO = new AlbumDTO(album, link);
        return new ResponseEntity<>(albumDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/api/v1/album")
    public ResponseEntity<List<AlbumDTO>> getAllAlbums() throws NoSuchObjectException {
        List<Album> albums = albumService.getAllAlbums();
        Link link = linkTo(methodOn(AlbumController.class).getAllAlbums()).withSelfRel();
        List<AlbumDTO> albumDTOS = new ArrayList<>();
        for (Album entity:albums) {
            Link selfLink = new Link(link.getHref() + "/" + entity.getId()).withSelfRel();
            AlbumDTO albumDTO = new AlbumDTO(entity, selfLink);
            albumDTOS.add(albumDTO);
        }
        return new ResponseEntity<>(albumDTOS, HttpStatus.OK);
    }

    @PostMapping(value = "/api/v1/album")
    public ResponseEntity<AlbumDTO> addAlbum(@RequestBody Album album) throws NoSuchObjectException {
        albumService.createAlbum(album);
        Link link = linkTo(methodOn(AlbumController.class).getAlbum(album.getId())).withSelfRel();
        AlbumDTO albumDTO = new AlbumDTO(album, link);
        return new ResponseEntity<>(albumDTO, HttpStatus.CREATED);
    }

    @PutMapping(value = "/api/v1/album/{albumId}")
    public ResponseEntity<AlbumDTO> updateAlbum(@RequestBody Album newAlbum, @PathVariable long albumId) throws NoSuchObjectException {
        albumService.updateAlbum(newAlbum, albumId);
        Album album = albumService.getAlbum(albumId);
        Link link = linkTo(methodOn(AlbumController.class).getAlbum(albumId)).withSelfRel();
        AlbumDTO albumDTO = new AlbumDTO(album, link);
        return new ResponseEntity<>(albumDTO, HttpStatus.OK);
    }

    @DeleteMapping(value = "/api/v1/album/{albumId}")
    public ResponseEntity deleteAlbum(@PathVariable long albumId) throws NoSuchObjectException, ReferencesPrensetException {
        albumService.deleteAlbum(albumId);
        return new ResponseEntity(HttpStatus.OK);
    }
}
