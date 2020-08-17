package br.com.dextra.harrypotterapi.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.dextra.harrypotterapi.model.Characters;
import br.com.dextra.harrypotterapi.model.Houses;

/**
 *
 * @author Priscila Albertini
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CharactersServiceTest {
    
	@Autowired
    CharactersService service;
	
    
	@Test
	public void testSave() {
		
		Characters character = new Characters(null, "Harry Potter", "student", "Hogwarts School of Witchcraft and Wizardry", new Houses("5a05e2b252f721a3cf2ea33f"), "stag");
		service.save(character);
		Characters character2 = service.readAll().iterator().next();
		assertNotNull(character);
		assertNotNull(character2);
        assertEquals(character2.getName(), character.getName());
        assertEquals(character2.getHouse().getId(), character.getHouse().getId());
        assertEquals(character2.getPatronus(), character.getPatronus());
        assertEquals(character2.getRole(), character.getRole());
        assertEquals(character2.getSchool(), character.getSchool());
		
	}
	
	
	@Test
	public void testReadById() {
		Characters character = new Characters(null, "Harry Potter", "student", "Hogwarts School of Witchcraft and Wizardry", new Houses("5a05e2b252f721a3cf2ea33f"), "stag");
		service.save(character);
		
		Characters character2 = service.readById(character.getId());
		assertNotNull(character);
		assertNotNull(character2);
		
		assertEquals(character2.getName(), character.getName());
        assertEquals(character2.getHouse().getId(), character.getHouse().getId());
        assertEquals(character2.getPatronus(), character.getPatronus());
        assertEquals(character2.getRole(), character.getRole());
        assertEquals(character2.getSchool(), character.getSchool());
	}
	
	
	@Test
	public void testDelete() {
		Characters character = new Characters(null, "Harry Potter", "student", "Hogwarts School of Witchcraft and Wizardry", new Houses("5a05e2b252f721a3cf2ea33f"), "stag");
		service.save(character);
		assertNotNull(character);
		service.delete(character.getId());
	}
	
	@Test
	public void testReadAll() {
		Characters character = new Characters(null, "Harry Potter", "student", "Hogwarts School of Witchcraft and Wizardry", new Houses("5a05e2b252f721a3cf2ea33f"), "stag");
		service.save(character);
		assertNotNull(character);
		assertNotNull(service.readAll());
	}
	
	@Test
	public void testReadByHouse() {
		Characters character = new Characters(null, "Harry Potter", "student", "Hogwarts School of Witchcraft and Wizardry", new Houses("5a05e2b252f721a3cf2ea33f"), "stag");
		service.save(character);
		assertNotNull(character);
		assertNotNull(service.readByHouse(character.getHouse().getId()));
	}
	
	@Test
	public void testUpdate() {
		Characters character = new Characters(null, "Harry Potter", "student", "Hogwarts School of Witchcraft and Wizardry", new Houses("5a05e2b252f721a3cf2ea33f"), "stag");
		service.save(character);
		Characters character2 = new Characters(character.getId(), "Tom Riddle", "monitor", "Hogwarts School", new Houses("123456789012345678901234"), "snake");
		assertNotNull(character);
		assertNotNull(character2);
		assertNotEquals(character2.getName(), character.getName());
		assertNotEquals(character2.getHouse(), character.getHouse());
		assertNotEquals(character2.getPatronus(), character.getPatronus());
		assertNotEquals(character2.getRole(), character.getRole());
		assertNotEquals(character2.getSchool(), character.getSchool());
	}
	
}
