package com.example.nedcinema.entity;

import com.example.nedcinema.entity.Cinema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Entity
@AllArgsConstructor
@Table(name ="movies")
public class Movies {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "_id")
    private int id;
    @Column(name = "ma_phim",nullable = false)
    private String maphim;
    @Column(name="title",nullable = false)
    private String title;
    @Column(name = "year",nullable = false)
    private String year;
    @Column(name = "rated",nullable = false)
    private String  rated;
    @Column(name ="released",nullable = false)
    private String released;
    @Column(name = "runtime",nullable = false)
    private String  runtime;
    @Column(name="genners",nullable = false)
    private String geners;
    @Column(name="directors",nullable = false)
    private String directors;
    @Column(name="actors",nullable = false)
    private String actors;
    @Column(name="plot",nullable = false)
    private String  plot;
    @Column(name="language",nullable = false)
    private String language;

    @Column(name="poster",nullable = false)
    private String poster;
    @Column(name = "banner",nullable = false)
    private String banner;
    @Column(name = "trailer",nullable = false)
    private String trailer;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cinema", referencedColumnName = "cinema_id", nullable = false)
    private Cinema cinema;
    @Column(name="createdAt",nullable = false)
    @CreationTimestamp
    private Timestamp createdAt;
    @Column(name = "updateAt",nullable = false)
    @CreationTimestamp
    private Timestamp updateAt;

    public Movies(String maphim, String title, String year, String rated, String released, String runtime, String geners, String directors, String actors, String plot, String language, String poster, String banner, String trailer,Cinema cinema, Timestamp createdAt, Timestamp updateAt) {
        this.maphim = maphim;
        this.title = title;
        this.year = year;
        this.rated = rated;
        this.released = released;
        this.runtime = runtime;
        this.geners = geners;
        this.directors = directors;
        this.actors = actors;
        this.plot = plot;
        this.language = language;
        this.poster = poster;
        this.banner = banner;
        this.trailer = trailer;
        this.cinema = cinema;
    }

    public Movies() {

    }

    public String getMaphim() {
        return maphim;
    }

    public void setMaphim(String maphim) {
        this.maphim = maphim;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getRated() {
        return rated;
    }

    public void setRated(String rated) {
        this.rated = rated;
    }

    public String getReleased() {
        return released;
    }

    public void setReleased(String released) {
        this.released = released;
    }

    public String getRuntime() {
        return runtime;
    }

    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }

    public String getGeners() {
        return geners;
    }

    public void setGeners(String geners) {
        this.geners = geners;
    }

    public String getDirectors() {
        return directors;
    }

    public void setDirectors(String directors) {
        this.directors = directors;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getBanner() {
        return banner;
    }

    public void setBanner(String banner) {
        this.banner = banner;
    }

    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }

    public Cinema getCinema() {
        return cinema;
    }

    public void setCinema(Cinema cinema) {
        this.cinema = cinema;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Timestamp updateAt) {
        this.updateAt = updateAt;
    }
}
