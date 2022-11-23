package com.enigmacamp.livecode3.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "t_schedule")
@ToString
public class CourseSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private @Getter @Setter Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "course_id", nullable = false)
    private @Getter @Setter @ToString.Exclude Course course;

    @Column(name = "start_date")
    private @Getter @Setter Date startDate;

    @Column(name = "end_date")
    private @Getter @Setter Date endDate;

    @Column(name = "start_time")
    private @Getter @Setter Timestamp startTime;

    @Column(name = "end_time")
    private @Getter @Setter Timestamp endTime;

    @Column(name = "trainer_name")
    private @Getter @Setter String trainerName;
}
