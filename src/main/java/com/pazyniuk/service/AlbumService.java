package com.pazyniuk.service;

import com.pazyniuk.domain.Album;
import com.pazyniuk.exceptions.NoSuchObjectException;
import com.pazyniuk.exceptions.ReferencesPrensetException;
import com.pazyniuk.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class AlbumService {

    @Autowired
    AlbumRepository albumRepository;

    public Album getAlbum(long albumId) throws NoSuchObjectException {
        if (albumRepository.findById(albumId).isPresent()) {
            return albumRepository.findById(albumId).get();
        }
        else {
            throw new NoSuchObjectException();
        }
    }

    public List<Album> getAllAlbums() {
        return albumRepository.findAll();
    }

    @Transactional
    public void createAlbum(Album album) {
        albumRepository.save(album);
    }

    @Transactional
    public void updateAlbum(Album newAlbum, long albumId) throws NoSuchObjectException {
        if (albumRepository.findById(albumId).isPresent()) {
            Album album = albumRepository.findById(albumId).get();
            album.setName(newAlbum.getName());
            album.setSongs(newAlbum.getSongs());
            album.setYear(newAlbum.getYear());
        }
        else {
            throw new NoSuchObjectException();
        }
    }

    @Transactional
    public void deleteAlbum(long albumId) throws NoSuchObjectException, ReferencesPrensetException {
        if (albumRepository.findById(albumId).isPresent()) {
            Album album = albumRepository.findById(albumId).get();
            if (album.getSongs().size() != 0) throw new ReferencesPrensetException();
            else albumRepository.delete(album);
        }
        else {
            throw new NoSuchObjectException();
        }
    }
}
