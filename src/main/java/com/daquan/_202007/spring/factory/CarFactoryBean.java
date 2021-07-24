package com.daquan._202007.spring.factory;

import org.springframework.beans.factory.FactoryBean;

public class CarFactoryBean implements FactoryBean<Car> {

    private String carInfo;

    @Override
    public Car getObject() throws Exception {
        Car car = new Car();
        car.setBrand(carInfo);
        return car;
    }

    @Override
    public Class<?> getObjectType() {
        return Car.class;
    }

    public String getCarInfo(){
        return carInfo;
    }

    public void setCarInfo(String carInfo){
        this.carInfo = carInfo;
    }
}
