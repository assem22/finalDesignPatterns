package com.iitu.kz.observer.abstractFactory;

import com.iitu.kz.observer.abstractFactory.Film;

public class EngMovie extends Film {

    public EngMovie(){
    }

    public EngMovie(String title, int year, String country, String producer, String language) {
        super(title, year, country, producer, language);
    }
}
