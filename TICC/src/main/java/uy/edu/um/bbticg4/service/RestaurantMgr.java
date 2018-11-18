package uy.edu.um.bbticg4.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uy.edu.um.bbticg4.exceptions.CategoriaComidaYaAgregadaException;
import uy.edu.um.bbticg4.exceptions.InvalidUserInformation;
import uy.edu.um.bbticg4.exceptions.TipoComidaException;
import uy.edu.um.bbticg4.exceptions.UserAlreadyExists;
import uy.edu.um.bbticg4.persistence.BarrioRepository;
import uy.edu.um.bbticg4.persistence.RestaurantRepository;
import uy.edu.um.bbticg4.persistence.TipoComidaRepository;
import uy.edu.um.bbticg4.service.entities.Barrio;
import uy.edu.um.bbticg4.service.entities.Restaurant;
import uy.edu.um.bbticg4.service.entities.TipoComida;

import java.util.List;

@Service
public class RestaurantMgr {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private TipoComidaRepository tipoComidaRepository;

    @Autowired
    private BarrioRepository barrioRepo;

    public void addRestaurant(String name, String nombreFantasia, String password, String cuentaBanco , Long ruc,
                              String email, String cellphone, String direccion, Barrio barrio)
            throws UserAlreadyExists, InvalidUserInformation {

        if (name == null        || name.equals("")   ||
            email== null        || email.equals("")  ||
            ruc == null         ||
            cuentaBanco == null || cuentaBanco.equals("")||
            password == null    || password.equals("")  ||
            direccion == null   || direccion.equals("")||
            barrio == null      || !barrioRepo.existsById(barrio.getId()) ||
            cellphone == null   || cellphone.equals("")  ){
            throw new InvalidUserInformation();
        }

        if(restaurantRepository.existsByRucOrCellphoneOrCuentaBancoOrEmailOrName(ruc, cellphone, cuentaBanco, email, name)){
            throw new UserAlreadyExists();
        }
        if(nombreFantasia == null || nombreFantasia.equals("")){
            restaurantRepository.save(new Restaurant(name, password, cuentaBanco , ruc, email, cellphone,
                    direccion, barrio));
        }else{
            restaurantRepository.save(new Restaurant(name, nombreFantasia, password, cuentaBanco , ruc, email,
                    cellphone, direccion, barrio));
        }
    }

    public boolean loginCorrecto(String email, String password){
        if(email == null || password == null ){
            return false;
        }
        return restaurantRepository.existsByEmailAndPassword(email, password);
    }

    public boolean emailExists(String email){ return restaurantRepository.existsByEmail(email); }

    public List<Restaurant> filtrarRestosPorBarrio(List<Barrio> filtroBarrio){
        return restaurantRepository.findByBarrio(filtroBarrio);
    }

    public List<Restaurant> filtrarRestosPorBarrioYRating(String filtroBarrio, Integer estrellas) {
        return restaurantRepository.findByBarrioAndRating(filtroBarrio, estrellas);
    }

    public List<Restaurant> filtrarRestosPorBarrioYTipoComida(List<Integer> listaIdTipoComida, List<Barrio> filtroBarrio)
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
                                                             List<Barrio>  filtroBarrio) throws TipoComidaException {

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

        resto = restaurantRepository.findById(resto.getId()).get();

        if(!tipoComidaRepository.existsById(idTipoComida)){
            throw new TipoComidaException();
        }

        List<TipoComida> listaCategoriaComida = resto.getListaCategoriaComida();
        TipoComida tipoComida = tipoComidaRepository.findById(idTipoComida).get();

        if (!listaCategoriaComida.contains(tipoComida)) {
            resto.getListaCategoriaComida().add(tipoComida);
            restaurantRepository.save(resto);
            System.out.println("Agregacion exitosa!");
        }else{
            throw new CategoriaComidaYaAgregadaException();
        }
    }

    public Restaurant obtenerResto(Integer id){ return restaurantRepository.findById(id).get(); }

    public Restaurant findRestoByRuc(Long ruc){ return restaurantRepository.findRestaurantsByRuc(ruc); }

    public boolean deleteRestoByRuc(Long ruc){
        boolean exit = false;

        restaurantRepository.deleteRestaurantsByRuc(ruc);

        if (!restaurantRepository.existsByRuc(ruc)){ exit = true; }

        return exit;
    }

    public void reviewResto(int review){

    }

    public boolean existsByRuc(Long ruc){ return restaurantRepository.existsByRuc(ruc); }

    public void updateResto(Restaurant resto){ restaurantRepository.save(resto); }

    public void deleteResto(Integer id){ restaurantRepository.deleteById(id); }

    public Restaurant getRestaurant(String email){ return restaurantRepository.findRestaurantsByEmail(email);}

    public Restaurant getRestaurantByDireccion(String direccion){ return restaurantRepository.findRestaurantByDireccion(direccion);}
}
