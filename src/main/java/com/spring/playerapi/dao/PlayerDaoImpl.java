package com.spring.playerapi.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.playerapi.model.Player;

@Repository
public class PlayerDaoImpl implements PlayerDao {

	private SessionFactory sessionFactory;

	@Autowired
	public PlayerDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	@Transactional
	public List<Player> getPlayers() {
		Session session = sessionFactory.getCurrentSession();
		Query<Player> q = session.createQuery("from Player", Player.class);
		return q.getResultList();
	}

	@Override
	@Transactional
	public Player getPlayer(int id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(Player.class, id);
	}

	@SuppressWarnings("deprecation")
	@Override
	@Transactional
	public Player removePlayer(int id) {
		Session session = sessionFactory.getCurrentSession();

		Player player = getPlayer(id);
		// session.delete(player);

		Query q = session.createQuery("delete from Player where id= :v1");
		q.setInteger("v1", id);

		q.executeUpdate();
		return player;
	}

	@Override
	public void addPlayer(Player player) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(player);
	}

}
