package br.com.dextra.harrypotterapi.model;

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Priscila Albertini
 */
@Entity
@Table(name = "houses", schema = "public")
public class Houses {

    @Id
    @Column(name = "id_house")
    private String id;
    @Column(nullable = false)
    private String name;
    @OneToMany()
    @JoinColumn(name = "id_house")
    private Set<Characters> characters;

    public Houses() {
    }

    public Houses(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Characters> getCharacters() {
        return characters;
    }

    public void setCharacters(Set<Characters> characters) {
        this.characters = characters;
    }

}
