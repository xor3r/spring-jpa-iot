package com.pazyniuk.controller;

import com.pazyniuk.DTO.SongDTO;
import com.pazyniuk.domain.Song;
import com.pazyniuk.exceptions.NoSuchObjectException;
import com.pazyniuk.exceptions.ReferencesPrensetException;
import com.pazyniuk.service.SongService;
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
public class SongController {

    @Autowired
    SongService songService;

    @GetMapping(value = "/api/v1/song/album/{albumId}")
    public ResponseEntity<List<SongDTO>> getSongsByAlbumId(@PathVariable long albumId) throws NoSuchObjectException {
        List<Song> songs = songService.getSongsByAlbumId(albumId);
        Link link = linkTo(methodOn(SongController.class).getAllSongs()).withSelfRel();
        List<SongDTO> songDTOS = new ArrayList<>();
        for (Song entity: songs) {
            Link selfLink = new Link(link.getHref() + "/" + entity.getId()).withSelfRel();
            SongDTO songDTO = new SongDTO(entity, selfLink);
            songDTOS.add(songDTO);
        }
        return new ResponseEntity<>(songDTOS, HttpStatus.OK);
    }

    @GetMapping(value = "/api/v1/song/record_label/{recordLabelId}")
    public ResponseEntity<List<SongDTO>> getSongsByRecordLabelId(@PathVariable long recordLabelId) throws NoSuchObjectException {
        List<Song> songs = songService.getSongsByRecordLabelId(recordLabelId);
        Link link = linkTo(methodOn(SongController.class).getAllSongs()).withSelfRel();
        List<SongDTO> songDTOS = new ArrayList<>();
        for (Song entity: songs) {
            Link selfLink = new Link(link.getHref() + "/" + entity.getId()).withSelfRel();
            SongDTO songDTO = new SongDTO(entity, selfLink);
            songDTOS.add(songDTO);
        }
        return new ResponseEntity<>(songDTOS, HttpStatus.OK);
    }

    @GetMapping(value = "/api/v1/song/{songId}")
    public ResponseEntity<SongDTO> getSong(@PathVariable long songId) throws NoSuchObjectException {
        Song song = songService.getSong(songId);
        Link link = linkTo(methodOn(SongController.class).getSong(songId)).withSelfRel();
        SongDTO songDTO = new SongDTO(song, link);
        return new ResponseEntity<>(songDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/api/v1/song")
    public ResponseEntity<List<SongDTO>> getAllSongs() throws NoSuchObjectException {
        List<Song> songs = songService.getAllSongs();
        Link link = linkTo(methodOn(SongController.class).getAllSongs()).withSelfRel();
        List<SongDTO> songDTOS = new ArrayList<>();
        for (Song entity:songs) {
            Link selfLink = new Link(link.getHref() + "/" + entity.getId()).withSelfRel();
            SongDTO songDTO = new SongDTO(entity, selfLink);
            songDTOS.add(songDTO);
        }
        return new ResponseEntity<>(songDTOS, HttpStatus.OK);
    }

    @PostMapping(value = "/api/v1/song")
    public ResponseEntity<SongDTO> addSong(@RequestBody Song song) throws NoSuchObjectException {
        songService.createSong(song);
        Link link = linkTo(methodOn(SongController.class).getSong(song.getId())).withSelfRel();
        SongDTO songDTO = new SongDTO(song, link);
        return new ResponseEntity<>(songDTO, HttpStatus.CREATED);
    }

    @PutMapping(value = "/api/v1/song/{songId}")
    public ResponseEntity<SongDTO> updateSong(@RequestBody Song newSong, @PathVariable long songId) throws NoSuchObjectException {
        songService.updateSong(newSong, songId);
        Song song = songService.getSong(songId);
        Link link = linkTo(methodOn(SongController.class).getSong(songId)).withSelfRel();
        SongDTO songDTO = new SongDTO(song, link);
        return new ResponseEntity<>(songDTO, HttpStatus.OK);
    }

    @DeleteMapping(value = "/api/v1/song/{songId}")
    public ResponseEntity deleteSong(@PathVariable long songId) throws NoSuchObjectException, ReferencesPrensetException {
        songService.deleteSong(songId);
        return new ResponseEntity(HttpStatus.OK);
    }
}
