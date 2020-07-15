package com.daquan._202007._01.spring.factory;

public class CarFactory {

    public Car getCar(){
        Car car = new Car();
        car.setBrand("aodi");
        return car;
    }

    public static Car createCar(){
        Car car = new Car();
        car.setBrand("bmw");
        return car;
    }
}
