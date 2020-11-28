package com.pazyniuk.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "gender", schema = "pazyniuk_jpa")
@JsonIgnoreProperties("links")
public class Gender {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "gender_type", nullable = false)
    private String genderType;

    @OneToMany(mappedBy = "gender")
    private List<Artist> artists;

    @OneToMany(mappedBy = "gender")
    private List<ItunesUser> itunesUsers;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getGenderType() {
        return genderType;
    }

    public void setGenderType(String genderType) {
        this.genderType = genderType;
    }

    public List<ItunesUser> getItunesUsers() {
        return itunesUsers;
    }

    public void setItunesUsers(List<ItunesUser> itunesUsers) {
        this.itunesUsers = itunesUsers;
    }

    public List<Artist> getArtists() {
        return artists;
    }

    public void setArtists(List<Artist> artists) {
        this.artists = artists;
    }
}
