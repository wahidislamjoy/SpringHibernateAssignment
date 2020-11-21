package com.springdemo.entity;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "player")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name = "first_name")
    @NotNull(message="is required")
    @Size(min=1, message="is required")
    private String firstName;

    @Column(name = "last_name")
    @NotNull(message="is required")
    @Size(min=1, message="is required")
    private String lastName;

    @Column(name = "date_of_birth")
    @NotNull(message="is required")
    @Size(min=1, message="is required")
    String dateOfBirth;

    @Column(name = "age")
    @NotNull(message = "is required")
    @Min(value = 14 , message = "the value must be greater than 14")
    @Max(value = 65 , message = "the value must be grater than 65")
    int age;
    @Column(name = "role")
    @NotNull(message="is required")
    @Size(min=1, message="is required")
    String role;

    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "team_id")
    Team team;



    public Player() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
