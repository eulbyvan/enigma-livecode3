package com.enigmacamp.livecode3.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name = "m_course")
@ToString
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private @Getter @Setter Integer id;

    private @Getter @Setter String name;

    private @Getter @Setter String description;

    @Column(name = "duration_in_day")
    private @Getter @Setter String durationInDay;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "course_type")
    private @Getter @Setter @ToString.Exclude CourseType type;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "course_program")
    private @Getter @Setter
    @ToString.Exclude CourseProgram program;

    @Column(name = "passing_grade")
    private @Getter @Setter Integer passingGrade;

    @OneToMany(mappedBy = "course")
    private @Getter @Setter @ToString.Exclude List<CourseSchedule> courseSchedules;
}
