package com.iitu.kz.observer.abstractFactory;

import com.iitu.kz.observer.Publisher;
import com.iitu.kz.observer.Subscriber;

public class Disney extends Publisher implements FilmStudio {

    public Disney(int publisherID, String name, double subscriptionCost) {
        super(publisherID, name, subscriptionCost);
    }

    @Override
    public void addSubscriber(Subscriber subscriber) {
        this.subscribers.add(subscriber);
    }

    @Override
    public void removeSubscriber(Subscriber subscriber) {
        this.subscribers.remove(subscriber);
    }

    @Override
    public void notifySubscribers() {
        for(Subscriber subscriber: subscribers){
            subscriber.update(this);
        }
    }

    @Override
    public EngMovie movieCompany(Film movie) {
        movie.setStudio("Walt Disney");
        return (EngMovie) movie;
    }

    @Override
    public EngSerial serialCompany(Film serial) {
        serial.setStudio("Walt Disney");
        return (EngSerial) serial;
    }

    @Override
    public String toString() {
        return "Disney{" +
                "name='" + name + '\'' +
                ", subscriptionCost=" + subscriptionCost +
                ", subscribers=" + subscribers.size() +
                '}';
    }
}
