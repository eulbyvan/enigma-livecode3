package com.enigmacamp.livecode3.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "t_enrollment")
public class Enrollment {
    @EmbeddedId
    private EnrollmentId id;

    public Enrollment() {
        this.id = new EnrollmentId();
    }

    private Boolean enroll_approval;
    private Integer grade;
}

