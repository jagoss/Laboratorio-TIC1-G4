package uy.edu.um.bbticg4.persistence;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import uy.edu.um.bbticg4.service.entities.Mesa;
import uy.edu.um.bbticg4.service.entities.Restaurant;

import java.util.List;

public interface MesaRepository extends CrudRepository<Mesa, Integer> {

}
