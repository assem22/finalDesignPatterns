package com.iitu.kz.chainOfRes;

import com.iitu.kz.observer.SimpleSubscriber;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class Handler {
    protected static Scanner in = new Scanner(System.in);

    protected Handler handler;
    protected List<SimpleSubscriber> users;

    public Handler() {
        this.users = new ArrayList<>();
        this.users.add(new SimpleSubscriber("Assem", "admin", "123"));
        this.users.add(new SimpleSubscriber("Bob", "bob", "123"));
        this.users.add(new SimpleSubscriber("Alice", "alice", "123"));
    }

    public Handler setNextHandler(Handler handler) {
        this.handler = handler;
        return handler;

    }

    public abstract void processHandler(SimpleSubscriber user);
}
