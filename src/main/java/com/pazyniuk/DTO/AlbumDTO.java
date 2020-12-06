package com.pazyniuk.DTO;

import com.pazyniuk.controller.SongController;
import com.pazyniuk.domain.Album;
import com.pazyniuk.domain.Song;
import com.pazyniuk.exceptions.NoSuchObjectException;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

public class AlbumDTO extends ResourceSupport {
    Album album;

    public AlbumDTO(Album album, Link selfLink) throws NoSuchObjectException {
        this.album = album;
        add(selfLink);
        add(linkTo(methodOn(SongController.class).getSongsByAlbumId(album.getId())).withRel("songs"));
    }

    public long getAlbumId() {
        return album.getId();
    }

    public String getAlbumName() {
        return album.getName();
    }

    public String getAlbumYear() {
        return album.getYear();
    }

    public List<String> getAlbumSongs() {
        return album.getSongs().stream().map( Song::getName ).collect( Collectors.toList() );
    }
}
