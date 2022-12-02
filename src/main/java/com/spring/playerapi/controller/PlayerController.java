package com.spring.playerapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.playerapi.model.Player;
import com.spring.playerapi.service.PlayerService;

//http://localhost:8080/playerapi


//http://localhost:8080/playerapi/api
@RestController
@RequestMapping("/api")
public class PlayerController {

	private PlayerService playerService;

	@Autowired
	public PlayerController(PlayerService playerService) {
		this.playerService = playerService;
	}

	// http://localhost:8080/playerapi/api/players
	@GetMapping("/players")
	public List<Player> getPlayers() {
		return playerService.getPlayers();
	}
	
	// http://localhost:8080/playerapi/api/player?id=2
	@GetMapping("/player")
	public Player getPlayerById(@RequestParam int id) {
		return playerService.getPlayer(id);
	}
	
		
	/*
	// http://localhost:8080/playerapi/api/players/2
	@GetMapping("/players/{id}")
	public Player getPlayerById(@PathVariable("id") int id) {
		return playerService.getPlayer(id);
	}
	*/
	
	
	// http://localhost:8080/playerapi/api/test
	@GetMapping("/test")
	public String test() {
		return "test success";
	}

}
