package com.hp1.demo.repository;

import com.hp1.demo.Controller.SpellsResultDTO;

public interface SpellsRepository {
    SpellsResultDTO findBySpellsName(String spells);
}
