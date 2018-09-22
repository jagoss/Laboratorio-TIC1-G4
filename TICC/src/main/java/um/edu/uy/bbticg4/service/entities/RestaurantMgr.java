package um.edu.uy.bbticg4.service.entities;

import org.springframework.stereotype.Service;
import um.edu.uy.bbticg4.exceptions.InvalidRestoInformation;
import um.edu.uy.bbticg4.exceptions.RestoAlreadyExists;
import um.edu.uy.bbticg4.persistence.RestaurantRepository;

import java.util.Optional;

@Service
public class RestaurantMgr {

    private RestaurantRepository restoRepo = new RestaurantRepository() {
        @Override
        public <S extends Restaurant> S save(S entity) {
            return null;
        }

        @Override
        public <S extends Restaurant> Iterable<S> saveAll(Iterable<S> entities) {
            return null;
        }

        @Override
        public Optional<Restaurant> findById(Integer integer) {
            return Optional.empty();
        }

        @Override
        public boolean existsById(Integer integer) {
            return false;
        }

        @Override
        public Iterable<Restaurant> findAll() {
            return null;
        }

        @Override
        public Iterable<Restaurant> findAllById(Iterable<Integer> integers) {
            return null;
        }

        @Override
        public long count() {
            return 0;
        }

        @Override
        public void deleteById(Integer integer) {

        }

        @Override
        public void delete(Restaurant entity) {

        }

        @Override
        public void deleteAll(Iterable<? extends Restaurant> entities) {

        }

        @Override
        public void deleteAll() {

        }
    };

    public void addRestaurant(Integer id, String name, String barrio) throws RestoAlreadyExists, InvalidRestoInformation {

        if(id == null || name == null || barrio == null || "".equals(name)|| "".equals(id) || "".equals(barrio)){
            throw new InvalidRestoInformation();
        }

        if(restoRepo.existsById(id)){
            throw new RestoAlreadyExists();
        }

        restoRepo.save(new Restaurant(id, name, barrio));
    }

}
