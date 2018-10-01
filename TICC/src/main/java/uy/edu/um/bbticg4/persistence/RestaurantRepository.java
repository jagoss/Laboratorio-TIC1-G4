package uy.edu.um.bbticg4.persistence;

import org.hibernate.sql.Select;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import uy.edu.um.bbticg4.service.entities.Restaurant;
import uy.edu.um.bbticg4.service.entities.TipoComida;

import java.util.List;

public interface RestaurantRepository extends CrudRepository<Restaurant, Integer> {

    /**
     * Obtiene lista de restaurants filtrados
     * @param filtroBarrio
     * @param filtroRating
     * @return
     */
    List<Restaurant> findByBarrioAndRating(String filtroBarrio, Integer filtroRating);

    /**
     *
      * @param filtroBarrio
     * @return
     */
    List<Restaurant> findByBarrio(String filtroBarrio);

    @Query("SELECT r FROM Restaurant AS r INNER JOIN r.listaCategoriaComida AS tp WHERE tp.nombre IN (?1) AND r.barrio =(?2)")
    List<Restaurant> findByTipoComidaAndBarrio(List<Integer> idListaTiposComidas, String filtroBarrio);

    @Query("SELECT r FROM Restaurant AS r INNER JOIN r.listaCategoriaComida AS tp WHERE tp.nombre IN (?1) AND r.rating = (?2)" +
            " AND r.barrio = (?3)")
    List<Restaurant> findByTipoComidaAndRatingAAndBarrio(List<Integer> idListaTiposComida, Integer Rating, String barrio);

}
