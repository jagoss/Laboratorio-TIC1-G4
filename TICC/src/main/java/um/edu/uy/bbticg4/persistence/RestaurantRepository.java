package um.edu.uy.bbticg4.persistence;

import org.springframework.data.repository.CrudRepository;
import um.edu.uy.bbticg4.service.entities.Restaurant;

public interface RestaurantRepository extends CrudRepository<Restaurant, Integer> {


}
