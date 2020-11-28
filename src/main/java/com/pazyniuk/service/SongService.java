package com.pazyniuk.service;

import com.pazyniuk.domain.Album;
import com.pazyniuk.domain.Song;
import com.pazyniuk.exceptions.NoSuchObjectException;
import com.pazyniuk.exceptions.ReferencesPrensetException;
import com.pazyniuk.repository.AlbumRepository;
import com.pazyniuk.repository.RecordLabelRepository;
import com.pazyniuk.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

@Service
public class SongService {

    @Autowired
    SongRepository songRepository;

    @Autowired
    AlbumRepository albumRepository;

    @Autowired
    RecordLabelRepository recordLabelRepository;

    public List<Song> getSongsByAlbumId(long albumId) throws NoSuchObjectException {
        if (albumRepository.findById(albumId).isPresent()) {
            return albumRepository.findById(albumId).get().getSongs();
        }
        else {
            throw new NoSuchObjectException();
        }
    }

    public List<Song> getSongsByRecordLabelId(long recordLabelId) throws NoSuchObjectException {
        if (recordLabelRepository.findById(recordLabelId).isPresent()) {
            return recordLabelRepository.findById(recordLabelId).get().getSongs();
        }
        else {
            throw new NoSuchObjectException();
        }
    }

    public Song getSong(long songId) throws NoSuchObjectException {
        if (songRepository.findById(songId).isPresent()) {
            return songRepository.findById(songId).get();
        }
        else {
            throw new NoSuchObjectException();
        }
    }

    public List<Song> getAllSongs() {
        return songRepository.findAll();
    }

    @Transactional
    public void createSong(Song song) {
        songRepository.save(song);
    }

    @Transactional
    public void updateSong(Song newSong, long songId) throws NoSuchObjectException {
        if (songRepository.findById(songId).isPresent()) {
            Song song = songRepository.findById(songId).get();
            song.setName(newSong.getName());
            song.setPrice(newSong.getPrice());
            song.setAlbum(newSong.getAlbum());
            song.setAuthor(newSong.getAuthor());
            song.setDownloadCount(newSong.getDownloadCount());
            song.setRecordLabel(newSong.getRecordLabel());
            song.setGenre(newSong.getGenre());
            song.setItunesUserSet(newSong.getItunesUserSet());
        }
        else {
            throw new NoSuchObjectException();
        }
    }

    @Transactional
    public void deleteSong(long songId) throws NoSuchObjectException {
        if (songRepository.findById(songId).isPresent()) {
            Song song = songRepository.findById(songId).get();
            songRepository.delete(song);
        } else {
            throw new NoSuchObjectException();
        }
    }

}
