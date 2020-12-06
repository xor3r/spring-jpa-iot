package com.pazyniuk.DTO;

import com.pazyniuk.domain.Genre;
import com.pazyniuk.domain.Song;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

public class GenreDTO extends ResourceSupport {
    Genre genre;

    public GenreDTO(Genre genre, Link selfLink) {
        this.genre = genre;
        add(selfLink);
    }

    public long getGenreId() {
        return genre.getId();
    }

    public String getGenreName() {
        return genre.getName();
    }

    public List<String> getGenreSongs() {
        return genre.getSongs().stream().map( Song::getName ).collect( Collectors.toList() );
    }
}
