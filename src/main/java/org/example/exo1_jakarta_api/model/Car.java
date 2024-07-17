package org.example.exo1_jakarta_api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Car {
    @Id
    @GeneratedValue
    long id;
    String model;
    int fabricationYear;
    String color;

    public Car() {}

    public Car(String model, int fabricationYear, String color) {
        this.model = model;
        this.fabricationYear = fabricationYear;
        this.color = color;
    }
}
