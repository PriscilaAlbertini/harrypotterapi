package br.com.dextra.harrypotterapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Priscila Albertini
 */
@Entity
@Table(name = "characters", schema = "public")
public class Characters {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String role;
    @Column(nullable = false)
    private String school;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_house", nullable = false)
    private Houses house;
    @Column(nullable = false)
    private String patronus;

    public Characters() {
    }
    
    public Characters(Long id, String name, String role, String school, Houses house, String patronus) {
        this.id = id;
        this.name = name;
        this.role = role;
        this.school = school;
        this.house = house;
        this.patronus = patronus;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Houses getHouse() {
        return house;
    }

    public void setHouse(Houses house) {
        this.house = house;
    }

    public String getPatronus() {
        return patronus;
    }

    public void setPatronus(String patronus) {
        this.patronus = patronus;
    }

}
