package org.example.exo1_jakarta_api.service;

import jakarta.enterprise.context.ApplicationScoped;
import org.example.exo1_jakarta_api.model.Car;
import org.example.exo1_jakarta_api.repository.CarRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;


@ApplicationScoped
public class CarService {
    private CarRepository carRepository;
    private SessionFactory _sessionFactory;
    private Session session;

    public CarService() {}
    public CarService(SessionFactory _sessionFactory) {this._sessionFactory = _sessionFactory;}

    public Car getCar(int id){
        Car car = null;
        session = _sessionFactory.openSession();
        carRepository = new CarRepository(session);
        try {
            car = carRepository.findById(id);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return car;
    }

    public List<Car> getAllCars() {
        List<Car> cars = null;
        session = _sessionFactory.openSession();
        carRepository = new CarRepository(session);
        try {
            cars = carRepository.findAll();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            session.close();
        }
        return cars;
    }


    public boolean create(Car car) {
        boolean result = false;
        session = _sessionFactory.openSession();
        session.beginTransaction();
        carRepository= new CarRepository(session);
        try {
            carRepository.create(car);
            session.getTransaction().commit();
            result = true;
        }catch (Exception except){
            try {
                session.getTransaction().rollback();
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }finally {
            session.close();
        }
        return result;
    }

    public boolean update(Car car) {
        boolean result = false;
        session = _sessionFactory.openSession();
        session.beginTransaction();
        carRepository= new CarRepository(session);
        try {
            carRepository.update(car);
            session.getTransaction().commit();
            result = true;
        }catch (Exception except){
            try {
                session.getTransaction().rollback();
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }finally {
            session.close();
        }
        return result;
    }

    public boolean delete(int id) {
        boolean result = false;
        session = _sessionFactory.openSession();
        session.beginTransaction();
        carRepository= new CarRepository(session);
        Car car = carRepository.findById(id);
        try {
            carRepository.delete(car);
            session.getTransaction().commit();
            result = true;
        }catch (Exception except){
            try {
                session.getTransaction().rollback();
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }finally {
            session.close();
        }
        return result;
    }


}
