package com.weather.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="temperature")
public class Temperature {

    @Id
    @SequenceGenerator(
            name = "temperature_sequence",
            sequenceName = "temperature_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "temperature_sequence"
    )
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;

    @Column(
            name = "date",
            nullable = false
    )
    private Date date;

    @Column(
            name = "latitude",
            nullable = false
    )
    private float latitude;

    @Column(
            name = "longitude",
            nullable = false
    )
    private float longitude;

    @Column(
            name = "city",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String city;

    @Column(
            name = "state",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String state;

    @Column(
            name = "country",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String country;

    @Column(
            name = "temperature",
            nullable = false
    )
    private float temperature;

    public Temperature() {
    }

    public Temperature(Date date, float latitude, float longitude, String city, String state, String country, float temperature) {
        super();
        this.date = date;
        this.latitude = latitude;
        this.longitude = longitude;
        this.city = city;
        this.state = state;
        this.country = country;
        this.temperature = temperature;
    }

    public Temperature(Long id, Date date, float latitude, float longitude, String city, String state, String country, float temperature) {
        super();
        this.id = id;
        this.date = date;
        this.latitude = latitude;
        this.longitude = longitude;
        this.city = city;
        this.state = state;
        this.country = country;
        this.temperature = temperature;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
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

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    @Override
    public String toString() {
        return "Temperature{" +
                "id=" + id +
                ", date=" + date +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                ", temperature=" + temperature +
                '}';
    }
}