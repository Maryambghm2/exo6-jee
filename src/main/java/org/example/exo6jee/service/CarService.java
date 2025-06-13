package org.example.exo6jee.service;

import jakarta.enterprise.context.ApplicationScoped;
import org.example.exo6jee.models.Car;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class CarService {
    private List<Car> cars = new ArrayList<>();
    private int nextId = 1;

    public Car create(String brand, int createdDate, String color) {


        Car car = new Car(nextId++, brand, createdDate, color);
        cars.add(car);
        return car;
    }

    public Car getById(int id) {
        for (Car car : cars) {
            if (car.getId() == id) {
                return car;
            }
        }
        return null;
    }

    public List<Car> getCars() {
        return cars;
    }

    public Car update(int id, String brand, int createdDate, String color) {
        Car carToUpdate = getById(id);
        carToUpdate.setBrand(brand);
        carToUpdate.setColor(color);
        carToUpdate.setCreatedDate(createdDate);
        return carToUpdate;
    }

    public boolean delete(int id) {
        Car carToDelete = getById(id);
        cars.remove(carToDelete);
        return true;
    }

}
