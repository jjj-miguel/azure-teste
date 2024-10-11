package com.hp1.demo.Controller;



import com.hp1.demo.entity.CharacterEntity;
import com.hp1.demo.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("consulta-characters")
public class CharacterController {

    @Autowired
    private CharacterService characterService;

    @GetMapping("{character}")
    public ResponseEntity<CharacterResultDTO> consultCharacter(@PathVariable("character") String character) {
        CharacterResultDTO characterData = characterService.getCharacter(character);
        if (characterData == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
        }
        return new ResponseEntity<>(characterData, HttpStatus.OK);
    }

    @PostMapping("/salvar")
    public ResponseEntity<CharacterEntity> saveCharacter(@RequestBody CharacterResultDTO characterResultDTO) {
        CharacterEntity characterEntity = characterService.saveCharacter(characterResultDTO);
        return new ResponseEntity<>(characterEntity, HttpStatus.CREATED);
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deleteCharacter(@PathVariable String id) {
        characterService.deleteCharacter(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<CharacterEntity> updateCharacter(@PathVariable String id, @RequestBody CharacterResultDTO characterResultDTO) {
        CharacterEntity updatedCharacter = characterService.updateCharacter(id, characterResultDTO);
        return new ResponseEntity<>(updatedCharacter, HttpStatus.OK);
    }

    @GetMapping("/todos")
    public ResponseEntity<List<CharacterEntity>> getAllCharacter() {
        List<CharacterEntity> characters = characterService.getAllCharacter();
        return new ResponseEntity<>(characters, HttpStatus.OK);
    }
}
