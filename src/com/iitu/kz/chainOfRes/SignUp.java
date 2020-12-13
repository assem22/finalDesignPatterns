package com.iitu.kz.chainOfRes;


import com.iitu.kz.observer.SimpleSubscriber;

import java.util.ArrayList;
import java.util.List;

public class SignUp extends Handler {
    @Override
    public void processHandler(SimpleSubscriber user) {
        if (user.isEmpty()){
            System.out.println("-----------Sign up-----------");
            System.out.println("Name: ");
            String name = in.next();
            System.out.println("Login: ");
            String login = in.next();


            List<String> logins = new ArrayList<>();
            for (SimpleSubscriber iUser: users){
                logins.add(iUser.getLogin());
            }

            while (logins.contains(login)){
                System.out.println("login already exits. Try again");
                login = in.next();
            }

            System.out.println("Password: ");
            String password = in.next();
            System.out.println("Repeat password: ");
            String repeatPassword = in.next();
            while(!password.equals(repeatPassword)){
                System.out.println("Passwords doesn't match.\nEnter password again: ");
                password = in.next();
                System.out.println("Repeat password: ");
                repeatPassword = in.next();
            }

            user = new SimpleSubscriber(name, login, password);
        }
        System.out.println("Welcome, " + user.getName());

        if (handler != null){
            handler.processHandler(user);
        }
    }
}
