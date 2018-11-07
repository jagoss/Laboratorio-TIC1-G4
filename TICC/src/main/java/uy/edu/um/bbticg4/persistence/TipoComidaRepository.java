package uy.edu.um.bbticg4.persistence;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import uy.edu.um.bbticg4.service.entities.TipoComida;

import java.util.List;

public interface TipoComidaRepository extends CrudRepository<TipoComida, Integer> {

    @Query("SELECT tc FROM TipoComida as tc")
    List<TipoComida> findAllByNombre();

    @Query("SELECT DISTINCT tc FROM TipoComida tc WHERE tc.idTipoComida IN (?1)")
    List<TipoComida> findAllByIdTipoComida(List<Integer> listaId);
}
