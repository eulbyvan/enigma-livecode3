package com.enigmacamp.livecode3.entity;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Embeddable
public class EnrollmentId implements Serializable {
    private @Getter @Setter Integer trainee_id;
    private @Getter @Setter Integer schedule_id;
}
