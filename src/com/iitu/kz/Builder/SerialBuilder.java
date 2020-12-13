package com.iitu.kz.Builder;

import com.iitu.kz.observer.abstractFactory.EngSerial;
import com.iitu.kz.observer.abstractFactory.Film;

public class SerialBuilder implements Builder {
    private EngSerial serial = new EngSerial();

    @Override
    public Builder setTitle(String title) {
        this.serial.setTitle(title);
        return this;
    }

    @Override
    public Builder setYear(int year) {
        this.serial.setYear(year);
        return this;
    }

    @Override
    public Builder setGenre(String genre) {
        this.serial.setGenre(genre);
        return this;
    }

    @Override
    public Builder setCountry(String country) {
        this.serial.setCountry(country);
        return this;
    }

    @Override
    public Builder setProducer(String producer) {
        this.serial.setProducer(producer);
        return this;
    }

    @Override
    public Builder setActor(String actor) {
        this.serial.setActor(actor);
        return this;
    }

    @Override
    public Builder setLanguage(String language) {
        this.serial.setLanguage(language);
        return this;
    }

    @Override
    public Builder setSeries(int series) {
        this.serial.setSeries(series);
        return this;
    }

    @Override
    public Builder setParts(int parts) {
        this.serial.setParts(parts);
        return this;
    }

    @Override
    public Builder isFree(boolean isFree) {
        this.serial.setFree(isFree);
        return this;
    }

    @Override
    public Film build() {
        return serial;
    }
}
