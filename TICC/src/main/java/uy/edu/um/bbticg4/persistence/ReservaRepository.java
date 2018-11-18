package uy.edu.um.bbticg4.persistence;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import uy.edu.um.bbticg4.service.entities.Mesa;
import uy.edu.um.bbticg4.service.entities.Reserva;
import uy.edu.um.bbticg4.service.entities.Restaurant;

import java.util.List;

@Repository
public interface ReservaRepository extends CrudRepository<Reserva, Integer> {

    @EntityGraph(value = "reserva.detail", type = EntityGraph.EntityGraphType.LOAD)
    @Query("SELECT r FROM Reserva r WHERE r.resto.id = idResto")
    List<Reserva> obtenerReservasdeResto(Integer idResto);
}
