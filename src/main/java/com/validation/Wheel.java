package com.validation;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

public class Wheel {

    @Min(15)
    private int radius;

    @NotNull
    @Length(min = 5)
    private String manufacturer;

    public Wheel(@Size(min = 15) int radius, @NotNull @Length(min = 5) String manufacturer) {
        this.radius = radius;
        this.manufacturer = manufacturer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Wheel wheel = (Wheel) o;
        return radius == wheel.radius &&
                Objects.equals(manufacturer, wheel.manufacturer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(radius, manufacturer);
    }

    @Override
    public String toString() {
        return "Wheel{" +
                "radius=" + radius +
                ", manufacturer='" + manufacturer + '\'' +
                '}';
    }
}
