package com.enigmacamp.livecode3.entity;

import com.enigmacamp.livecode3.constants.Program;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "m_course_price")
@ToString
public class CourseProgram {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private @Getter @Setter Integer id;
    private @Getter @Setter Program name;
}
