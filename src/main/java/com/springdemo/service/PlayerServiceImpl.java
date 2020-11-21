package com.springdemo.service;

import com.springdemo.dao.PlayerDao;
import com.springdemo.entity.Player;
import com.springdemo.entity.Team;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public class PlayerServiceImpl implements  PlayerService {
    @Autowired
    PlayerDao playerDao;
    @Autowired
    TeamService teamService;
    @Override
    @Transactional
    public List<Player> getPlayers() {

        List<Player> players = playerDao.getPlayers();
        return players;
    }

    @Override
    @Transactional
    public Player getPlayerById(int id) {

        Player player = playerDao.getPlayerById(id);
        return player;
    }

    @Override
    @Transactional
    public void SavePlayer(Player player) {

        playerDao.SavePlayer(player);

    }

//    @Override
//    @Transactional
//    public void UpdatePlayer(Player player ) {
//
//        playerDao.UpdatePlayer(player);
//    }

    @Override
    @Transactional
    public void DeletePlayer(int id) {

        playerDao.DeletePlayer(id);

    }

    @Override
    @Transactional
    public void updatePlayer(Player player) {
        Team team = teamService.getTeamById(player.getTeam().getId());

        playerDao.updatePlayer(player);

    }


}
