package com.pazyniuk.service;

import com.pazyniuk.domain.Gender;
import com.pazyniuk.exceptions.NoSuchObjectException;
import com.pazyniuk.exceptions.ReferencesPrensetException;
import com.pazyniuk.repository.GenderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class GenderService {

    @Autowired
    GenderRepository genderRepository;

    public Gender getGender(long genderId) throws NoSuchObjectException {
        if (genderRepository.findById(genderId).isPresent()) {
            return genderRepository.findById(genderId).get();
        }
        else {
            throw new NoSuchObjectException();
        }
    }

    public List<Gender> getAllGenders() {
        return genderRepository.findAll();
    }

    @Transactional
    public void createGender(Gender gender) {
        genderRepository.save(gender);
    }

    @Transactional
    public void updateGender(Gender newGender, long genderId) throws NoSuchObjectException {
        if (genderRepository.findById(genderId).isPresent()) {
            Gender gender = genderRepository.findById(genderId).get();
            gender.setGenderType(newGender.getGenderType());
            gender.setArtists(newGender.getArtists());
            gender.setItunesUsers(newGender.getItunesUsers());
        }
        else {
            throw new NoSuchObjectException();
        }
    }

    @Transactional
    public void deleteGender(long genderId) throws NoSuchObjectException, ReferencesPrensetException {
        if (genderRepository.findById(genderId).isPresent()) {
            Gender gender = genderRepository.findById(genderId).get();
            if (gender.getArtists().size() != 0 || gender.getItunesUsers().size() != 0)
                throw new ReferencesPrensetException();
            else genderRepository.delete(gender);
        }
        else {
            throw new NoSuchObjectException();
        }
    }
}
