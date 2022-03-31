package com.hermes.msg.model;

import javax.persistence.*;

@Entity(name="user")
@Table(name="user",uniqueConstraints = {@UniqueConstraint(columnNames = {"username"})})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="username",nullable=false)
    private String username;

    @Column(name="name",nullable=false)
    private String name;

    @Column(name="last_name",nullable=false)
    private String last_name;

    @Column(name="id_number",nullable=false)
    private int id_number;

    @Column(name="address",nullable=false)
    private String address;

    @Column(name="city",nullable=false)
    private String city;

    @Column(name="state",nullable=false)
    private String state;

    @Column(name="country",nullable=false)
    private String country;

    @Column(name="zip_code",nullable=false)
    private int zip_code;


}
