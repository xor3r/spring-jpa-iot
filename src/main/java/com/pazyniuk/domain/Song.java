package com.pazyniuk.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "song", schema = "pazyniuk_jpa")
@JsonIgnoreProperties("links")
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @ManyToOne
    @JoinColumn(name = "genre", referencedColumnName = "id", nullable = false)
    private Genre genre;

    @ManyToOne
    @JoinColumn(name = "artist", referencedColumnName = "id", nullable = false)
    private Artist artist;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "record_label", referencedColumnName = "id", nullable = false)
    private RecordLabel recordLabel;

    @Column(name = "price", nullable = false)
    private float price;

    @Column(name = "download_count", nullable = false)
    private int downloadCount;

    @ManyToOne
    @JoinColumn(name = "album", referencedColumnName = "id", nullable = false)
    private Album album;

    @ManyToMany
    @JoinTable(name = "user_song",
    joinColumns = @JoinColumn(name = "song_id", referencedColumnName = "id", nullable = false),
    inverseJoinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false))
    @JsonIgnore
    private List<ItunesUser> itunesUserSet;

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Artist getAuthor() {
        return artist;
    }

    public void setAuthor(Artist artist) {
        this.artist = artist;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RecordLabel getRecordLabel() {
        return recordLabel;
    }

    public void setRecordLabel(RecordLabel recordLabel) {
        this.recordLabel = recordLabel;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getDownloadCount() {
        return downloadCount;
    }

    public void setDownloadCount(int downloadCount) {
        this.downloadCount = downloadCount;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<ItunesUser> getItunesUserSet() {
        return itunesUserSet;
    }

    public void setItunesUserSet(List<ItunesUser> itunesUserSet) {
        this.itunesUserSet = itunesUserSet;
    }
}
