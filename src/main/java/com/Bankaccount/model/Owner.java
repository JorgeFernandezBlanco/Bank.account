/*package com.Bankaccount.model;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="firstname", nullable=false, length=50)
    private String firstname;

    @Column (name="surname", nullable=false, length=50)
    private String surname;

    @Column (name="telephone", nullable=false, length=50, unique = true)
    private String telephone;

    @Column (name="email", nullable=false, length=50, unique = true)
    private String email;

    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateofbirthday;

}
*/