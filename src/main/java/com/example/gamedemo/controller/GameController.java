package com.example.gamedemo.controller;

import com.example.gamedemo.dto.GameDto;
import com.example.gamedemo.exception.NotFoundException;
import com.example.gamedemo.service.GameService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/game")
@Api(tags = {"Game Controller"})
public class GameController {
  private final GameService gameService;

  @GetMapping("/fetch/{game}")
  @ApiOperation(value = "Get Game by Name")
  public ResponseEntity getGameByName(@PathVariable String game) {
    return ResponseEntity.ok().body(gameService.getGameByName(game));
  }

  @GetMapping("/fetchAll")
  @ApiOperation(value = "Fetch All Games")
  public ResponseEntity getAllGames() {
    return ResponseEntity.ok().body(gameService.getAllGames());
  }

  @DeleteMapping("/delete/{game}")
  @ApiOperation(value = "Delete Game by Name")
  public ResponseEntity deleteGameByName(@PathVariable String game) {
    return ResponseEntity.ok().body(gameService.deleteGameByName(game));
  }

  @PostMapping("/create")
  @ApiOperation(value = "Save New Game")
  public ResponseEntity saveGame(@RequestBody GameDto game) {
    return ResponseEntity.ok().body(gameService.saveGame(game));
  }

  @PutMapping("/update/{game}")
  @ApiOperation(value = "Update Game")
  public ResponseEntity updateGame(@PathVariable String game, @RequestBody GameDto gameDto)
      throws Exception {
    try {
      return ResponseEntity.ok().body(gameService.updateGame(game, gameDto));
    } catch (NotFoundException e) {
      return ResponseEntity.ok().body("Game not found!");
    }
  }
}
