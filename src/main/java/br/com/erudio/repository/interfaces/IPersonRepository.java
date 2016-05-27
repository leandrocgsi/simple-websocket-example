package br.com.erudio.repository.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.com.erudio.models.Person;

public interface IPersonRepository extends CrudRepository<Person, Long> {
	
    @Query("SELECT p FROM Person p WHERE LOWER(p.firstName) = LOWER(:firstName)")
    public List<Person> findByName(@Param("firstName") String firstName);
    
    @Query(value = "SELECT * FROM person p where p.firstName like :firstName or p.lastName like :firstName", nativeQuery=true)
    public List<Person> findByNameLike(@Param("firstName") String firstName);

}
