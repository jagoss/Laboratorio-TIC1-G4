package uy.edu.um.bbticg4.persistence;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;
import uy.edu.um.bbticg4.service.entities.Barrio;
import uy.edu.um.bbticg4.service.entities.Mesa;
import uy.edu.um.bbticg4.service.entities.Restaurant;

import java.util.List;

public interface RestaurantRepository extends CrudRepository<Restaurant, Integer> {

    List<Restaurant> findByBarrioAndRating(String filtroBarrio, Integer filtroRating);

    @Query("SELECT r FROM Restaurant r WHERE r.barrio IN (?1) AND r.firstLogin = FALSE ORDER BY r.rating desc ")
    List<Restaurant> findByBarrio(List<Barrio> listaBarrio);

    boolean existsByRucOrCellphoneOrCuentaBancoOrEmailOrName(Long ruc, String cellphone, String cuentaBanco,
                                                             String email, String name);


    @Query("SELECT distinct r FROM Restaurant r INNER JOIN r.listaCategoriaComida tp WHERE tp.idTipoComida IN (?1) " +
            "AND r.barrio IN (?2) AND r.firstLogin = FALSE ORDER BY r.rating desc ")
    List<Restaurant> findByTipoComidaAndBarrio(List<Integer> idListaTiposComidas, List<Barrio> listaBarrio);


    @Query("SELECT distinct  r FROM Restaurant r INNER JOIN r.listaCategoriaComida tp WHERE tp.id IN (?1) AND r.rating = (?2)" +
            " AND r.barrio IN(?3) ORDER BY r.rating desc ")
    List<Restaurant> findByTipoComidaAndRatingAAndBarrio(List<Integer> idListaTiposComida, Integer Rating,
                                                         List<Barrio> listaBarrio);

    boolean existsByEmailAndPassword(String email, String password);

    boolean existsByEmail(String email);

    Restaurant findRestaurantsByRuc(Long ruc);

    @Transactional
    void deleteRestaurantsByRuc(Long ruc);

    boolean existsByRuc(Long ruc);

    Restaurant findRestaurantsByEmail(String email);

}
