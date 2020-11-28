package com.pazyniuk.service;

import com.pazyniuk.domain.ItunesUser;
import com.pazyniuk.exceptions.NoSuchObjectException;
import com.pazyniuk.repository.ItunesUserRepository;
import com.pazyniuk.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

@Service
public class ItunesUserService {

    @Autowired
    ItunesUserRepository itunesUserRepository;

    @Autowired
    SongRepository songRepository;

    public List<ItunesUser> getItunesUsersBySong(long songId) throws NoSuchObjectException {
        if (songRepository.findById(songId).isPresent()) {
            return songRepository.findById(songId).get().getItunesUserSet();
        }
        else {
            throw new NoSuchObjectException();
        }
    }

    public ItunesUser getItunesUser(long itunesUserId) throws NoSuchObjectException {
        if (itunesUserRepository.findById(itunesUserId).isPresent()) {
            return itunesUserRepository.findById(itunesUserId).get();
        }
        else {
            throw new NoSuchObjectException();
        }
    }

    public List<ItunesUser> getAllItunesUsers() {
        return itunesUserRepository.findAll();
    }

    @Transactional
    public void createItunesUser(ItunesUser itunesUser) {
        itunesUserRepository.save(itunesUser);
    }

    @Transactional
    public void updateItunesUser(ItunesUser newItunesUser, long itunesUserId) throws NoSuchObjectException {
        if (itunesUserRepository.findById(itunesUserId).isPresent()) {
            ItunesUser itunesUser = itunesUserRepository.findById(itunesUserId).get();
            itunesUser.setName(newItunesUser.getName());
            itunesUser.setSurname(newItunesUser.getSurname());
            itunesUser.setUsername(newItunesUser.getUsername());
            itunesUser.setPassword(newItunesUser.getPassword());
            itunesUser.setJoinedDate(newItunesUser.getJoinedDate());
            itunesUser.setCreditCard(newItunesUser.getCreditCard());
            itunesUser.setGender(newItunesUser.getGender());
            itunesUser.setUserSongs(newItunesUser.getUserSongs());
        }
        else {
            throw new NoSuchObjectException();
        }
    }

    @Transactional
    public void deleteItunesUser(long itunesUserId) throws NoSuchObjectException {
        if (itunesUserRepository.findById(itunesUserId).isPresent()) {
            ItunesUser itunesUser = itunesUserRepository.findById(itunesUserId).get();
            itunesUserRepository.delete(itunesUser);
        } else {
            throw new NoSuchObjectException();
        }
    }
}
