package com.example.gamedemo.service.GameServiceImpl;

import com.example.gamedemo.dto.GameDto;
import com.example.gamedemo.entity.Game;
import com.example.gamedemo.exception.NotFoundException;
import com.example.gamedemo.repository.GameRepository;
import com.example.gamedemo.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameServiceImpl implements GameService {
  @Autowired private GameRepository gameRepository;

  @Override
  public Game getGameByName(String game) {
    return gameRepository.findGameByName(game);
  }

  @Override
  public List<Game> getAllGames() {
    return gameRepository.findAll();
  }

  @Override
  @Transactional
  public String deleteGameByName(String name) {
    gameRepository.removeGameByName(name);
    return "Game deleted successfully";
  }

  @Override
  public String saveGame(GameDto game) {
    Game gameEntity =
        Game.builder()
            .name(game.getName())
            .url(game.getUrl())
            .author(game.getAuthor())
            .publishDate(game.getPublishDate())
            .build();
    gameRepository.save(gameEntity);
    return "Game added successfully";
  }

  @Override
  @Transactional
  public String updateGame(String name, GameDto game) throws Exception {
    try {
      Game currentGame = gameRepository.findGameByName(name);
      currentGame.setName(game.getName());
      currentGame.setAuthor(game.getAuthor());
      currentGame.setUrl(game.getUrl());
      currentGame.setPublishDate(game.getPublishDate());
      gameRepository.updateGameDetails(
          currentGame.getName(),
          currentGame.getUrl(),
          currentGame.getAuthor(),
          currentGame.getPublishDate());
    } catch (Exception e) {
      throw NotFoundException.builder().message("Game " + game + " not found!").build();
    }
    return "Game details updated successfully";
  }
}
