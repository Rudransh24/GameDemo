package com.example.gamedemo.service;

import com.example.gamedemo.dto.GameDto;
import com.example.gamedemo.entity.Game;

import java.util.List;

public interface GameService {
  Game getGameByName(String name);

  List<Game> getAllGames();

  String deleteGameByName(String name);

  String saveGame(GameDto game);

  String updateGame(String name, GameDto game) throws Exception;
}
