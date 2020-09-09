package com.relationship.many_to_many.bi;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "store")
public class Stores {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private String name;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    @JoinTable(name = "stores_products", joinColumns = {@JoinColumn(name = "fk_store")}
            , inverseJoinColumns = {@JoinColumn(name = "fk_product")})
    private Set<Products> products = new HashSet<>();

    public Stores() {
    }

    public Stores(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Products> getProducts() {
        return products;
    }

    public void setProducts(Set<Products> products) {
        this.products = products;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stores stores = (Stores) o;
        return id == stores.id &&
                Objects.equals(name, stores.name) &&
                Objects.equals(products, stores.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, products);
    }

    @Override
    public String toString() {
        return "Stores{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", products=" + products +
                '}';
    }

    public void addProduct(Products products) {
        this.products.add(products);
    }
}
