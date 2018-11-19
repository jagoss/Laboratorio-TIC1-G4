package uy.edu.um.bbticg4.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uy.edu.um.bbticg4.exceptions.InvalidInformation;
import uy.edu.um.bbticg4.exceptions.TipoComidaAlreadyExists;
import uy.edu.um.bbticg4.persistence.TipoComidaRepository;
import uy.edu.um.bbticg4.service.entities.TipoComida;

import java.util.List;

@Service
public class TipoComidaMgr {

    @Autowired
    private TipoComidaRepository tcr;

    public void addTipoComida(Integer id, String name)
            throws TipoComidaAlreadyExists, InvalidInformation {

        if(id == null || name == null || "".equals(name)|| "".equals(id)){
            throw new InvalidInformation();
        }

        if(tcr.existsById(id)){
            throw new TipoComidaAlreadyExists();
        }
        tcr.save(new TipoComida(id, name));
    }

    public int count(){return (int) tcr.count();}
    public List<TipoComida> obtenerListaCategoria(){
        return tcr.findAllByNombre();
    }

    public TipoComida obtenerTipoComida(Integer id){
        return tcr.findById(id).get();
    }

    public List<TipoComida> getListaPorId(List<Integer> listaId){
        return tcr.findAllByIdTipoComida(listaId);
    }
}
