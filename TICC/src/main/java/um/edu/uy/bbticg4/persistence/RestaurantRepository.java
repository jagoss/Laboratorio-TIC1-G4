package um.edu.uy.bbticg4.persistence;

import org.springframework.data.repository.CrudRepository;
import um.edu.uy.bbticg4.service.entities.Restaurant;

import java.util.List;

public interface RestaurantRepository extends CrudRepository<Restaurant, Integer> {

    /**
     * Obtiene lista de restaurants filtrados
     * @param filtroBarrio
     * @param filtroRating
     * @return
     */
    List<Restaurant> listaRestoFiltrados(String filtroBarrio, Integer filtroRating);

    /**
     *
      * @param filtroBarrio
     * @return
     */
    List<Restaurant> listaRestoFiltrados(String filtroBarrio);

}
