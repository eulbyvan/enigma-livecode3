package com.enigmacamp.livecode3.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "sys_user_credential")
@ToString
public class UserCredential {
    @Id
    private @Getter @Setter String email;
    private @Getter @Setter String password;
}
