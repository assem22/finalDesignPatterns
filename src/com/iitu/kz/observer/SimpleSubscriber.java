package com.iitu.kz.observer;

import com.iitu.kz.observer.Publisher;
import com.iitu.kz.observer.Subscriber;

public class SimpleSubscriber implements Subscriber {
    private String name;
    private String login;
    private String password;

    public SimpleSubscriber(){}
    public SimpleSubscriber(String name, String login, String password) {
        this.name = name;
        this.login = login;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEmpty(){
        return this.name == null && this.login == null && this.password == null;
    }

    @Override
    public String toString() {
        return "SimpleSubscriber{" +
                "name='" + name + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    public void update(Publisher publisher) {
        System.out.println("One more subscriber subscribed to " + publisher.getName());
    }
}
