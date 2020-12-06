package com.pazyniuk.DTO;

import com.pazyniuk.domain.Artist;
import com.pazyniuk.domain.Song;
import com.pazyniuk.exceptions.NoSuchObjectException;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

public class ArtistDTO extends ResourceSupport {
    Artist artist;

    public ArtistDTO(Artist artist, Link selfLink) throws NoSuchObjectException {
        this.artist = artist;
        add(selfLink);
    }

    public long getArtistId() {
        return artist.getId();
    }

    public String getArtistName() {
        return artist.getName();
    }

    public String getArtistCountry() {
        return artist.getCountry().getName();
    }

    public String getArtistGender() {
        return artist.getGender().getGenderType();
    }

    public List<String> getArtistSongs() {
        return artist.getSongs().stream().map( Song::getName ).collect( Collectors.toList() );
    }
}
