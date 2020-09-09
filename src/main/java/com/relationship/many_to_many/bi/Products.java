package com.relationship.many_to_many.bi;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "product")
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private String description;

    @ManyToMany(mappedBy = "products", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    private Set<Stores> stores = new HashSet<>();

    public Products() {
    }

    public Products(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Stores> getStores() {
        return stores;
    }

    public void setStores(Set<Stores> stores) {
        this.stores = stores;
    }

    @Override
    public String toString() {
        return "Products{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", stores=" + stores +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Products products = (Products) o;
        return id == products.id &&
                Objects.equals(description, products.description) &&
                Objects.equals(stores, products.stores);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, stores);
    }
}
