
package com.hp1.demo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.hp1.demo.Controller.ApiResponseCharacter;
import com.hp1.demo.Controller.CharacterResultDTO;


@Repository
public class CharacterRepositoryImpl implements CharacterRepository {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public CharacterResultDTO findByCharacterName(String character) {
        String apiUrl = String.format("https://api.potterdb.com/v1/characters/%s", character);
        ApiResponseCharacter response = restTemplate.getForObject(apiUrl, ApiResponseCharacter.class);
    
        if (response != null && response.getData() != null) {
            CharacterResultDTO characterResult = new CharacterResultDTO();
            characterResult.setName(response.getData().getAttributes().getName());
            characterResult.setHouse(response.getData().getAttributes().getHouse());
            characterResult.setSpecies(response.getData().getAttributes().getSpecies());
            return characterResult;
        }
    
        return null; 
    }
    
}
