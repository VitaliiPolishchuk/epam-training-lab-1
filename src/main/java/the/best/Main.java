package the.best;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Main {

    static Room room;

    public static void main(String[] args) {
//        Room room = new Room(Room.AgeGroup.ADULT, 1500, 10);

//        room.sort(Toy.Fields.VOLUME);
//        Properties properties = new Properties();
//        properties.put(Toy.Fields.PRICE, new Properties.Interval(132.02,132.03));
//
//        List<Toy> searchedToys = room.search(properties);
//
//        System.out.println(Toy.getTitles());
//        searchedToys
//                .stream()
//                .forEach(System.out::println);

        System.out.println("Hello friend!\n");

        setRoom();

    }

    private static void setRoom(){
        System.out.printf("Enter age group(1-3), capital(170-5000), maximum toys allowed(7-20):\nAge group:\n\t1. %s\n\t2. %s\n\t3. %s\n",
                Room.AgeGroup.BABY,
                Room.AgeGroup.TEENAGE,
                Room.AgeGroup.ADULT);
        System.out.println("Example:\n\t\t2,1000,20\nThat means we create room for teenagers " +
                "with capital 1000$ and maximum toys allowed 20.");

        Scanner scanner = new Scanner(System.in);
        String[] roomArgs = scanner.nextLine().split("\\,");
        System.out.println(roomArgs.length);
        Room.AgeGroup ageGroup = Room.AgeGroup.BABY;
        switch (Integer.parseInt(roomArgs[0])) {
            case 1:
                ageGroup = Room.AgeGroup.TEENAGE;
                break;
            case 2:
                ageGroup = Room.AgeGroup.TEENAGE;
                break;
            case 3:
                ageGroup = Room.AgeGroup.ADULT;
                break;
        }



        room = new Room(ageGroup,
                Double.parseDouble(roomArgs[1]),
                Integer.parseInt(roomArgs[2]));

        room.addToy(new Car("Tesla model Y", 29.99, 0.5, 0.11,18.64));
        room.addToy(new Doll("Transformer Prime", 49.99, 3.35, 0.2,Doll.State.MALE));
        room.addToy(new Doll("Slinky® Dog", 13.99, 0.12, 0.01,Doll.State.MALE));
        room.addToy(new Car("Lightning McQueen", 39.99, 0.5, 0.09,30));
        room.addToy(new Ball("Adidas", 34.99, 1.67, .33, 0.98));

        System.out.println(room);

        manipulateRoom();
    }

    private static void manipulateRoom(){
        while(true) {
            System.out.println("User interface:\n\t1. Add toy\n\t2. Sort\n\t3. Search\n\t4. Exit");
            switch (new Scanner(System.in).nextInt()) {
                case 1:
                    addToy();
                    break;
                case 2:
                    sort();
                    break;
                case 3:
                    searchToys();
                    break;
                case 4:
                    return;
            }

        }
    }

    private static void searchToys(){
        System.out.println("Use following pattern\n\t\tField1:start1-end1[,Field2:start2-end2[...]]\n" +
                "Real example:\n\t\t1:0-150\nThis means we will search toys with price from 0$ to 150$");
        System.out.printf("Field are:\n\t1. %s\n\t2. %s\n\t3. %s\n",
                Toy.Fields.PRICE,
                Toy.Fields.WEIGHT,
                Toy.Fields.VOLUME);

        String[] argsSearch = new Scanner(System.in).nextLine().split("\\,");

        Properties properties = new Properties();

        for(String argSearch : argsSearch){
            Toy.Fields toyTield = Toy.Fields.PRICE;
            switch (Integer
                    .parseInt(argSearch.substring(0,
                                                  argSearch.indexOf(":")))){

                case 1:
                    toyTield = Toy.Fields.PRICE;
                    break;
                case 2:
                    toyTield = Toy.Fields.WEIGHT;
                    break;
                case 3:
                    toyTield = Toy.Fields.VOLUME;
                    break;
            }
            String[] argsInterval = argSearch.substring(argSearch.indexOf(":") + 1).split("\\-");
            properties.put(toyTield, new Properties.Interval(Double.parseDouble(argsInterval[0]),
                                                             Double.parseDouble(argsInterval[1])));
        }


        List<Toy> searchedToys = room.search(properties);
        if(searchedToys == null || searchedToys.isEmpty()){
            return;
        }
        System.out.println(Toy.getTitles());
        searchedToys
                .stream()
                .forEach(System.out::println);
    }

    private static void sort(){
        System.out.printf("Sort by:\n\t1. %s\n\t2. %s\n\t3. %s\n",
                Toy.Fields.PRICE,
                Toy.Fields.WEIGHT,
                Toy.Fields.VOLUME);

        Toy.Fields toyField = Toy.Fields.PRICE;
        switch (new Scanner(System.in).nextInt()){
            case 1:
                toyField = Toy.Fields.PRICE;
                break;
            case 2:
                toyField = Toy.Fields.WEIGHT;
                break;
            case 3:
                toyField = Toy.Fields.VOLUME;
                break;
        }

        room.sort(toyField);
        System.out.println(room);
    }

    private static void addToy(){
        System.out.println("Add\n\t1.Car\n\t2.Doll\n\t3.Ball \n");
        switch (new Scanner(System.in).nextInt()){
            case 1:
                addCar();
                break;
            case 2:
                addDoll();
                break;
            case 3:
                addBall();
                break;
        }
    }

    private static void addCar(){
        System.out.println("Enter name, price(0-150), weight(0-150), volume(0-150), speed(0-150)\n");
        System.out.println("Example:\n\t\tTesla model X,90,2,0.33,15\n" +
                "This means we create car 'Tesla model X' with price 90$," +
                " with weight 2 kg, with volume 0.33 m^3 and speed 15 km/m");
        Scanner scanner = new Scanner(System.in);
        String[] carArgs = scanner.nextLine().split("\\,");
        System.out.println(carArgs.length);

        addToyToRoom(new Car(carArgs[0],
                Double.parseDouble(carArgs[1]),
                Double.parseDouble(carArgs[2]),
                Double.parseDouble(carArgs[3]),
                Double.parseDouble(carArgs[4])));
        System.out.println(room);
    }

    private static void addDoll(){
        System.out.printf("Enter name, price(0-150), weight(0-150), volume(0-150), state(1-3)\nState\n\t1. %s\n\t2. %s\n\t3. %s\n",
                Doll.State.MALE,
                Doll.State.FEMALE,
                Doll.State.UNKNOWN);
        System.out.println("Example:\n\t\tBarbie,25,0.15,0.05,2\n" +
                "This means we create doll 'Barbie' with price 25$," +
                " with weight 0.15 kg, with volume 0.05 m^3 and state Female");
        Scanner scanner = new Scanner(System.in);
        String[] dollArgs = scanner.nextLine().split("\\,");
        System.out.println(dollArgs.length);

        Doll.State dollState = Doll.State.UNKNOWN;

        switch (Integer.parseInt(dollArgs[4])){
            case 1:
                dollState = Doll.State.MALE;
                break;
            case 2:
                dollState = Doll.State.FEMALE;
                break;
        }

        addToyToRoom(new Doll(dollArgs[0],
                Double.parseDouble(dollArgs[1]),
                Double.parseDouble(dollArgs[2]),
                Double.parseDouble(dollArgs[3]),
                dollState));
        System.out.println(room);
    }

    private static void addBall(){
        System.out.println("Enter name, price(0-150), weight(0-150), volume(0-150), fullness(0-1)\n");
        System.out.println("Example:\n\t\tAdidas,50,0.33,0.15,0.95\n" +
                "This means we create ball 'Adidas' with price 50$," +
                " with weight 0.33 kg, with volume 0.15 m^3 and fullness 95%");
        Scanner scanner = new Scanner(System.in);
        String[] ballArgs = scanner.nextLine().split("\\,");
        System.out.println(ballArgs.length);

        addToyToRoom(new Ball(ballArgs[0],
                Double.parseDouble(ballArgs[1]),
                Double.parseDouble(ballArgs[2]),
                Double.parseDouble(ballArgs[3]),
                Double.parseDouble(ballArgs[4])));
        System.out.println(room);
    }

    private static void addToyToRoom(Toy toy){
        if(room.canAddToy(toy)){
            room.addToy(toy);
        } else {
            System.out.println("Can`t add toy");
        }
    }
}
