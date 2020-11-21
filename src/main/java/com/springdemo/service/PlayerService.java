package com.springdemo.service;

import com.springdemo.entity.Player;

import java.util.List;

public interface PlayerService {

    public List<Player> getPlayers();


    public Player getPlayerById(int id);

    public void SavePlayer(Player player);

   // public void  UpdatePlayer(Player player);

    public  void  DeletePlayer(int id);


    void updatePlayer(Player player);
}
