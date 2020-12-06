package com.pazyniuk.DTO;

import com.pazyniuk.controller.ItunesUserController;
import com.pazyniuk.domain.*;
import com.pazyniuk.exceptions.NoSuchObjectException;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

public class SongDTO extends ResourceSupport {
    Song song;

    public SongDTO(Song song, Link selfLink) throws NoSuchObjectException {
        this.song = song;
        add(selfLink);
        add(linkTo(methodOn(ItunesUserController.class).getItunesUsersBySongId(song.getId())).withRel("itunes_users"));
    }

    public long getSongId() {
        return song.getId();
    }

    public String getSongGenre() {
        return song.getGenre().getName();
    }

    public String getSongArtist() {
        return song.getAuthor().getName();
    }

    public String getSongName() {
        return song.getName();
    }

    public String getSongRecordLabel() {
        return song.getRecordLabel().getTitle();
    }

    public float getSongPrice() {
        return song.getPrice();
    }

    public int getSongDownloadCount() {
        return song.getDownloadCount();
    }

    public String getSongAlbum() {
        return song.getAlbum().getName();
    }

    public List<String> getSongItunesUsers() {
        return song.getItunesUserSet().stream().map( ItunesUser::getUsername ).collect( Collectors.toList() );
    }
}
