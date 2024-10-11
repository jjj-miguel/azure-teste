package com.hp1.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hp1.demo.Controller.CharacterResultDTO;
import com.hp1.demo.entity.CharacterEntity;
import com.hp1.demo.repository.CharacterJpaRepository;
import com.hp1.demo.repository.CharacterRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CharacterService {

    @Autowired
    private CharacterJpaRepository characterJpaRepository;

    @Autowired
    private CharacterRepository characterRepository;

    public CharacterEntity saveCharacter(CharacterResultDTO characterResultDTO) {
        CharacterEntity characterEntity = new CharacterEntity();
        characterEntity.setName(characterResultDTO.getName());
        characterEntity.setHouse(characterResultDTO.getHouse());
        characterEntity.setSpecies(characterResultDTO.getSpecies());
        return characterJpaRepository.save(characterEntity);
    }

    public void deleteCharacter(String id) {
        characterJpaRepository.deleteById(Long.valueOf(id)); 
    }

    public CharacterEntity updateCharacter(String id, CharacterResultDTO characterResultDTO) {
        Optional<CharacterEntity> existingCharacter = characterJpaRepository.findById(Long.valueOf(id)); 
        if (existingCharacter.isPresent()) {
            CharacterEntity characterEntity = existingCharacter.get();
            characterEntity.setName(characterResultDTO.getName());
            characterEntity.setHouse(characterResultDTO.getHouse());
            characterEntity.setSpecies(characterResultDTO.getSpecies());

            return characterJpaRepository.save(characterEntity); 
        }
        throw new RuntimeException("Character not found");
    }

    public List<CharacterEntity> getAllCharacter() {
        return characterJpaRepository.findAll();
    }

    public CharacterResultDTO getCharacter(String character) {
        CharacterResultDTO characterData = characterRepository.findByCharacterName(character);

        if (characterData != null) {
            CharacterEntity characterEntity = new CharacterEntity();
            characterEntity.setName(characterData.getName());
            characterEntity.setHouse(characterData.getHouse());
            characterEntity.setSpecies(characterData.getSpecies());

            characterJpaRepository.save(characterEntity);
        } else {
            System.out.println("No character data found for: " + character);
        }

        return characterData;
    }
}
