package com.iitu.kz.adapter;

import com.iitu.kz.observer.abstractFactory.Film;

public class RusAdapter implements Translator {
    Film film;

    public RusAdapter(Film film) {
        this.film = film;
    }

    @Override
    public String translateToRus() {
        return translate(film.getLanguage());
    }

    private String translate(String language) {
        return "Оригинал : " + language + ", перевод: русский";
    }
}
