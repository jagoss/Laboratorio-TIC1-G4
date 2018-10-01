package uy.edu.um.bbticg4.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uy.edu.um.bbticg4.exceptions.CategoriaComidaYaAgregadaException;
import uy.edu.um.bbticg4.exceptions.InvalidUserInformation;
import uy.edu.um.bbticg4.exceptions.TipoComidaException;
import uy.edu.um.bbticg4.exceptions.UserAlreadyExists;
import uy.edu.um.bbticg4.persistence.RestaurantRepository;
import uy.edu.um.bbticg4.persistence.TipoComidaRepository;
import uy.edu.um.bbticg4.service.entities.Restaurant;
import uy.edu.um.bbticg4.service.entities.TipoComida;

import java.util.List;

@Service
public class RestaurantMgr {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private TipoComidaRepository tipoComidaRepository;

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

      public List<Restaurant> filtrarRestosPorBarrio(String filtroBarrio){

        return restaurantRepository.findByBarrio(filtroBarrio);
    }

    public List<Restaurant> filtrarRestosPorBarrioYRating(String filtroBarrio, Integer estrellas){

        return restaurantRepository.findByBarrioAndRating(filtroBarrio, estrellas);
    }

    public List<Restaurant> filtrarRestosPorBarrioYTipoComida(List<Integer> listaIdTipoComida, String filtroBarrio)
            throws TipoComidaException {

        int listaSize =listaIdTipoComida.size();

        for(int i=0; i<listaSize; i++) {
            if (!tipoComidaRepository.existsById(listaIdTipoComida.get(0))) {
                throw new TipoComidaException();
            }
        }
        return restaurantRepository.findByTipoComidaAndBarrio(listaIdTipoComida, filtroBarrio);
    }

    public List<Restaurant> filtrarRestosPorBarrioYTipoComidaYRating(List<Integer> listaIdTipoComida, Integer rating,
                                                                     String filtroBarrio) throws TipoComidaException {

        int listaSize =listaIdTipoComida.size();

        for(int i=0; i<listaSize; i++) {
            if (!tipoComidaRepository.existsById(listaIdTipoComida.get(0))) {
                throw new TipoComidaException();
            }
        }

        return restaurantRepository.findByTipoComidaAndRatingAAndBarrio(listaIdTipoComida, rating ,filtroBarrio);
    }

    public void addCategoriaComida(Restaurant resto, Integer idTipoComida) throws TipoComidaException,
            CategoriaComidaYaAgregadaException{

        if(!tipoComidaRepository.existsById(idTipoComida)){
            throw new TipoComidaException();
        }

        List<TipoComida> listaCategoriaComida = resto.getListaCategoriaComida();
        TipoComida tipoComida = tipoComidaRepository.findById(idTipoComida).get();

        if (!listaCategoriaComida.contains(tipoComida)) {
            resto.getListaCategoriaComida().add(tipoComida);
            System.out.println("Agregacion exitosa!");
        }else{
            throw new CategoriaComidaYaAgregadaException();
        }
    }

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
