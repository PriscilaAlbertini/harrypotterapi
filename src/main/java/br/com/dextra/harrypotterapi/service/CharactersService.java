package br.com.dextra.harrypotterapi.service;

import br.com.dextra.harrypotterapi.model.Characters;
import br.com.dextra.harrypotterapi.model.Houses;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.dextra.harrypotterapi.repository.CharactersRepository;
import br.com.dextra.harrypotterapi.repository.HousesRepository;
import java.util.Optional;

/**
 *
 * @author Priscila Albertini
 */
@Service
public class CharactersService {

    @Autowired
    private CharactersRepository characteresRepository;
    @Autowired
    private HousesRepository housesRepository;

    public Object save(Characters character) {
        
        Optional<Houses> house = housesRepository.findById(character.getHouse().getId());
        if (!house.isPresent()) {
            return "House not found";
        }
        
        return characteresRepository.save(character);
    }

    public Characters readById(Long id) {
        return characteresRepository.findById(id).get();
    }

    public Set<Characters> readAll() {
        return characteresRepository.findAll();
    }
    
    public Set<Characters> readByHouse(String id) {
        return housesRepository.findById(id).get().getCharacters();
    }

    public boolean delete(Long id) {

        if (!characteresRepository.findById(id).isPresent()) {
            return false;
        }

        characteresRepository.deleteById(id);

        return true;
    }

    public Characters update(Long id, Characters charUpdate) {
        
        Optional<Characters> characterOPT = characteresRepository.findById(id);
        
        if (!characterOPT.isPresent()) {
            return null;
        }
        
        return characteresRepository.save(new Characters(characterOPT.get().getId(), charUpdate.getName(), charUpdate.getRole(), charUpdate.getSchool(), charUpdate.getHouse(), charUpdate.getPatronus()));
    }

}
