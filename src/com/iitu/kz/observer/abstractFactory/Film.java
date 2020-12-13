package com.iitu.kz.observer.abstractFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class Film {
    private static final AtomicInteger count = new AtomicInteger(0);
    private int id;
    private String title;
    private int year;
    private List<String> genre;
    private String country;
    private String producer;
    private List<String> actors;
    private String language;
    private int series;
    private int parts;
    private String studio;
    private boolean isFree;

    public Film(){
        this.genre = new ArrayList<>();
        this.actors = new ArrayList<>();
        this.id = count.incrementAndGet();
    }

    public Film(String title, int year, String country, String producer, String language) {
        this.title = title;
        this.year = year;
        this.genre = new ArrayList<>();
        this.country = country;
        this.producer = producer;
        this.actors = new ArrayList<>();
        this.language = language;
        this.id = count.incrementAndGet();
    }

    public boolean isFree() {
        return isFree;
    }

    public void setFree(boolean free) {
        this.isFree = free;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public List<String> getGenre() {
        return genre;
    }

    public String getCountry() {
        return country;
    }

    public String getProducer() {
        return producer;
    }

    public String getLanguage() {
        return language;
    }

    public int getSeries() {
        return series;
    }

    public int getYear() {
        return year;
    }

    public List<String> getActors() {
        return actors;
    }

    public int getParts() {
        return parts;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setGenre(String genre) {
        this.genre.add(genre);
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public void setActor(String actor) {
        this.actors.add(actor);
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    public void setParts(int parts) {
        this.parts = parts;
    }

    @Override
    public String toString() {
        return "Film{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", year=" + year +
                ", genre=" + genre +
                ", country='" + country + '\'' +
                ", producer='" + producer + '\'' +
                ", actors=" + actors +
                ", language='" + language + '\'' +
                ", series=" + series +
                ", parts=" + parts +
                ", studio='" + studio + '\'' +
                ", isFree=" + isFree +
                '}';
    }
}
