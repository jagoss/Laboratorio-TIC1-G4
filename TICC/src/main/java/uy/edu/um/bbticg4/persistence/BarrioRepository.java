package uy.edu.um.bbticg4.persistence;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import uy.edu.um.bbticg4.service.entities.Barrio;

import java.util.List;

@Repository
public interface BarrioRepository extends CrudRepository<Barrio, Integer> {

    Barrio findBarrioByName(String barrio);

    @Query("SELECT b FROM Barrio b ORDER BY b.name")
    List<Barrio> findAllBarrio();
}
