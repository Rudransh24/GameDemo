package com.example.gamedemo.repository;

import com.example.gamedemo.entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {
  Game findGameByName(String name);

  void removeGameByName(String name);

  @Query(
      value =
          "UPDATE game_table SET name=:name, url=:url, author=:author, publish_date=:publishDate WHERE "
              + "name=:name",
      nativeQuery = true)
  @Modifying
  void updateGameDetails(
      @Param("name") String name,
      @Param("url") String url,
      @Param("author") String author,
      @Param("publishDate") String publishDate);
}
