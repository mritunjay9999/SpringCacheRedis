package dev.mritunjay.springcacheredis.controller;

import dev.mritunjay.springcacheredis.model.Car;
import dev.mritunjay.springcacheredis.service.CarService;
import org.hibernate.annotations.Cache;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CarController {

    private CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @Cacheable(value = "car")
    @GetMapping("/car")
    public List<Car> getAllCarDetails(){
        return carService.getAllCars();
    }

    @Cacheable(value = "car")
    @GetMapping("/car/{id}")
    public Car getSingleCarDetails(@PathVariable("id") int id){
        return carService.getCar(id);
    }

    @CachePut(value = "car" , key = "#car.id" , unless = "car.brand == null")
    @PostMapping("/car")
    public Car saveCar(@RequestBody Car car){
        return carService.saveCar(car);
    }

    @CachePut(value = "car" , key = "#car.id" , unless = "#car.brand == null")
    @PutMapping("/car/{id}")
    public Car updateCar(@PathVariable("id") int id , @RequestBody Car car){
//        Calls service and updates the values of car with given id
        return null;
    }

    @CacheEvict( value = "car" , key = "#car.id")
    @DeleteMapping("/car/{id}")
    public Car deleteCar(@PathVariable("id") int id){
//        Call service to delete the item from db
//        return null;

        Car c = carService.getCar(id);
        carService.deleteCar(id);
        return c;
    }
}
