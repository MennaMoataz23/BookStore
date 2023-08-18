//package com.example.bookStore.model.entities;
//
//import lombok.*;
//
//import javax.persistence.*;
//import java.util.ArrayList;
//import java.util.Collection;
//
//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
//@Entity
//@Table
//public class User {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long id;
//
//    @Column(name = "userName", nullable = false)
//    private String userName;
//
//    @Column(name = "email", nullable = false)
//    private String email;
//
//    @Column(name = "password", nullable = false)
//    private String password;
//
//    @ManyToMany(fetch = FetchType.EAGER)
//    private Collection<Role> roles = new ArrayList<>();
//}
