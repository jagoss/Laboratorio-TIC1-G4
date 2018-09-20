package um.edu.uy.bbticg4.service.entities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import um.edu.uy.bbticg4.exceptions.RestoAlreadyExists;
import um.edu.uy.bbticg4.persistence.RestaurantRepository;

@Service
public class RestaurantMgr {

    @Autowired
    private RestaurantRepository restoRepo;

    public void addRestaurant(Integer id, String name, String barrio) throws RestoAlreadyExists {

        if(restoRepo.findById(id) != null){
            throw new RestoAlreadyExists();
        }

        Restaurant oResto = new Restaurant(id, name, barrio);

        restoRepo.save(oResto);
    }

}
