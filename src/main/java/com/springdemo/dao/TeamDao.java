package com.springdemo.dao;


import com.springdemo.entity.Player;
import com.springdemo.entity.Team;

import java.util.List;

public interface TeamDao {

    public List<Team> getTeams();


    public  void saveTeam(Team team);

    public  Team  getTeamById(int id);

    public  void  deleteTeam(int id );

    public void updateTeam(Team team);
    void addPlayer(int playerId, int teamId);
}
