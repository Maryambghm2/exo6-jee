package org.example.exo6jee.service;

import jakarta.enterprise.context.ApplicationScoped;
import org.example.exo6jee.models.Car;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class CarService {
    private List<Car> cars = new ArrayList<>();

    public Car create(String brand, LocalDate createdDate, String color) {
        int id = 1;
        id++;

        Car car = new Car(id, brand, createdDate, color);
        cars.add(car);
        return car;
    }

    public Car getById(int id) {
        return cars.get(id);
    }

    public List<Car> getCars() {
        return cars;
    }

    public Car update(int id, String brand, LocalDate createdDate, String color) {
        Car carToUpdate = getById(id);
        carToUpdate.setBrand(brand);
        carToUpdate.setColor(color);
        carToUpdate.setCreatedDate(LocalDate.now());
        return carToUpdate;
    }

    public boolean delete(int id) {
        Car carToDelete = getById(id);
        cars.remove(id);
        return true;
    }

}
