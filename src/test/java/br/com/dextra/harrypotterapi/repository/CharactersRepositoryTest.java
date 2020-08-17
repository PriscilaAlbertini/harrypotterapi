package br.com.dextra.harrypotterapi.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

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
public class CharactersRepositoryTest {
	
	@Autowired
    CharactersRepository repository;
    
	@Test
	public void testFindById() {
		Characters character = new Characters(null, "Harry Potter", "student", "Hogwarts School of Witchcraft and Wizardry", new Houses("5a05e2b252f721a3cf2ea33f"), "stag");
		repository.save(character);
		
		Characters character2 = repository.findById(character.getId()).get();
		assertNotNull(character);
		assertNotNull(character2);
		
		assertEquals(character2.getName(), character.getName());
        assertEquals(character2.getHouse().getId(), character.getHouse().getId());
        assertEquals(character2.getPatronus(), character.getPatronus());
        assertEquals(character2.getRole(), character.getRole());
        assertEquals(character2.getSchool(), character.getSchool());
	}
	
}
