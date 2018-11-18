package uy.edu.um.bbticg4.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import uy.edu.um.bbticg4.service.entities.ClienteFinal;

@Repository
public interface ClienteFinalRepository extends CrudRepository<ClienteFinal, Integer> {

    boolean existsByEmailOrCellphone(String emial, String cellphone);

    boolean existsByEmailAndPassword(String email, String password);

    boolean existsByEmail(String email);

    ClienteFinal findClienteFinalByEmail(String email);

    ClienteFinal findClienteFinalById(Integer id);
}
