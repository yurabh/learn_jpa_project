package com.validation;

import javax.validation.*;
import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Car {

    @NotNull
    @Size(min = 5, max = 10, message = "Size must be from 5 to 10")
    private String name;

    @Min(6)
    private int age;

    @AssertTrue
    private boolean isTruck;

    @NotEmpty
    private List<@NotNull String> models;

    @Valid
    private Wheel wheel;

    public Car(String name, int age, boolean isTruck, Wheel wheel) {
        this.name = name;
        this.age = age;
        this.isTruck = isTruck;
        models = new ArrayList<>();
        this.wheel = wheel;
    }

    public void addModel(String model) {
        models.add(model);
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", isTruck=" + isTruck +
                ", models=" + models +
                ", wheel=" + wheel +
                '}';
    }
}


class TestValidation {

    private static Validator validator;

    static {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();

        validator = factory.getValidator();
    }

    public static void main(String[] args) {

        Wheel ken = new Wheel(16, "Ken");

        Car car = new Car("Bmw", 7, false, ken);

        car.addModel(null);

        Set<ConstraintViolation<Car>> violations = validator.validate(car);

        if (violations.size() == 0) {

        }

        violations.forEach(v -> {
            System.out.println(v.getMessage());
            System.out.println(v.getPropertyPath());
        });
    }
}
