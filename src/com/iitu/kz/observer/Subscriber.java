package com.iitu.kz.observer;

import com.iitu.kz.observer.Publisher;

public interface Subscriber {
    void update(Publisher publisher);
}
