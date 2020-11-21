package com.springdemo.service;

import com.springdemo.entity.Player;
import com.springdemo.entity.Team;
import com.springdemo.entity.Team;
import org.hibernate.Session;

import java.util.List;

public interface TeamService {
    public List<Team> getTeams();

    public  void saveTeam(Team team);

    public  Team  getTeamById(int id);

    public  void  deleteTeam(int id );

    public  void updateTeam(Team team);

    public void addPlayerToTeam(int playerId , int teamId);


//    public  void addPlayerToTeam(Player player);
//
//    public  void  removePlayerFromTeam(Player player);
    
}
