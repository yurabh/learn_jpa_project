package com.relationship.many_to_many.uni;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "stores")
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private String address;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE})
    @JoinTable(name = "store_product", joinColumns = {@JoinColumn(name = "fk_store")},
            inverseJoinColumns = {@JoinColumn(name = "fk_product")})
    private Set<Product> products = new HashSet<>();

    public Store() {
    }

    public Store(String address, Set<Product> products) {
        this.address = address;
        this.products = products;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> stores) {
        this.products = stores;
    }

    public void addProduct(Product product) {
        this.products.add(product);
    }

    public void removeProduct(Product product) {
        this.products.remove(product);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Store store = (Store) o;
        return id == store.id &&
                Objects.equals(address, store.address) &&
                Objects.equals(products, store.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, address, products);
    }


    @Override
    public String toString() {
        return "Stores{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", stores=" + products +
                '}';
    }
}
