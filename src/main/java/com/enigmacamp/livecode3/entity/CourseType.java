package com.enigmacamp.livecode3.entity;

import com.enigmacamp.livecode3.constants.Type;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "m_course_type")
@ToString
public class CourseType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private @Getter @Setter Integer id;
    private @Getter @Setter Type name;
}
