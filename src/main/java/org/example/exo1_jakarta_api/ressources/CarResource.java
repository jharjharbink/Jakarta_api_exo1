package org.example.exo1_jakarta_api.ressources;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.example.exo1_jakarta_api.model.Car;
import org.example.exo1_jakarta_api.service.CarService;
import org.example.exo1_jakarta_api.util.HibernateSession;

import java.util.List;

@Path("/voiture")
public class CarResource {

    private final CarService carService;

    @Inject
    public CarResource() {
        this.carService = new CarService(HibernateSession.getSessionFactory());
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Car getCar(@PathParam("id") int id) {
        return carService.getCar(id);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Car> getAllCars(){
        return carService.getAllCars();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/create")
    public boolean createCar(Car car) {
        return carService.create(car);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/update")
    public boolean updateCar(Car car) {
        return carService.update(car);
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("delete/{id}")
    public boolean deleteCar(@PathParam("id") int id) {
        return carService.delete(id);
    }

}