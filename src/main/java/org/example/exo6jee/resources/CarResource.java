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

// http://localhost:8080/exo6_jee_war_exploded/api/cars
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Car> getAll() {
        return carService.getCars();

    }

    // http://localhost:8080/exo6_jee_war_exploded/api/cars/:id
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Car getCarById(@PathParam("id") int id) {
        return carService.getById(id);
    }

    // http://localhost:8080/exo6_jee_war_exploded/api/cars/new
    @POST
    @Path("/new")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Car createCar(Car car) {
        return carService.create(car.getBrand(), car.getCreatedDate(), car.getColor());
    }


// http://localhost:8080/exo6_jee_war_exploded/api/cars/update/:id
    @PUT
    @Path("/update/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Car updateCar(@PathParam("id") int id, Car carToUpdate) {
        return carService.update(id, carToUpdate.getBrand(), carToUpdate.getCreatedDate(), carToUpdate.getColor());
    }

    // http://localhost:8080/exo6_jee_war_exploded/api/cars/delete/:id
    @DELETE
    @Path("/delete/{id}")
    public String delete(@PathParam("id") int id) {
        carService.delete(id);
        return ("Voiture avec l'id "+ id + " supprimé .");
    }

}
