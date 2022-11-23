package com.enigmacamp.livecode3.entity;

import jakarta.persistence.*;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private @Getter
    @Setter Integer id;

    @Column(name = "first_name")
    private @Getter
    @Setter String firstName;

    @Column(name = "last_name")
    private @Getter
    @Setter String lastName;

    @Column(name = "nick_name")
    private @Getter
    @Setter String nickName;

    private @Getter
    @Setter String address;

    private @Getter
    @Setter String email;

    @Column(name = "phone_number")
    private @Getter
    @Setter String phoneNumber;

    @Column(name = "id_card_number")
    private @Getter
    @Setter String idCardNumber;

    @Column(name = "last_education")
    private @Getter
    @Setter String lastEducation;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "user_credential_id")
    private @Getter
    @Setter UserCredential userCredential;

}
