package org.example.exo1_jakarta_api.repository;

import org.example.exo1_jakarta_api.model.Car;
import org.hibernate.Session;

import java.util.List;

public class CarRepository extends BaseRepository<Car> {
    public CarRepository(Session session) {
        super(session);
    }

    @Override
    public Car findById(int id) {
        return _session.get(Car.class,id);
    }

    @Override
    public List<Car> findAll() {
        return _session.createQuery("from Car ").list();
    }
}
