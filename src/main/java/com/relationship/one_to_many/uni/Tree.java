package com.relationship.one_to_many.uni;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Tree {

    @Id
    @GeneratedValue
    private int id;

    @Column
    private String name;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE})
    @JoinTable(name = "tree_leaf",
            joinColumns = @JoinColumn(name = "tree_fk_id"),
            inverseJoinColumns = @JoinColumn(name = "leaf_fk_id"))
    private List<Leaf> leaves = new ArrayList<Leaf>();

    public Tree() {
    }


    public Tree(String name) {
        this.name = name;
    }

    public void addLeaf(Leaf leaf) {
        leaves.add(leaf);
    }
}
