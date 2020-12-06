package com.pazyniuk.service;

import com.pazyniuk.domain.Country;
import com.pazyniuk.exceptions.NoSuchObjectException;
import com.pazyniuk.exceptions.ReferencesPrensetException;
import com.pazyniuk.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CountryService {

    @Autowired
    CountryRepository countryRepository;

    public Country getCountry(long countryId) throws NoSuchObjectException {
        if (countryRepository.findById(countryId).isPresent()) {
            return countryRepository.findById(countryId).get();
        }
        else {
            throw new NoSuchObjectException();
        }
    }

    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    @Transactional
    public void createCountry(Country country) {
        countryRepository.save(country);
    }

    @Transactional
    public void updateCountry(Country newCountry, long countryId) throws NoSuchObjectException {
        if (countryRepository.findById(countryId).isPresent()) {
            Country country = countryRepository.findById(countryId).get();
            country.setName(newCountry.getName());
            country.setArtists(newCountry.getArtists());
        }
        else {
            throw new NoSuchObjectException();
        }
    }

    @Transactional
    public void deleteCountry(long countryId) throws NoSuchObjectException, ReferencesPrensetException {
        if (countryRepository.findById(countryId).isPresent()) {
            Country country = countryRepository.findById(countryId).get();
            if (country.getArtists().size() != 0) throw new ReferencesPrensetException();
            else countryRepository.delete(country);
        }
        else {
            throw new NoSuchObjectException();
        }
    }
}
