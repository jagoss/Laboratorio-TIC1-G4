package uy.edu.um.bbticg4.persistence;

import org.springframework.data.repository.CrudRepository;
import uy.edu.um.bbticg4.service.entities.ClienteFinal;

public interface ClienteFinalRepository extends CrudRepository<ClienteFinal, Integer> {

    boolean existsByEmailOrCellphone(String emial, String cellphone);

    boolean existsByEmailAndPassword(String email, String password);

    boolean existsByEmail(String email);
}
