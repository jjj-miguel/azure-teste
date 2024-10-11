package com.hp1.demo.repository;

import com.hp1.demo.Controller.CharacterResultDTO;

public interface CharacterRepository {
    CharacterResultDTO findByCharacterName(String character);
}
    