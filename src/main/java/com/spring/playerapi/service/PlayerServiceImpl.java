package com.spring.playerapi.service;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.playerapi.dao.PlayerDao;
import com.spring.playerapi.model.Player;

@Service
public class PlayerServiceImpl implements PlayerService {
	
	private PlayerDao playerDao;
	
	@Autowired
	public PlayerServiceImpl(PlayerDao playerDao) {
		this.playerDao = playerDao;
	}

	@Override
	@Transactional
	public List<Player> getPlayers() {
		// TODO Auto-generated method stub
		return playerDao.getPlayers();
	}

	@Override
	@Transactional
	public Player getPlayer(int id) {
		// TODO Auto-generated method stub
		return playerDao.getPlayer(id);
	}

	@Override
	@Transactional
	public Player removePlayer(int id) {
		// TODO Auto-generated method stub
		return playerDao.removePlayer(id);
	}

	@Override
	@Transactional
	public void addPlayer(Player player) {
		// TODO Auto-generated method stub
		playerDao.addPlayer(player);
	}

}
