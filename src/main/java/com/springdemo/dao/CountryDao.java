package com.springdemo.dao;

import com.springdemo.entity.Country;

import java.util.List;

public interface CountryDao {

    public List<Country> getCountries();

    public  void saveCountry(Country country);

    public  Country  getCountryById(int id);

    public  void  deleteCountry(int id );
}
