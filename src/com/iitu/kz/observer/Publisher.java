package com.iitu.kz.observer;

import java.util.ArrayList;
import java.util.List;

public abstract class Publisher {
    protected int publisherID;
    protected String name;
    protected double subscriptionCost;
    protected List<Subscriber> subscribers;

    public Publisher(int publisherID, String name, double subscriptionCost) {
        this.publisherID = publisherID;
        this.name = name;
        this.subscriptionCost = subscriptionCost;
        this.subscribers = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public double getSubscriptionCost() {
        return subscriptionCost;
    }

    public List<Subscriber> getSubscribers() {
        return subscribers;
    }

    public int getPublisherID() {
        return publisherID;
    }

    abstract public void addSubscriber(Subscriber subscriber);
    abstract public void removeSubscriber(Subscriber subscriber);
    abstract public void notifySubscribers();

    @Override
    public String toString() {
        return "Publisher{" +
                "publisherID=" + publisherID +
                ", name='" + name + '\'' +
                ", subscriptionCost=" + subscriptionCost +
                ", subscribers=" + subscribers +
                '}';
    }
}
