package br.com.dextra.harrypotterapi.controller;

import br.com.dextra.harrypotterapi.model.Characters;
import br.com.dextra.harrypotterapi.service.CharactersService;
import br.com.dextra.harrypotterapi.vo.CharactersResponseDTO;
import br.com.dextra.harrypotterapi.vo.CharactersDTO;
import java.util.Optional;
import java.util.Set;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Priscila Albertini
 */
@RequestMapping("/characters")
@RestController
public class CharactersController {

    @Autowired
    private CharactersService service;

    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> save(@RequestBody @Valid CharactersDTO characterDTO) {

        Object character = service.save(characterDTO.toEntity());
        
        if (character instanceof String) {
            return new ResponseEntity<>(character, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>("Success", HttpStatus.CREATED);

    }

    @GetMapping("/{key}")
    public ResponseEntity readById(@PathVariable("key") Long id) {
        Characters character = service.readById(id);

        if (character == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(CharactersResponseDTO.toDTO(character));
        }
    }

    @GetMapping("/")
    public ResponseEntity readById() {
        Set<CharactersResponseDTO> characters = CharactersResponseDTO.toDTO(service.readAll());

        if (characters == null || characters.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(characters);
        }
    }

    @GetMapping("/house/{house}")
    public ResponseEntity readByHouse(@PathVariable("house") String id) {
        Set<CharactersResponseDTO> characters = CharactersResponseDTO.toDTO(service.readByHouse(id));

        if (characters == null || characters.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(characters);
        }
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<Long> delete(@PathVariable("id") Long id) {

        if (!service.delete(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @PutMapping(value = "/update/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CharactersResponseDTO> update(@PathVariable("id") Long id, @RequestBody @Valid CharactersDTO characterDTO) {

        Characters character = service.update(id, characterDTO.toEntity());
        
        if (character == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(CharactersResponseDTO.toDTO(character));
        }
    }

}
