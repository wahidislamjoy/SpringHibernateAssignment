package com.springdemo.dao;

import com.springdemo.entity.Country;
import com.springdemo.entity.Player;
import com.springdemo.entity.Team;
import com.springdemo.service.TeamService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PlayerDaoImpl implements PlayerDao{
    @Autowired
    SessionFactory sessionFactory;
    @Autowired
    TeamService teamService;
    @Override
    public List<Player> getPlayers() {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Player> query = currentSession.createQuery("from Player ",Player.class);

        List<Player> players = query.getResultList();


        return players;
    }

    @Override
    public Player getPlayerById(int id) {
        Session currentSession = sessionFactory.getCurrentSession();
        Player player = currentSession.get(Player.class,id);

        return player;
    }

    @Override
    public void SavePlayer(Player player) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(player);


    }

//    @Override
//    public void UpdatePlayer(Player player ) {
//        Session currentSession = sessionFactory.getCurrentSession();
//
//        currentSession.merge(player);
//
//
//    }

    @Override
    public void DeletePlayer(int id) {
        Session currentSession = sessionFactory.getCurrentSession();

        Player player = currentSession.get(Player.class,id);


        currentSession.delete(player);

    }

    @Override
    public void updatePlayer(Player player) {
        Session session = sessionFactory.getCurrentSession();
           Team team = teamService.getTeamById(player.getTeam().getId());
           Player player1 = session.get(Player.class , player.getId());
           player1.setTeam(team);
           player1.setRole(player.getRole());
           player1.setFirstName(player.getFirstName());
           player1.setLastName(player.getLastName());
           player1.setAge(player.getAge());
           player1.setDateOfBirth(player.getDateOfBirth());
           session.update(player1);

    }


}
