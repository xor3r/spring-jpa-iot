package com.pazyniuk.controller;

import com.pazyniuk.DTO.GenreDTO;
import com.pazyniuk.domain.Genre;
import com.pazyniuk.exceptions.NoSuchObjectException;
import com.pazyniuk.exceptions.ReferencesPrensetException;
import com.pazyniuk.service.GenreService;
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
public class GenreController {

    @Autowired
    GenreService genreService;

    @GetMapping(value = "/api/v1/genre/{genreId}")
    public ResponseEntity<GenreDTO> getGenre(@PathVariable long genreId) throws NoSuchObjectException {
        Genre genre = genreService.getGenre(genreId);
        Link link = linkTo(methodOn(GenreController.class).getGenre(genreId)).withSelfRel();
        GenreDTO genreDTO = new GenreDTO(genre, link);
        return new ResponseEntity<>(genreDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/api/v1/genre")
    public ResponseEntity<List<GenreDTO>> getAllGenres() throws NoSuchObjectException {
        List<Genre> genres = genreService.getAllGenres();
        Link link = linkTo(methodOn(GenreController.class).getAllGenres()).withSelfRel();
        List<GenreDTO> genreDTOS = new ArrayList<>();
        for (Genre entity:genres) {
            Link selfLink = new Link(link.getHref() + "/" + entity.getId()).withSelfRel();
            GenreDTO genreDTO = new GenreDTO(entity, selfLink);
            genreDTOS.add(genreDTO);
        }
        return new ResponseEntity<>(genreDTOS, HttpStatus.OK);
    }

    @PostMapping(value = "/api/v1/genre")
    public ResponseEntity<GenreDTO> addGenre(@RequestBody Genre genre) throws NoSuchObjectException {
        genreService.createGenre(genre);
        Link link = linkTo(methodOn(GenreController.class).getGenre(genre.getId())).withSelfRel();
        GenreDTO genreDTO = new GenreDTO(genre, link);
        return new ResponseEntity<>(genreDTO, HttpStatus.CREATED);
    }

    @PutMapping(value = "/api/v1/genre/{genreId}")
    public ResponseEntity<GenreDTO> updateGenre(@RequestBody Genre newGenre, @PathVariable long genreId) throws NoSuchObjectException {
        genreService.updateGenre(newGenre, genreId);
        Genre genre = genreService.getGenre(genreId);
        Link link = linkTo(methodOn(GenreController.class).getGenre(genreId)).withSelfRel();
        GenreDTO genreDTO = new GenreDTO(genre, link);
        return new ResponseEntity<>(genreDTO, HttpStatus.OK);
    }

    @DeleteMapping(value = "/api/v1/genre/{genreId}")
    public ResponseEntity deleteGender(@PathVariable long genreId) throws NoSuchObjectException, ReferencesPrensetException {
        genreService.deleteGenre(genreId);
        return new ResponseEntity(HttpStatus.OK);
    }
}
