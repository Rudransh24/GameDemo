package com.example.gamedemo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Table(name = "game_table")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Game implements Serializable {
  private static final long serialVersionUID = -645894567897L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @NotBlank
  @Size(max = 150)
  @Column(name = "name")
  private String name;

  @NotBlank
  @Size(max = 200)
  @Column(name = "url")
  private String url;

  @NotBlank
  @Size(max = 150)
  @Column(name = "author")
  private String author;

  @NotBlank
  @Size(max = 50)
  @Column(name = "publish_date")
  private String publishDate;
}
