package com.pazyniuk.controller;

import com.pazyniuk.DTO.RecordLabelDTO;
import com.pazyniuk.domain.RecordLabel;
import com.pazyniuk.exceptions.NoSuchObjectException;
import com.pazyniuk.exceptions.ReferencesPrensetException;
import com.pazyniuk.service.RecordLabelService;
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
public class RecordLabelController {

    @Autowired
    RecordLabelService recordLabelService;

    @GetMapping(value = "/api/v1/record_label/{recordLabelId}")
    public ResponseEntity<RecordLabelDTO> getRecordLabel(@PathVariable long recordLabelId) throws NoSuchObjectException {
        RecordLabel recordLabel = recordLabelService.getRecordLabel(recordLabelId);
        Link link = linkTo(methodOn(RecordLabelController.class).getRecordLabel(recordLabelId)).withSelfRel();
        RecordLabelDTO recordLabelDTO = new RecordLabelDTO(recordLabel, link);
        return new ResponseEntity<>(recordLabelDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/api/v1/record_label")
    public ResponseEntity<List<RecordLabelDTO>> getAllRecordLabels() throws NoSuchObjectException {
        List<RecordLabel> recordLabels = recordLabelService.getAllRecordLabels();
        Link link = linkTo(methodOn(RecordLabelController.class).getAllRecordLabels()).withSelfRel();
        List<RecordLabelDTO> recordLabelDTOS = new ArrayList<>();
        for (RecordLabel entity:recordLabels) {
            Link selfLink = new Link(link.getHref() + "/" + entity.getId()).withSelfRel();
            RecordLabelDTO recordLabelDTO = new RecordLabelDTO(entity, selfLink);
            recordLabelDTOS.add(recordLabelDTO);
        }
        return new ResponseEntity<>(recordLabelDTOS, HttpStatus.OK);
    }

    @PostMapping(value = "/api/v1/record_label")
    public ResponseEntity<RecordLabelDTO> addRecordLabel(@RequestBody RecordLabel recordLabel) throws NoSuchObjectException {
        recordLabelService.createRecordLabel(recordLabel);
        Link link = linkTo(methodOn(RecordLabelController.class).getRecordLabel(recordLabel.getId())).withSelfRel();
        RecordLabelDTO recordLabelDTO = new RecordLabelDTO(recordLabel, link);
        return new ResponseEntity<>(recordLabelDTO, HttpStatus.CREATED);
    }

    @PutMapping(value = "/api/v1/record_label/{recordLabelId}")
    public ResponseEntity<RecordLabelDTO> updateRecordLabel(@RequestBody RecordLabel newRecordLabel, @PathVariable long recordLabelId) throws NoSuchObjectException {
        recordLabelService.updateRecordLabel(newRecordLabel, recordLabelId);
        RecordLabel recordLabel = recordLabelService.getRecordLabel(recordLabelId);
        Link link = linkTo(methodOn(RecordLabelController.class).getRecordLabel(recordLabelId)).withSelfRel();
        RecordLabelDTO recordLabelDTO = new RecordLabelDTO(recordLabel, link);
        return new ResponseEntity<>(recordLabelDTO, HttpStatus.OK);
    }

    @DeleteMapping(value = "/api/v1/record_label/{recordLabelId}")
    public ResponseEntity deleteRecordLabel(@PathVariable long recordLabelId) throws NoSuchObjectException, ReferencesPrensetException {
        recordLabelService.deleteRecordLabel(recordLabelId);
        return new ResponseEntity(HttpStatus.OK);
    }
}
