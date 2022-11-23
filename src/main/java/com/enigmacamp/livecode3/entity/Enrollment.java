package com.enigmacamp.livecode3.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "t_enrollment")
@ToString
public class Enrollment {
    @EmbeddedId
    private @Getter @Setter EnrollmentId id;

    public Enrollment() {
        this.id = new EnrollmentId();
    }

    @Column(name = "enroll_approval")
    private @Getter @Setter Boolean enrollApproval;

    private @Getter @Setter Integer grade;
}

