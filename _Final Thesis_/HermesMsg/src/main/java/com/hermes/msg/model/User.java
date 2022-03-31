package com.hermes.msg.model;

import javax.persistence.*;
import java.util.Collection;

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

    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id",referencedColumnName = "id")
    )
    private Collection<Role> roles;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "users_messages",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "message_id"))
    private Collection<Message> allMessages;

    public User(Long id, String username, String name, String last_name, int id_number, String address, String city, String state, String country, int zip_code, Collection<Role> roles, Collection<Message> allMessages) {
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
        this.roles = roles;
        this.allMessages = allMessages;
    }

    public User(String username, String name, String last_name, int id_number, String address, String city, String state, String country, int zip_code, Collection<Role> roles, Collection<Message> allMessages) {
        super();
        this.username = username;
        this.name = name;
        this.last_name = last_name;
        this.id_number = id_number;
        this.address = address;
        this.city = city;
        this.state = state;
        this.country = country;
        this.zip_code = zip_code;
        this.roles = roles;
        this.allMessages = allMessages;
    }

    public User() {
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

    public Collection<Role> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }

    public Collection<Message> getAllMessages() {
        return allMessages;
    }

    public void setAllMessages(Collection<Message> allMessages) {
        this.allMessages = allMessages;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", id_number=" + id_number +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                ", zip_code=" + zip_code +
                ", roles=" + roles +
                ", allMessages=" + allMessages +
                '}';
    }
}
