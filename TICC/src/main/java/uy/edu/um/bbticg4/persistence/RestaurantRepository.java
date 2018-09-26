package uy.edu.um.bbticg4.persistence;

import org.springframework.data.repository.CrudRepository;
import uy.edu.um.bbticg4.service.entities.Restaurant;

public interface RestaurantRepository extends CrudRepository<Restaurant, Integer> {

//    /**
//     * Obtiene lista de restaurants filtrados
//     * @param filtroBarrio
//     * @param filtroRating
//     * @return
//     */
//    List<Restaurant> listaRestoFiltrados(String filtroBarrio, Integer filtroRating);
//
//    /**
//     *
//      * @param filtroBarrio
//     * @return
//     */
//    List<Restaurant> listaRestoFiltrados(String filtroBarrio);

//    @Query()
//    List<Restaurant> filtrarPorComida(@RequestParam(value="listaCategoriaComida", required=false) String comidas);

}
