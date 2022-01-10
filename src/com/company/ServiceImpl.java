package com.company;

import java.util.Random;

public class ServiceImpl implements Service {


    @Override
    public void changeDriver(Car car, Driver driver) {
        if (car.getState().equals("base")) {
            car.setDriver(driver.getDriver());
            driver.setBus(car.getName());
        } else if (car.getState().equals("route")) {
            System.out.println("Driver is already on the road!!!");
        } else {
            System.out.println("You can't change the driver!!!");
        }
    }

    @Override
    public void startDriving(Car car, Driver driver) {
        if (car.getState().equals("base")) {
            if (!car.getDriver().equals("")) {
                car.setState("route");
                System.out.println("Driver started his way successfully!");
            } else {
                System.out.println("There is no driver!!!");
            }
        } else if (car.getState().equals("route")) {
            System.out.println("Driver is ALREADY on the way!!!");
        } else {
            Random random = new Random();
            int rnd = random.nextInt(2);
            if (rnd == 0) {
                car.setState("route");
                System.out.println("Truck is on the way!!!");
            } else {
                car.setState("base");
                System.out.println("Truck is in the base");
            }
        }
    }

    @Override
    public void startRepair(Car car, Driver driver) {
        if (car.getState().equals("base")) {
            car.setState("repair");
            System.out.println("Truck is under repairing now!!!");
        } else if (car.getState().equals("route")) {
            car.setState("repair");
        } else {
            System.out.println("Truck is ALREADY under repair!!!");
        }
    }
}
