package com.rolegear.pf2etools;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rolegear.pf2etools.model.Monster;
import com.rolegear.pf2etools.service.MonsterService;

import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class MonsterControllerIntegrationTest {

  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private MonsterService monsterService;

  @Autowired
  private ObjectMapper objectMapper;

  private Monster monster;

  @BeforeEach
  public void setup() {
    // Initialize a monster to use in tests
    monster = new Monster("Goblin", "Creature", 15, 12);
    monsterService.saveMonster(monster);
  }

  @Test
  public void testGetAllMonsters() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/monsters"))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.jsonPath("$").isArray())
        .andExpect(MockMvcResultMatchers.jsonPath("$[0].name").value(monster.getName()));
  }

  @Test
  public void testGetMonsterById() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/monsters/" + monster.getId()))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.jsonPath("$.name").value(monster.getName()));
  }

  @Test
  public void testCreateMonster() throws Exception {
    Monster newMonster = new Monster("Ogre", "Creature", 40, 15);
    mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/monsters")
        .contentType(MediaType.APPLICATION_JSON)
        .content(objectMapper.writeValueAsString(newMonster)))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Ogre"));
  }

  @Test
  public void testDeleteMonster() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.delete("/api/v1/monsters/" + monster.getId()))
        .andExpect(MockMvcResultMatchers.status().isOk());
  }
}
