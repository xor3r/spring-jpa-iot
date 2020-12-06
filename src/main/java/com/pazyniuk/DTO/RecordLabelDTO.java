package com.pazyniuk.DTO;

import com.pazyniuk.controller.SongController;
import com.pazyniuk.domain.RecordLabel;
import com.pazyniuk.domain.Song;
import com.pazyniuk.exceptions.NoSuchObjectException;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

public class RecordLabelDTO extends ResourceSupport {
    RecordLabel recordLabel;

    public RecordLabelDTO(RecordLabel recordLabel, Link selfLink) throws NoSuchObjectException {
        this.recordLabel = recordLabel;
        add(selfLink);
        add(linkTo(methodOn(SongController.class).getSongsByRecordLabelId(recordLabel.getId())).withRel("songs"));
    }

    public long getRecordLabelId() {
        return recordLabel.getId();
    }

    public String getRecordLabelTitle() {
        return recordLabel.getTitle();
    }

    public String getRecordLabelYearEstablished() {
        return recordLabel.getYearEstablished();
    }

    public List<String> getRecordLabelSongs() {
        return recordLabel.getSongs().stream().map( Song::getName ).collect( Collectors.toList() );
    }
}
