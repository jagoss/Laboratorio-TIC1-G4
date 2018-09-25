package um.edu.uy.bbticg4.persistence;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
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

//    @Query()
//    List<Restaurant> filtrarPorComida(@RequestParam(value="listaCategoriaComida", required=false) String comidas);

}
