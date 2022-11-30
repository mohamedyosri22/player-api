package com.spring.playerapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.playerapi.model.Player;
import com.spring.playerapi.service.PlayerService;

//http://localhost:8080/playerapi


//http://localhost:8080/playerapi/api
@RestController
@RequestMapping("/api")
public class PlayerController {
	// http://localhost:8080/playerapi/api/test
	@GetMapping("/test")
	public String test() {
		return "test success";
	}

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

}
