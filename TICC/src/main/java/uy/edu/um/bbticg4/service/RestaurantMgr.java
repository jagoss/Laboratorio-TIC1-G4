package uy.edu.um.bbticg4.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uy.edu.um.bbticg4.exceptions.InvalidUserInformation;
import uy.edu.um.bbticg4.exceptions.UserAlreadyExists;
import uy.edu.um.bbticg4.persistence.RestaurantRepository;
import uy.edu.um.bbticg4.service.entities.Restaurant;

@Service
public class RestaurantMgr {

    @Autowired
    private RestaurantRepository restaurantRepository;

    public void addRestaurant(Integer id, String name, String password, String email, String cellphone ,String barrio)
            throws UserAlreadyExists, InvalidUserInformation {

        if(id == null || name == null || barrio == null || "".equals(name)|| "".equals(id) || "".equals(barrio)){
            throw new InvalidUserInformation();
        }

        if(restaurantRepository.existsById(id)){
            throw new UserAlreadyExists();
        }

        restaurantRepository.save(new Restaurant(id, name, password, email, cellphone , barrio));
    }

//      public List<Restaurant> filtrarRestosporBarrio(String filtroBarrio){
//
//        return restaurantRepository.listaRestoFiltrados(filtroBarrio);
//    }
//
//    public List<Restaurant> filtrarRestosporBarrio(String filtroBarrio, Integer estrellas){
//
//        return restaurantRepository.listaRestoFiltrados(filtroBarrio, estrellas);
//    }

    public Restaurant obtenerResto(Integer id){

      return restaurantRepository.findById(id).get();
    }

    public void updateResto(Restaurant resto){

        restaurantRepository.save(resto);
    }

    public void deleteResto(Integer id){
        restaurantRepository.deleteById(id);
    }
}
