package com.iitu.kz.chainOfRes;

import com.iitu.kz.Builder.MovieBuilder;
import com.iitu.kz.Builder.SerialBuilder;
import com.iitu.kz.adapter.KazAdapter;
import com.iitu.kz.adapter.RusAdapter;
import com.iitu.kz.adapter.Service;
import com.iitu.kz.observer.abstractFactory.*;
import com.iitu.kz.observer.Publisher;
import com.iitu.kz.observer.SimpleSubscriber;
import com.iitu.kz.singleton.SingletonPlatform;
import com.iitu.kz.strategy.PayByCard;
import com.iitu.kz.strategy.PayByCash;
import com.iitu.kz.strategy.PaymentContext;
import com.iitu.kz.strategy.PaymentStrategy;

public class Menu extends Handler {
    private static final SingletonPlatform platform = SingletonPlatform.getInstance();
    boolean var = true;
    private static PaymentStrategy paymentStrategy;
    private static final PaymentContext context = new PaymentContext();

    @Override
    public void processHandler(SimpleSubscriber user) {
        fullPlatform();
        System.out.println("-----------Menu-----------");
        while(var){
            user = menu(user);
        }

        if (handler != null){
            handler.processHandler(user);
        }
    }

    public SimpleSubscriber menu(SimpleSubscriber user){
        System.out.println("[1] Movies\n" +
                "[2] Serials\n" +
                "[3] Search\n" +
                "[4] Companies\n" +
                "[5] Exit");
        int choice = in.nextInt();
        switch (choice) {
            case 1 -> listOfAllMovies(user);
            case 2 -> listOfAllSerials(user);
            case 3 -> search(user);
            case 4 -> companies(user);
            case 5 -> System.exit(0);
        }
        return user;
    }

    private void companies(SimpleSubscriber user) {
        boolean check = true;
        while(check) {
            System.out.println("[1] Netflix\n" +
                    "[2] Disney\n" +
                    "[3] Subscription\n" +
                    "[4] Back");
            int choice = in.nextInt();
            switch (choice) {
                case 1 -> {
                    for (Publisher publisher : platform.getPublishers()) {
                        if (publisher.getName().equals("Netflix")) {
                            System.out.println(publisher.toString());
                        }
                    }
                    for (Film film : platform.getFilms()) {
                        if (film.getStudio().equals("Netflix")) {
                            System.out.println(film);
                        }
                    }
                }
                case 2 -> {
                    for (Publisher publisher : platform.getPublishers()) {
                        if (publisher.getName().equals("Walt Disney")) {
                            System.out.println(publisher);
                        }
                    }
                    for (Film film : platform.getFilms()) {
                        if (film.getStudio().equals("Walt Disney")) {
                            System.out.println(film);
                        }
                    }
                }
                case 3 -> {
                    System.out.println("Subscribe to:\n" +
                            "[1] Walt Disney\n" +
                            "[2] Netflix");
                    int input = in.nextInt();
                    for (Publisher publisher : platform.getPublishers()) {
                        System.out.println(publisher);
                        if (publisher.getPublisherID() == input) {
                            if (subscribe(publisher)) {
                                publisher.addSubscriber(user);
                                publisher.notifySubscribers();
                            }
                        }
                    }
                }
                case 4 -> check = false;
            }
        }
    }

    private boolean subscribe(Publisher publisher) {
        paymentStrategy = null;
        double price = publisher.getSubscriptionCost();
        System.out.println("Please, select a payment method:" + "\n" +
                    "[1] Credit Card\n" +
                    "[2] Cash\n");
        int choice = in.nextInt();
        switch (choice) {
            case 1 -> paymentStrategy = new PayByCard();
            case 2 -> paymentStrategy = new PayByCash();
        }
        context.setNavigatorStrategy(paymentStrategy);
        System.out.println("Pay " + price + "tg? [y/n]");
        String answer = in.next();
        switch (answer){
            case "y":
                if (paymentStrategy.paymentStatus(price)) {
                    System.out.println("Payment has been successful.");
                    return true;
                } else {
                    System.out.println("FAIL! Please, check your data.");
                }
                break;
            case "n":
                System.exit(0);
                break;
        }
        return false;
    }

    private void search(SimpleSubscriber user) {
        System.out.println("Searh: ");
        in.nextLine();
        String search = in.nextLine();
        for (Film film: platform.getFilms()){
            if (film.getTitle().equals(search)){
                System.out.println(film.toString());
                watch(user);
            }
        }
    }

    private void listOfAllSerials(SimpleSubscriber user) {
        System.out.println("All Serials");
        for (Film film: platform.getFilms()){
            if (film instanceof EngSerial){
                System.out.println(film.toString());
            }
        }
        watch(user);

    }

    private void listOfAllMovies(SimpleSubscriber user) {
        System.out.println("All Movies:");
        for (Film film: platform.getFilms()){
            if (film instanceof EngMovie){
                System.out.println(film.toString());
            }
        }
        watch(user);
    }

    private void watch(SimpleSubscriber user){
        System.out.println("Enter the id of serial that you want to watch:");
        int serialID = in.nextInt();
        for (Film film: platform.getFilms()) {
            if (film.isFree() && film.getId() == serialID){
                languageOfFilm(film);
            }
            if (!film.isFree() && film.getId() == serialID){
                if (film.getStudio().equals(platform.getPublishers().get(1).getName())){
                    Publisher publisher = platform.getPublishers().get(1);
                    if (publisher.getSubscribers().contains(user)){
                        languageOfFilm(film);
                    }else{
                        System.out.println("Фильм платный");
                    }
                }else if (film.getStudio().equals(platform.getPublishers().get(0).getName())){
                    Publisher publisher = platform.getPublishers().get(0);
                    if (publisher.getSubscribers().contains(user)){
                        languageOfFilm(film);
                    }else{
                        System.out.println("Фильм платный");
                    }
                }
            }
        }


    }

    private void languageOfFilm(Film film){
        Service service = new Service();
        String language;
        System.out.println("In which language?\n" +
                "[1] Kaz\n" +
                "[2] Eng\n" +
                "[3] Rus");
        int i = in.nextInt();
        if ((film instanceof EngMovie || film instanceof EngSerial) && i == 3){
            language = service.changeLanguage(new RusAdapter(film));
            System.out.println(language);
            System.out.println("Хорошего просмотра");
        }else if ((film instanceof EngMovie || film instanceof EngSerial) && i == 2){
            System.out.println("Enjoy the show :)");
        }else if ((film instanceof EngMovie || film instanceof EngSerial) && i == 1){
            System.out.println(film.getLanguage());
            language = service.changeLanguage(new KazAdapter(film));
            System.out.println(language);
            System.out.println("Тез дайындал! Басталайын деп жатыр! Жүгіір!");
        }
    }

    private void fullPlatform() {
        Disney disney = new Disney(1, "Walt Disney", 1000);
        Netflix netflix = new Netflix(2, "Netflix", 1500);
        Film movie1 = disney.movieCompany(
                new MovieBuilder().setParts(8).setTitle("The Lion King").setCountry("USA, UK, South Africa").setYear(2019)
                        .setGenre("cartoon").setGenre("musical").setGenre("family").setLanguage("english").setParts(1)
                        .setProducer("Jon Favreau").setActor("James Earl Jones").isFree(false).build());
        Film movie2 = netflix.movieCompany(
                new MovieBuilder().setTitle("Passengers").setCountry("USA, Australia").setActor("Jennifer Lawrence")
                .setActor("Chris Pratt").setGenre("fantastic").setGenre("Thriller").setGenre("drama").setLanguage("english")
                        .setYear(2016).setProducer("Morten Tyldum").setLanguage("english").isFree(true).build());
        Film serial1 = disney.serialCompany(
                new SerialBuilder().setTitle("Mickey Mouse").setCountry("USA").setProducer("Paul Rudish").setYear(2013)
                        .setSeries(96).setGenre("cartoon").setLanguage("english").isFree(true).build());
        Film serial2 = netflix.serialCompany(
                new SerialBuilder().setTitle("The Queen's Gambit").setSeries(7).setYear(2020).setProducer("Scott Frank")
                .setCountry("USA").setActor("Anya Taylor-Joy").setGenre("drama").setGenre("drama").setLanguage("english")
                .isFree(false).build());
        platform.setFilms(movie1);
        platform.setFilms(movie2);
        platform.setFilms(serial1);
        platform.setFilms(serial2);
        disney.addSubscriber(users.get(0));
        netflix.addSubscriber(users.get(1));
        disney.addSubscriber(users.get(2));
        platform.setPublisher(disney);
        platform.setPublisher(netflix);
    }
}
