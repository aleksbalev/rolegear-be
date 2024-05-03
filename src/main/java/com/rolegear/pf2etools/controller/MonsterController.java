package com.rolegear.pf2etools.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.rolegear.pf2etools.model.Monster;
import com.rolegear.pf2etools.service.MonsterService;

@RestController
@RequestMapping("/api/v1/monsters")
public class MonsterController {
  private final MonsterService monsterService;

  @Autowired
  public MonsterController(MonsterService monsterService) {
    this.monsterService = monsterService;
  }

  @GetMapping
  public List<Monster> getAllMonsters() {
    return monsterService.findAllMonsters();
  }

  @GetMapping("/{id}")
  public ResponseEntity<Monster> getMonsterById(@PathVariable Long id) {
    Optional<Monster> monster = monsterService.findById(id);

    return monster.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
  }

  @PostMapping
  public Monster createMonster(@RequestBody Monster monster) {
    return monsterService.saveMonster(monster);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteMonster(@PathVariable Long id) {
    monsterService.deleteMonster(id);

    return ResponseEntity.ok().build();
  }
}
