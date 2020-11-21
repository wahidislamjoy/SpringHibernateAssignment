package com.springdemo.dao;

import com.springdemo.entity.Country;
import com.springdemo.entity.Player;
import com.springdemo.entity.Team;
import com.springdemo.service.CountryService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

import java.util.List;

@Repository
public class TeamDAoImpl implements TeamDao{

    @Autowired
    SessionFactory sessionFactory;
    @Autowired
    CountryService countryService;

    @Override
    public List<Team> getTeams() {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Team> query = currentSession.createQuery("from Team order by name",Team.class);
        List<Team> teams = query.getResultList();
        return teams;

    }



    @Override
    public void saveTeam(Team team) {
        Session currentSession = sessionFactory.getCurrentSession();
        Country country = countryService.getCountryById(team.getCountry().getId());
        team.setCountry(country);
         country.setTeam(team);
        countryService.saveCountry(country);
        currentSession.saveOrUpdate(team);


    }

    @Override
    public Team getTeamById(int id) {
        Session currentSession = sessionFactory.getCurrentSession();

        Team team = currentSession.get(Team.class,id);

        return team ;
    }

    @Override
    public void deleteTeam(int id) {
        Session currentSession = sessionFactory.getCurrentSession();
       Team team= currentSession.get(Team.class,id);

        currentSession.delete(team);

    }


    @Override
    public void updateTeam(Team team) {
        Session currentSession = sessionFactory.getCurrentSession();
        Country country = currentSession.get(Country.class,team.getCountry().getId());

        team.setCountry(country);
        country.setTeam(team);

        currentSession.merge(team);






    }

    @Override
    public void addPlayer(int playerId, int teamId) {
        Session session = sessionFactory.getCurrentSession();

        Player player = session.get(Player.class,playerId);

        Team team = session.get(Team.class,teamId);

        player.setTeam(team);
        team.addPlayer(player);

        session.merge(player);
        session.merge(team);
    }


}
