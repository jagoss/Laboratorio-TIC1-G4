package um.edu.uy.bbticg4.service.entities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import um.edu.uy.bbticg4.exceptions.InvalidRestoInformation;
import um.edu.uy.bbticg4.exceptions.RestoAlreadyExists;
import um.edu.uy.bbticg4.persistence.RestaurantRepository;


@Controller
@ComponentScan(basePackageClasses = {um.edu.uy.bbticg4.persistence.RestaurantRepository.class})
public class RestaurantMgr {

    @Autowired
    private RestaurantRepository restaurantRepository;

    public void addRestaurant(Integer id, String name, String barrio) throws RestoAlreadyExists, InvalidRestoInformation {

        if(id == null || name == null || barrio == null || "".equals(name)|| "".equals(id) || "".equals(barrio)){
            throw new InvalidRestoInformation();
        }

        if(restaurantRepository.existsById(id)){
            throw new RestoAlreadyExists();
        }

        restaurantRepository.save(new Restaurant(id, name, barrio));
    }

}
