package com.narel.online_store.model;

import lombok.Data;


import javax.persistence.*;

@Data

@Entity
@Table(name="product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    private String picture;

    private double price;
//
//    private boolean availability;
//
//    private double weight;

    private String cpu;
//
//    private int core;

}
