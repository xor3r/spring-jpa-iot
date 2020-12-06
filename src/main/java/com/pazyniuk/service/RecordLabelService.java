package com.pazyniuk.service;

import com.pazyniuk.domain.RecordLabel;
import com.pazyniuk.exceptions.NoSuchObjectException;
import com.pazyniuk.exceptions.ReferencesPrensetException;
import com.pazyniuk.repository.RecordLabelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class RecordLabelService {

    @Autowired
    RecordLabelRepository recordLabelRepository;

    public RecordLabel getRecordLabel(long recordLabelId) throws NoSuchObjectException {
        if (recordLabelRepository.findById(recordLabelId).isPresent()) {
            return recordLabelRepository.findById(recordLabelId).get();
        }
        else {
            throw new NoSuchObjectException();
        }
    }

    public List<RecordLabel> getAllRecordLabels() {
        return recordLabelRepository.findAll();
    }

    @Transactional
    public void createRecordLabel(RecordLabel recordLabel) {
        recordLabelRepository.save(recordLabel);
    }

    @Transactional
    public void updateRecordLabel(RecordLabel newRecordLabel, long recordLabelId) throws NoSuchObjectException {
        if (recordLabelRepository.findById(recordLabelId).isPresent()) {
            RecordLabel recordLabel = recordLabelRepository.findById(recordLabelId).get();
            recordLabel.setTitle(newRecordLabel.getTitle());
            recordLabel.setYearEstablished(newRecordLabel.getYearEstablished());
            recordLabel.setSongs(newRecordLabel.getSongs());
        }
        else {
            throw new NoSuchObjectException();
        }
    }

    @Transactional
    public void deleteRecordLabel(long recordLabelId) throws NoSuchObjectException, ReferencesPrensetException {
        if (recordLabelRepository.findById(recordLabelId).isPresent()) {
            RecordLabel recordLabel = recordLabelRepository.findById(recordLabelId).get();
            if (recordLabel.getSongs().size() != 0) throw new ReferencesPrensetException();
            else recordLabelRepository.delete(recordLabel);
        } else {
            throw new NoSuchObjectException();
        }
    }
}
