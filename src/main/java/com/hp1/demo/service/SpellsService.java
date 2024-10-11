package com.hp1.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hp1.demo.Controller.SpellsResultDTO;
import com.hp1.demo.entity.SpellsEntity;
import com.hp1.demo.repository.SpellJpaRepository;
import com.hp1.demo.repository.SpellsRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SpellsService {

    @Autowired
    private SpellJpaRepository spellJpaRepository;

    @Autowired
    private SpellsRepository spellsRepository;

    public SpellsEntity saveSpell(SpellsResultDTO spellsResultDTO) {
        SpellsEntity spellEntity = new SpellsEntity();
        spellEntity.setName(spellsResultDTO.getName());
        spellEntity.setType(spellsResultDTO.getType());
        spellEntity.setEffect(spellsResultDTO.getEffect());
        spellEntity.setCategory(spellsResultDTO.getCategory());
        return spellJpaRepository.save(spellEntity);
    }

    public void deleteSpell(String id) {
        spellJpaRepository.deleteById(Long.valueOf(id)); 
    }

    public SpellsEntity updateSpell(String id, SpellsResultDTO spellsResultDTO) {
        Optional<SpellsEntity> existingSpell = spellJpaRepository.findById(Long.valueOf(id)); 
        if (existingSpell.isPresent()) {
            SpellsEntity spellEntity = existingSpell.get();
            spellEntity.setName(spellsResultDTO.getName());
            spellEntity.setType(spellsResultDTO.getType());
            spellEntity.setEffect(spellsResultDTO.getEffect());
            spellEntity.setCategory(spellsResultDTO.getCategory());

            return spellJpaRepository.save(spellEntity); 
        }
        throw new RuntimeException("Spell not found");
    }

    public List<SpellsEntity> getAllSpells() {
        return spellJpaRepository.findAll();
    }

    public SpellsResultDTO getSpells(String spells) {
        SpellsResultDTO spellsData = spellsRepository.findBySpellsName(spells);

        if (spellsData != null) {
            SpellsEntity spellEntity = new SpellsEntity();
            spellEntity.setName(spellsData.getName());
            spellEntity.setType(spellsData.getType());
            spellEntity.setEffect(spellsData.getEffect());
            spellEntity.setCategory(spellsData.getCategory());

            spellJpaRepository.save(spellEntity);
        } else {
            System.out.println("No spells data found for: " + spells);
        }

        return spellsData;
    }
}
