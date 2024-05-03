package com.rolegear.pf2etools.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rolegear.pf2etools.model.Monster;
import com.rolegear.pf2etools.repository.MonsterRepository;

@Service
public class MonsterServiceImpl implements MonsterService {

  private final MonsterRepository monsterRepository;

  @Autowired
  public MonsterServiceImpl(MonsterRepository monsterRepository) {
    this.monsterRepository = monsterRepository;
  }

  @Override
  public Monster saveMonster(Monster monster) {
    return monsterRepository.save(monster);
  }

  @Override
  public void deleteMonster(Long id) {
    monsterRepository.deleteById(id);
  }

  @Override
  public Optional<Monster> findById(Long id) {
    return monsterRepository.findById(id);
  }

  @Override
  public List<Monster> findAllMonsters() {
    return monsterRepository.findAll();
  }

}
