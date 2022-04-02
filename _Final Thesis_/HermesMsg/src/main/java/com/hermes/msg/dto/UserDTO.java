package com.hermes.msg.dto;

import com.hermes.msg.model.Message;
import com.hermes.msg.model.Role;

import java.util.Collection;

public class UserDTO {

    private Long id;
    private String username;
    private String name;
    private String last_name;
    private int id_number;
    private String address;
    private String city;
    private String state;
    private String country;
    private int zip_code;

    public UserDTO() {
        super();
    }

    public UserDTO(Long id, String username, String name, String last_name, int id_number, String address, String city, String state, String country, int zip_code, Collection<Role> roles, Collection<Message> allMessages) {
        super();
        this.id = id;
        this.username = username;
        this.name = name;
        this.last_name = last_name;
        this.id_number = id_number;
        this.address = address;
        this.city = city;
        this.state = state;
        this.country = country;
        this.zip_code = zip_code;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public int getId_number() {
        return id_number;
    }

    public void setId_number(int id_number) {
        this.id_number = id_number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getZip_code() {
        return zip_code;
    }

    public void setZip_code(int zip_code) {
        this.zip_code = zip_code;
    }
}
