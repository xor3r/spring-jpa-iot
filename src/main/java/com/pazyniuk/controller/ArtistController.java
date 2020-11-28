package com.pazyniuk.controller;

import com.pazyniuk.DTO.ArtistDTO;
import com.pazyniuk.domain.Artist;
import com.pazyniuk.exceptions.NoSuchObjectException;
import com.pazyniuk.exceptions.ReferencesPrensetException;
import com.pazyniuk.service.ArtistService;
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
public class ArtistController {

    @Autowired
    ArtistService artistService;

    @GetMapping(value = "/api/v1/artist/country/{countryId}")
    public ResponseEntity<List<ArtistDTO>> getArtistsByCountryId(@PathVariable long countryId) throws NoSuchObjectException {
        List<Artist> artists = artistService.getArtistsByCountryId(countryId);
        Link link = linkTo(methodOn(ArtistController.class).getAllArtists()).withSelfRel();
        List<ArtistDTO> artistDTOS = new ArrayList<>();
        for (Artist entity: artists) {
            Link selfLink = new Link(link.getHref() + "/" + entity.getId()).withSelfRel();
            ArtistDTO artistDTO = new ArtistDTO(entity, selfLink);
            artistDTOS.add(artistDTO);
        }
        return new ResponseEntity<>(artistDTOS, HttpStatus.OK);
    }

    @GetMapping(value = "/api/v1/artist/{artistId}")
    public ResponseEntity<ArtistDTO> getArtist(@PathVariable long artistId) throws NoSuchObjectException {
        Artist artist = artistService.getArtist(artistId);
        Link link = linkTo(methodOn(ArtistController.class).getArtist(artistId)).withSelfRel();
        ArtistDTO artistDTO = new ArtistDTO(artist, link);
        return new ResponseEntity<>(artistDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/api/v1/artist")
    public ResponseEntity<List<ArtistDTO>> getAllArtists() throws NoSuchObjectException {
        List<Artist> artists = artistService.getAllArtists();
        Link link = linkTo(methodOn(ArtistController.class).getAllArtists()).withSelfRel();
        List<ArtistDTO> artistDTOS = new ArrayList<>();
        for (Artist entity:artists) {
            Link selfLink = new Link(link.getHref() + "/" + entity.getId()).withSelfRel();
            ArtistDTO artistDTO = new ArtistDTO(entity, selfLink);
            artistDTOS.add(artistDTO);
        }
        return new ResponseEntity<>(artistDTOS, HttpStatus.OK);
    }

    @PostMapping(value = "/api/v1/artist")
    public ResponseEntity<ArtistDTO> addArtist(@RequestBody Artist artist) throws NoSuchObjectException {
        artistService.createArtist(artist);
        Link link = linkTo(methodOn(ArtistController.class).getArtist(artist.getId())).withSelfRel();
        ArtistDTO artistDTO = new ArtistDTO(artist, link);
        return new ResponseEntity<>(artistDTO, HttpStatus.CREATED);
    }

    @PutMapping(value = "/api/v1/artist/{artistId}")
    public ResponseEntity<ArtistDTO> updateArtist(@RequestBody Artist newArtist, @PathVariable long artistId) throws NoSuchObjectException {
        artistService.updateArtist(newArtist, artistId);
        Artist artist = artistService.getArtist(artistId);
        Link link = linkTo(methodOn(ArtistController.class).getArtist(artistId)).withSelfRel();
        ArtistDTO artistDTO = new ArtistDTO(artist, link);
        return new ResponseEntity<>(artistDTO, HttpStatus.OK);
    }

    @DeleteMapping(value = "/api/v1/artist/{artistId}")
    public ResponseEntity deleteArtist(@PathVariable long artistId) throws NoSuchObjectException, ReferencesPrensetException {
        artistService.deleteArtist(artistId);
        return new ResponseEntity(HttpStatus.OK);
    }
}
