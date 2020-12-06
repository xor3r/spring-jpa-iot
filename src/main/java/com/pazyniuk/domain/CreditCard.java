package com.pazyniuk.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "credit_card", schema = "pazyniuk_jpa")
@JsonIgnoreProperties("links")
public class CreditCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "number", nullable = false)
    private String number;

    @OneToOne(mappedBy = "creditCard")
    @JoinColumn(name = "itunes_user", referencedColumnName = "id", nullable = true)
    private ItunesUser itunesUser;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public ItunesUser getItunesUser() {
        return itunesUser;
    }

    public void setItunesUser(ItunesUser itunesUser) {
        this.itunesUser = itunesUser;
    }
}
