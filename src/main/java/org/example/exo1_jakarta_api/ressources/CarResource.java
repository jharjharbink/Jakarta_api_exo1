package org.example.exo1_jakarta_api.ressources;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.example.exo1_jakarta_api.model.Car;
import org.example.exo1_jakarta_api.service.CarService;
import org.example.exo1_jakarta_api.util.HibernateSession;

import java.util.List;

@Path("/voiture")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CarResource {

    private final CarService carService;

    @Inject
    public CarResource() {
        this.carService = new CarService(HibernateSession.getSessionFactory());
    }

    @GET
    @Path("/{id}")
    public Car getCar(@PathParam("id") int id) {
        return carService.getCar(id);
    }

    @GET
    public List<Car> getAllCars(){
        return carService.getAllCars();
    }

    @POST
    @Path("/create")
    public boolean createCar(Car car) {
        return carService.create(car);
    }

    @POST
    public boolean updateCar(Car car) {
        return carService.update(car);
    }

    @DELETE
    @Path("/{id}")
    public boolean deleteCar(@PathParam("id") int id) {
        return carService.delete(id);
    }

}