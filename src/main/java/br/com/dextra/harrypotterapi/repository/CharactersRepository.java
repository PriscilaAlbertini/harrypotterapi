package br.com.dextra.harrypotterapi.repository;

import br.com.dextra.harrypotterapi.model.Characters;
import java.util.Set;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Priscila Albertini
 */
@Repository
public interface CharactersRepository extends CrudRepository<Characters, Long>{
    Set<Characters> findAll();
}
