package com.spring.playerapi.dao;

import java.util.List;

import com.spring.playerapi.model.Player;

public interface PlayerDao {
	public List<Player> getPlayers();

	public Player getPlayer(int id);

	public Player removePlayer(int id);

	public void addPlayer(Player player);
}
