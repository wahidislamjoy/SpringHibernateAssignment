package com.springdemo.service;


import com.springdemo.dao.TeamDao;
import com.springdemo.entity.Player;
import com.springdemo.entity.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class TeamServiceImpl implements  TeamService{

    @Autowired
    TeamDao teamDao;
    @Autowired
    CountryService countryService;

    @Override
    @Transactional
    public List<Team> getTeams() {
        return teamDao.getTeams();
    }

    @Override
    @Transactional
    public void saveTeam(Team team) {
         teamDao.saveTeam(team);
    }

    @Override
    @Transactional
    public Team getTeamById(int id) {
        return teamDao.getTeamById(id);
    }

    @Override
    @Transactional
    public void deleteTeam(int id) {
       teamDao.deleteTeam(id);
    }

    @Override
    @Transactional
    public void updateTeam(Team team) {
        teamDao.updateTeam(team);
    }

    @Override
    @Transactional
    public void addPlayerToTeam(int playerId, int teamId) {
        teamDao.addPlayer(playerId,teamId);
    }


//    @Override
//    @Transactional
//    public void addPlayerToTeam(Player player) {
//        Team team =teamDao.getTeamById(player.getTeam().getId());
//        team.addPlayer(player);
//        updateTeam(team);
//
//    }
//
//    @Override
//    public void removePlayerFromTeam(Player player) {
//               Team team = teamDao.getTeamById(player.getTeam().getId());
//
//    }

}
