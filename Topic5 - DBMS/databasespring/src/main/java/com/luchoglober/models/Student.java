package com.luchoglober.models;

import javax.persistence.*;

@Entity
@Table(name="student")
public class Student {

    @Id
    @SequenceGenerator(
            name="student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;

    @Column(
            name="student_id",
            nullable = false
    )
    private Integer student_id;

    @Column(
            name="first_name",
            nullable = false,
            columnDefinition ="TEXT"
    )
    private String firstName;

    @Column(
            name="last_name",
            nullable = false,
            columnDefinition ="TEXT"
    )
    private String lastName;

    @Column(
            name="mail",
            nullable = false,
            columnDefinition ="TEXT",
            unique = true
    )
    private String mail;

    @Column(
            name="cellphone",
            nullable = false
    )
    private Integer cellphone;

    public Student(Integer student_id, String firstName, String lastName, String mail, Integer cellphone) {
        super();
        this.student_id = student_id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.mail = mail;
        this.cellphone = cellphone;
    }

    public Student(){
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getStudent_id() {
        return student_id;
    }

    public void setStudent_id(Integer student_id) {
        this.student_id = student_id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Integer getCellphone() {
        return cellphone;
    }

    public void setCellphone(Integer cellphone) {
        this.cellphone = cellphone;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", student_id=" + student_id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", mail='" + mail + '\'' +
                ", cellphone=" + cellphone +
                '}';
    }
}
