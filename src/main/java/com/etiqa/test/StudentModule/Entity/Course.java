package com.etiqa.test.StudentModule.Entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "T_COURSE")
public class Course {

    @Id
    @NotNull
    @GeneratedValue
    private Long id;

    @Column(name = "course_name")
    private String title;

    @Column(name = "description")
    private String description;

    public Course() {
        super();
    }

    public Course(Long id, String title, String description) {
        super();
        this.id = id;
        this.title = title;
        this.description = description;
    }

    @Override
    public String toString() {
        return this.id + ", " + this.title + ", " + this.description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
