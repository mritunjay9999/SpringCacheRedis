package dev.mritunjay.springcacheredis.service;

import dev.mritunjay.springcacheredis.model.Car;

import java.util.List;

public interface CarService {

    Car getCar(int id);

    List<Car> getAllCars();

    Car saveCar(Car car);

}
