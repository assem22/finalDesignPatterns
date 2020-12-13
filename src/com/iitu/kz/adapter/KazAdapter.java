package com.iitu.kz.adapter;

import com.iitu.kz.observer.abstractFactory.Film;

public class KazAdapter implements Translator {
    Film film;

    public KazAdapter(Film film) {
        this.film = film;
    }

    @Override
    public String translateToRus() {
        return translate(film.getLanguage());
    }

    private String translate(String language) {
        return "Түп нұсқасы: " + language + ", аудармасы: қазақ тілі";
    }
}
