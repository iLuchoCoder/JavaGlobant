package com.luchoglober.models;

import javax.persistence.*;

@Entity
@Table(name="course")
public class Course {

    @Id
    @SequenceGenerator(
            name="course_sequence",
            sequenceName = "course_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "course_sequence"
    )
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;

    @Column(
            name="course_id",
            nullable = false
    )
    private Integer course_id;

    @Column(
            name="course_name",
            nullable = false,
            columnDefinition ="TEXT"
    )
    private String courseName;

    public Course(Integer course_id, String courseName) {
        super();
        this.course_id = course_id;
        this.courseName = courseName;
    }

    public Course(){
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCourse_id() {
        return course_id;
    }

    public void setCourse_id(Integer course_id) {
        this.course_id = course_id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", course_id=" + course_id +
                ", courseName='" + courseName + '\'' +
                '}';
    }
}
