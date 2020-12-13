package com.iitu.kz.singleton;

import com.iitu.kz.observer.abstractFactory.Film;
import com.iitu.kz.observer.Publisher;
import com.iitu.kz.observer.SimpleSubscriber;

import java.util.ArrayList;
import java.util.List;

public class SingletonPlatform {
    private static SingletonPlatform instance;
    private List<Publisher> companies;
    private List<SimpleSubscriber> subscribers;
    private List<Film> films;

    public SingletonPlatform() {
        this.films = new ArrayList<>();
        this.companies = new ArrayList<>();
        this.subscribers = new ArrayList<>();
    }

    public SingletonPlatform(List<Publisher> companies, List<SimpleSubscriber> subscribers, List<Film> films) {
        this.companies = companies;
        this.subscribers = subscribers;
        this.films = films;
    }

    public Publisher getPublisher(int index) {
        return this.companies.get(index);
    }

    public void setPublisher(Publisher publisher) {
        this.companies.add(publisher);
    }

    public SimpleSubscriber getSubscriber(int index) {
        return this.subscribers.get(index);
    }

    public void setSubscriber(SimpleSubscriber subscriber) {
        this.subscribers.add(subscriber);
    }

    public List<Publisher> getPublishers() {
        return companies;
    }

    public List<SimpleSubscriber> getSubscribers() {
        return subscribers;
    }

    public List<Film> getFilms() {
        return films;
    }

    public void setFilms(Film film) {
        this.films.add(film);
    }

    public static synchronized SingletonPlatform getInstance(){
        if(instance == null){
            instance = new SingletonPlatform();
        }
        return instance;
    }

}
