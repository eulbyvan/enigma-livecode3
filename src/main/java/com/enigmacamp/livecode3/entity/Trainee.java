package com.enigmacamp.livecode3.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "sys_trainee")
@ToString
public class Trainee {
//    o Nama depan
//    o Nama belakang
//    o Nama panggilan
//    o Alamat domisili sekarang
//    o Alamat email
//    o Nomor telepon
//    o Nomor KTP
//    o Pendidikan terakhir (SMA/SMK, S1, S2, D3, D4)

    @Id
    private @Getter @Setter Integer id;
    private @Getter @Setter String firstName;
    private @Getter @Setter String lastName;
    private @Getter @Setter String nickName;
    private @Getter @Setter String address;
    private @Getter @Setter String email;
    private @Getter @Setter String phoneNumber;
    private @Getter @Setter String idCardNumber;
    private @Getter @Setter String lastEducation;

}
