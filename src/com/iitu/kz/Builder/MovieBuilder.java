package com.iitu.kz.Builder;

import com.iitu.kz.observer.abstractFactory.EngMovie;

public class MovieBuilder implements Builder {
    private EngMovie movie = new EngMovie();

    @Override
    public Builder setTitle(String title) {
        this.movie.setTitle(title);
        return this;
    }

    @Override
    public Builder setYear(int year) {
        this.movie.setYear(year);
        return this;
    }

    @Override
    public Builder setGenre(String genre) {
        this.movie.setGenre(genre);
        return this;
    }

    @Override
    public Builder setCountry(String country) {
        this.movie.setCountry(country);
        return this;
    }

    @Override
    public Builder setProducer(String producer) {
        this.movie.setProducer(producer);
        return this;
    }

    @Override
    public Builder setActor(String actor) {
        this.movie.setActor(actor);
        return this;
    }

    @Override
    public Builder setLanguage(String language) {
        this.movie.setLanguage(language);
        return this;
    }

    @Override
    public Builder setSeries(int series) {
        this.movie.setSeries(series);
        return this;
    }

    @Override
    public Builder setParts(int parts) {
        this.movie.setParts(parts);
        return this;
    }

    @Override
    public Builder isFree(boolean isFree) {
        this.movie.setFree(isFree);
        return this;
    }

    @Override
    public EngMovie build() {
        return movie;
    }
//    @Override
//    public Movie build(String title, int year, String country, String producer, String language) {
//        movie = new Movie(title, year, country, producer, language);
//        return movie;
//    }
}
