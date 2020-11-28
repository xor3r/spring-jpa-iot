package com.pazyniuk.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "itunes_user", schema = "pazyniuk_jpa")
@JsonIgnoreProperties("links")
public class ItunesUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "joined_date", nullable = false)
    private String joinedDate;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "surname", nullable = false)
    private String surname;

    @ManyToOne
    @JoinColumn(name = "gender", referencedColumnName = "id", nullable = false)
    private Gender gender;

    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "credit_card", referencedColumnName = "id", nullable = false)
    private CreditCard creditCard;

    @ManyToMany(mappedBy = "itunesUserSet", cascade = CascadeType.REMOVE)
    private List<Song> userSongs;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getJoinedDate() {
        return joinedDate;
    }

    public void setJoinedDate(String joinedDate) {
        this.joinedDate = joinedDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
    }

    public List<Song> getUserSongs() {
        return userSongs;
    }

    public void setUserSongs(List<Song> userSongs) {
        this.userSongs = userSongs;
    }
}
