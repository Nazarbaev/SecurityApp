package com.example.SecurityApp.models;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "person")
public class Person {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private int id;

    @NotEmpty(message = "Username should not be empty")
    @Size(min = 2,max = 100,message = "Size range should be between 2 and 100")
    @Column(name = "username")
    private String username;

    @Column(name = "year")
    @Min(value = 1900, message = "Year should be higher than 2000")

    private int year;
    @Column(name = "role")
    private String role;

    @NotEmpty(message = "Password should not be empty ")
    @Column(name = "password")
    private String password;

    public Person(String username, int year) {
        this.username = username;
        this.year = year;

    }
    public Person(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", year=" + year +
                ", password='" + password + '\'' +
                '}';
    }
}
