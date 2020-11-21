package com.springdemo.service;

import com.springdemo.entity.Country;

import java.util.List;

public interface CountryService {

    public List<Country> getCountries();

    public  void saveCountry(Country country);

    public  Country  getCountryById(int id);

    public  void  deleteCountry(int id );

}
