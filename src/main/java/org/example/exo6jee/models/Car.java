package org.example.exo6jee.models;

import java.time.LocalDate;

public class Car {
    private int id;
    private String brand;
    private LocalDate createdDate;
    private String color;

    public Car(int id, String brand, LocalDate createdDate, String color) {
        this.id = id;
        this.brand = brand;
        this.createdDate = createdDate;
        this.color = color;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }
}
