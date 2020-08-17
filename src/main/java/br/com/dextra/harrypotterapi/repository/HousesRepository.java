package br.com.dextra.harrypotterapi.repository;

import br.com.dextra.harrypotterapi.model.Houses;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Priscila Albertini
 */
@Repository
public interface HousesRepository extends CrudRepository<Houses, String>{
    
}
