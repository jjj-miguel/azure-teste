package com.hp1.demo.Controller;



import com.hp1.demo.entity.SpellsEntity;
import com.hp1.demo.service.SpellsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("consulta-spells")
public class SpellsController {

    @Autowired
    private SpellsService spellsService;

    @GetMapping("{spells}")
    public ResponseEntity<SpellsResultDTO> consultSpells(@PathVariable("spells") String spells) {
        SpellsResultDTO spellsData = spellsService.getSpells(spells);
        if (spellsData == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
        }
        return new ResponseEntity<>(spellsData, HttpStatus.OK);
    }
    

    @PostMapping("/salvar")
    public ResponseEntity<SpellsEntity> saveSpell(@RequestBody SpellsResultDTO spellsResultDTO) {
        SpellsEntity savedSpell = spellsService.saveSpell(spellsResultDTO);
        return new ResponseEntity<>(savedSpell, HttpStatus.CREATED);
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deleteSpell(@PathVariable String id) {
        spellsService.deleteSpell(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<SpellsEntity> updateSpell(@PathVariable String id, @RequestBody SpellsResultDTO spellsResultDTO) {
        SpellsEntity updatedSpell = spellsService.updateSpell(id, spellsResultDTO);
        return new ResponseEntity<>(updatedSpell, HttpStatus.OK);
    }

    @GetMapping("/todos")
    public ResponseEntity<List<SpellsEntity>> getAllSpells() {
        List<SpellsEntity> spells = spellsService.getAllSpells();
        return new ResponseEntity<>(spells, HttpStatus.OK);
    }
}
