package com.rolegear.pf2etools.service;

import java.util.List;
import java.util.Optional;

import com.rolegear.pf2etools.model.Monster;

public interface MonsterService {
  Monster saveMonster(Monster monster);

  void deleteMonster(Long id);

  Optional<Monster> findById(Long id);

  List<Monster> findAllMonsters();
}
