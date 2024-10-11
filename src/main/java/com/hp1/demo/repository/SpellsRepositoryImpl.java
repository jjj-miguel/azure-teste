package com.hp1.demo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.hp1.demo.Controller.ApiResponseSpell;
import com.hp1.demo.Controller.SpellsResultDTO;


@Repository
public class SpellsRepositoryImpl implements SpellsRepository {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public SpellsResultDTO findBySpellsName(String spells) {
        String apiUrl = String.format("https://api.potterdb.com/v1/spells/%s", spells);
        ApiResponseSpell response = restTemplate.getForObject(apiUrl, ApiResponseSpell.class);
    
        if (response != null && response.getData() != null) {
            SpellsResultDTO spellsResult = new SpellsResultDTO();
            spellsResult.setName(response.getData().getAttributes().getName());
            spellsResult.setEffect(response.getData().getAttributes().getEffect());
            spellsResult.setCategory(response.getData().getAttributes().getCategory());
            return spellsResult;
        }
    
        return null; 
    }
    
}
