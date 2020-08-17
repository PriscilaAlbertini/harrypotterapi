package br.com.dextra.harrypotterapi.vo;

import br.com.dextra.harrypotterapi.model.Characters;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Priscila Albertini
 */
public class CharactersResponseDTO {

    private String name;
    private String role;
    private String school;
    private String house;
    private String patronus;

    public CharactersResponseDTO(String name, String role, String school, String house, String patronus) {
        this.name = name;
        this.role = role;
        this.school = school;
        this.house = house;
        this.patronus = patronus;
    }

    public static CharactersResponseDTO toDTO(Characters characters) {
        return new CharactersResponseDTO(characters.getName(), characters.getRole(), characters.getSchool(), characters.getHouse().getId(), characters.getPatronus());
    }
    
    public static Set<CharactersResponseDTO> toDTO(Set<Characters> chararcters){
        Set<CharactersResponseDTO> charactersDTO = new HashSet<>();
        
        for (Characters characterEntity : chararcters) {
            charactersDTO.add(CharactersResponseDTO.toDTO(characterEntity));
        }
        
        return charactersDTO;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public String getPatronus() {
        return patronus;
    }

    public void setPatronus(String patronus) {
        this.patronus = patronus;
    }

}
