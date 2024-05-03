package com.rolegear.pf2etools.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rolegear.pf2etools.model.Monster;

@Repository
public interface MonsterRepository extends JpaRepository<Monster, Long> {
  // Additional custom methods can be defined here if needed
}
