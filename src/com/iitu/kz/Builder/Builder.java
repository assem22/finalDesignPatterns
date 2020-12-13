package com.iitu.kz.Builder;

import com.iitu.kz.observer.abstractFactory.Film;

public interface Builder {
    Builder setTitle(String title);
    Builder setYear(int year);
    Builder setGenre(String genre);
    Builder setCountry(String country);
    Builder setProducer(String producer);
    Builder setActor(String actor);
    Builder setLanguage(String language);
    Builder setSeries(int series);
    Builder setParts(int parts);
    Builder isFree(boolean free);
    Film build();
//    Film build(String title, int year, String country, String producer, String language);
}
