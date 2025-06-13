package org.example.exo6jee.resources;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.example.exo6jee.models.Car;
import org.example.exo6jee.service.CarService;

import java.time.LocalDate;
import java.util.List;

@Path("/cars")
public class CarResource {
    private CarService carService;

    @Inject
    public CarResource(CarService carService) {
        this.carService = carService;
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Car> getAll() {
        System.out.println("Listes voitures");
        return carService.getCars();

    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Car getCarById(@PathParam("id") int id) {
        return carService.getById(id);
    }

    @POST
    @Path("/new")
    @Produces(MediaType.APPLICATION_JSON)
    public Car createCar(String brand, LocalDate createDate, String color) {
        return carService.create(brand, createDate, color);
    }


}
