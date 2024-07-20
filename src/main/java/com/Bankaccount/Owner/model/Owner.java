package com.Bankaccount.Owner.model;

import com.Bankaccount.Account.Model.Account;
import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "owner")
public class Owner {

    @Id
    @Column(name="id_owner")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idOwner;

    @Column(name="firstname", nullable=false, length=50)
    private String firstname;

    @Column(name="surname", nullable=false, length=50)
    private String surname;

    @Column(name="telephone", nullable=false, length=50, unique = true)
    private String telephone;

    @Column(name="email", nullable=false, length=50, unique = true)
    private String email;

    @Column(nullable=false)
    private String password;

    @Column(nullable=false, length=20, unique=true)
    private String DNI;

    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateofbirthday;

    @OneToMany(mappedBy= "owner", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Account> accounts = new ArrayList<>();

   // @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    //private List<Account> accounts;

    // Getters and Setters

    public Long getIdOwner() {
        return idOwner;
    }

    public void setIdOwner(Long idOwner) {
        this.idOwner = idOwner;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public LocalDate getDateofbirthday() {
        return dateofbirthday;
    }

    public void setDateofbirthday(LocalDate dateofbirthday) {
        this.dateofbirthday = dateofbirthday;
    }




}

