package br.com.dextra.harrypotterapi.vo;

import br.com.dextra.harrypotterapi.model.Characters;
import br.com.dextra.harrypotterapi.model.Houses;
import javax.validation.constraints.NotBlank;

/**
 *
 * @author Priscila Albertini
 */
public class CharactersDTO {
    
    @NotBlank(message = "{name.not.blank}")
    private String name;
    @NotBlank(message = "{role.not.blank}")
    private String role;
    @NotBlank(message = "{school.not.blank}")
    private String school;
    @NotBlank(message = "{house.not.blank}")
    private String house;
    @NotBlank(message = "{patronus.not.blank}")
    private String patronus;
    
    public Characters toEntity(){
        return new Characters(null, name, role, school, new Houses(house), patronus);
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
