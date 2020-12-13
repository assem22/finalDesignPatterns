package com.iitu.kz.chainOfRes;

import com.iitu.kz.observer.SimpleSubscriber;

public class SignIn extends Handler {

    @Override
    public void processHandler(SimpleSubscriber user) {
        System.out.println("-----------Sign in-----------");
        System.out.println("Do you have an account?(y/n)");
        String input = in.next();
        if (input.equals("y")) {
            System.out.println("Login: ");
            String login = in.next();
            System.out.println("Password: ");
            String password = in.next();

            for (SimpleSubscriber checkUser: users){
                if (checkUser.getLogin().equals(login) && checkUser.getPassword().equals(password)){
                    user = checkUser;
                }else if(checkUser.getLogin().equals(login) && !checkUser.getPassword().equals(password)){
                    while(!checkUser.getPassword().equals(password)){
                        System.out.println("Wrong password. Enter password again");
                        password = in.next();
                    }
                    user = checkUser;
                }
            }
        }else{
            System.out.println("You don't have an account. Go to register page...");
        }


        if (handler != null){
            handler.processHandler(user);
        }
    }
}
