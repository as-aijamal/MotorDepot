package com.company;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        Car[] cars = {
                new Car(1, "Renault", "", "base"),
                new Car(2, "Volvo  ", "", "base"),
                new Car(3, "DAF XT ", "", "base")};

        Driver[] drivers = {
                new Driver("driver-1", "John"),
                new Driver("driver-2", "Liam"),
                new Driver("driver-3", "Adam")};

        print(cars);
        print(drivers);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        while (true) {
            System.out.println("Choose one of the trucks: ");
            int input = scanner.nextInt();
            scanner.nextLine();
            Driver.getInfo(cars[input - 1]);
            ServiceImpl service = new ServiceImpl();
            getInstruction();
            String action = scanner.nextLine();
            if (action.equals("1")) {
                service.changeDriver(cars[input - 1], drivers[input - 1]);
            } else if (action.equals("2")) {
                service.startDriving(cars[input - 1], drivers[input - 1]);
            } else if (action.equals("3")) {
                service.startRepair(cars[input - 1], drivers[input - 1]);
            }
            print(cars);
            print(drivers);
        }
    }

    public static void print(Car[] cars) {
        System.out.println("~~~~~~~~~~~~ * TRUCKS * ~~~~~~~~~~~~");
        System.out.println(" # |    Bus    |  Driver  |  State");
        System.out.println("---+-----------+----------+---------");
        for (int j = 0; j < cars.length; j++) {
            System.out.println(cars[j]);
        }
    }

    public static void print(Driver[] drivers) {
        System.out.println("~~~~~~~~~~ * DRIVERS * ~~~~~~~~~~~~~");
        System.out.println("     #    |   Driver   |   Bus      ");
        System.out.println("----------+------------+------------");
        for (int j = 0; j < drivers.length; j++) {
            System.out.println(drivers[j]);
        }
    }

    public static void getInstruction() {
        System.out.println("Press to 1 to change driver");
        System.out.println("Press to 2 to start driving");
        System.out.println("Press to 3 to start repair");
    }
}