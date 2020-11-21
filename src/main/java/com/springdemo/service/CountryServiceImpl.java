package com.springdemo.service;

import com.springdemo.dao.CountryDao;
import com.springdemo.entity.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {


    @Autowired
    private CountryDao countryDao;
    @Override
    @Transactional
    public List<Country> getCountries() {

        return countryDao.getCountries();
    }


    @Override
    @Transactional
    public void saveCountry(Country country) {
     countryDao.saveCountry(country);
    }

    @Override
    @Transactional
    public Country getCountryById(int id) {

        return countryDao.getCountryById(id);
    }

    @Override
    @Transactional
    public void deleteCountry(int id) {
        countryDao.deleteCountry(id);

    }
}
