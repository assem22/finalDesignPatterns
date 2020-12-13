package com.iitu.kz.observer.abstractFactory;

import com.iitu.kz.observer.abstractFactory.Film;

public class EngSerial extends Film {

    public EngSerial(){}

    public EngSerial(String title, int year, String country, String producer, String language) {
        super(title, year, country, producer, language);
    }
}
