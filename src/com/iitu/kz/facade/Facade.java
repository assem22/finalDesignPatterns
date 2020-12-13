package com.iitu.kz.facade;

import com.iitu.kz.chainOfRes.Handler;
import com.iitu.kz.chainOfRes.Menu;
import com.iitu.kz.chainOfRes.SignIn;
import com.iitu.kz.chainOfRes.SignUp;
import com.iitu.kz.observer.SimpleSubscriber;

public class Facade {
    public void start(){
        SimpleSubscriber user = new SimpleSubscriber();
        Handler signIn = new SignIn();

        signIn.setNextHandler(new SignUp()).setNextHandler(new Menu());
        signIn.processHandler(user);
    }
}
