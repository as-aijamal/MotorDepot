package com.company;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Driver {
    public static final GsonBuilder BUILDER = new GsonBuilder();
    public static final Gson GSON = BUILDER.setPrettyPrinting().create();
    public static final Path WRITE_PATH = Paths.get("./drivers.json");
    private String id;
    private String driver;
    private String bus;

    public String getBus() {
        return bus;
    }

    public void setBus(String bus) {
        this.bus = bus;
    }

    public Driver(String id, String driver) {
        this.id = id;
        this.driver = driver;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public static void getDrivers() {

        Driver[] drivers = {
                new Driver("driver-1", "John"),
                new Driver("driver-2", "Liam"),
                new Driver("driver-3", "Adam")};

        Gson gson=new Gson();
        String json=GSON.toJson(drivers);
        writeDriverFile(json);
        System.out.println(readDriverFile());

        Driver[] drivers1 = GSON.fromJson(readDriverFile(), Driver[].class);
        for (Driver driver : drivers1) {
            System.out.println(driver.toString());
        }
    }

    public static void writeDriverFile(String object) {
        Path write = Paths.get(String.valueOf(WRITE_PATH));
        try {
            Files.writeString(write, object, StandardOpenOption.CREATE, StandardOpenOption.WRITE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String readDriverFile() {
        String json = "";
        try {
            FileReader fileReader = new FileReader(String.valueOf(WRITE_PATH));
            int a;
            while ((a = fileReader.read()) != -1) {
                json += (char) a;
            }
            return json;
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return json;
    }

    public static void getInfo(Car car) {
        System.out.println("N: " + car.getId());
        System.out.println("Name: " + car.getName());
        System.out.println("Driver: " + car.getDriver());
        System.out.println("State: " + car.getState());
    }

    @Override
    public String toString() {
        return
                " " + id +
                        " |    " + driver +
                        "    |" + bus;
    }
}
