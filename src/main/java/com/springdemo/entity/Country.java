package com.springdemo.entity;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.NotFound;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "country")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    @NotNull(message="is required")
    @Size(min=1, message="is required")
    String name;

    @Column(name = "country_code")
    @NotNull(message="is required")
    @Size(min=1, message="is required")
    private String countryCode;

    @OneToOne(mappedBy = "country",cascade = CascadeType.ALL)
    private Team team ;




    public Country() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
