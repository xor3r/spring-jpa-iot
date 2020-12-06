package com.pazyniuk.service;

import com.pazyniuk.domain.Genre;
import com.pazyniuk.exceptions.NoSuchObjectException;
import com.pazyniuk.exceptions.ReferencesPrensetException;
import com.pazyniuk.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class GenreService {

    @Autowired
    GenreRepository genreRepository;

    public Genre getGenre(long genreId) throws NoSuchObjectException {
        if (genreRepository.findById(genreId).isPresent()) {
            return genreRepository.findById(genreId).get();
        }
        else {
            throw new NoSuchObjectException();
        }
    }

    public List<Genre> getAllGenres() {
        return genreRepository.findAll();
    }

    @Transactional
    public void createGenre(Genre genre) {
        genreRepository.save(genre);
    }

    @Transactional
    public void updateGenre(Genre newGenre, long genreId) throws NoSuchObjectException {
        if (genreRepository.findById(genreId).isPresent()) {
            Genre genre = genreRepository.findById(genreId).get();
            genre.setName(newGenre.getName());
            genre.setSongs(newGenre.getSongs());
        }
        else {
            throw new NoSuchObjectException();
        }
    }

    @Transactional
    public void deleteGenre(long genreId) throws NoSuchObjectException, ReferencesPrensetException {
        if (genreRepository.findById(genreId).isPresent()) {
            Genre genre = genreRepository.findById(genreId).get();
            if (genre.getSongs().size() != 0) throw new ReferencesPrensetException();
            else genreRepository.delete(genre);
        } else {
            throw new NoSuchObjectException();
        }
    }
}
