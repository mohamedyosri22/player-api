package com.spring.playerapi.service;

import java.util.List;

import com.spring.playerapi.model.Player;

public interface PlayerService {
	public List<Player> getPlayers();

	public Player getPlayer(int id);

	public Player removePlayer(int id);
	
	public void addPlayer(Player player);
}
