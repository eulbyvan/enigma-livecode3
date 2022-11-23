package com.enigmacamp.livecode3.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "sys_user_credential")
@ToString
public class UserCredential {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private @Getter @Setter Integer id;

    @Column(unique = true, nullable = false)
    private @Getter @Setter String email;

    private @Getter @Setter String password;

    @Column(name = "is_active", nullable = false)
    private @Getter @Setter Boolean isActive;
}
