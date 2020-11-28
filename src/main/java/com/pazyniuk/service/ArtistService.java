package com.pazyniuk.service;

import com.pazyniuk.domain.Artist;
import com.pazyniuk.exceptions.NoSuchObjectException;
import com.pazyniuk.exceptions.ReferencesPrensetException;
import com.pazyniuk.repository.ArtistRepository;
import com.pazyniuk.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ArtistService {

    @Autowired
    ArtistRepository artistRepository;

    @Autowired
    CountryRepository countryRepository;

    public List<Artist> getArtistsByCountryId(long countryId) throws NoSuchObjectException {
        if (countryRepository.findById(countryId).isPresent()) {
            return countryRepository.findById(countryId).get().getArtists();
        }
        else {
            throw new NoSuchObjectException();
        }
    }

    public Artist getArtist(long artistId) throws NoSuchObjectException {
        if (artistRepository.findById(artistId).isPresent()) {
            return artistRepository.findById(artistId).get();
        }
        else {
            throw new NoSuchObjectException();
        }
    }

    public List<Artist> getAllArtists() {
        return artistRepository.findAll();
    }

    @Transactional
    public void createArtist(Artist artist) {
        artistRepository.save(artist);
    }

    @Transactional
    public void updateArtist(Artist newArtist, long artistId) throws NoSuchObjectException {
        if (artistRepository.findById(artistId).isPresent()) {
            Artist artist = artistRepository.findById(artistId).get();
            artist.setName(newArtist.getName());
            artist.setSongs(newArtist.getSongs());
            artist.setCountry(newArtist.getCountry());
            artist.setGender(newArtist.getGender());
        }
        else {
            throw new NoSuchObjectException();
        }
    }

    @Transactional
    public void deleteArtist(long artistId) throws NoSuchObjectException, ReferencesPrensetException {
        if (artistRepository.findById(artistId).isPresent()) {
            Artist artist = artistRepository.findById(artistId).get();
            if (artist.getSongs().size() != 0) throw new ReferencesPrensetException();
            else artistRepository.delete(artist);
        }
        else {
            throw new NoSuchObjectException();
        }
    }
}
