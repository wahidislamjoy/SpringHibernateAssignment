package com.springdemo.dao;

import com.springdemo.entity.Country;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CountryDaoImpl implements CountryDao {

    @Autowired
    SessionFactory sessionFactory;
    @Override
    public List<Country> getCountries() {
        Session currentSession = sessionFactory.getCurrentSession();

        Query<Country> theQuery = currentSession.createQuery("from Country order by name"  );

        List<Country> countries = theQuery.getResultList();


        return countries;
    }

    @Override
    public void saveCountry(Country country) {
        Session currentSession = sessionFactory.getCurrentSession();

        currentSession.saveOrUpdate(country);
    }

    @Override
    public Country getCountryById(int id) {
        Session currentSession = sessionFactory.getCurrentSession();
        Country theCountry = currentSession.get(Country.class,id);

        return theCountry;
    }

    @Override
    public void deleteCountry(int id) {
        Session currentSession = sessionFactory.getCurrentSession();
        Country country=currentSession.get(Country.class,id);

//        Query theQuery = currentSession.createQuery("delete from Country where id=:countryId");
//
//        theQuery.setParameter("countryId",id);

        currentSession.delete(country);

    }
}
