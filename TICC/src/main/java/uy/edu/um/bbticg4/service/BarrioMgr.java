package uy.edu.um.bbticg4.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uy.edu.um.bbticg4.persistence.BarrioRepository;
import uy.edu.um.bbticg4.service.entities.Barrio;

@Service
public class BarrioMgr {

    @Autowired
    private BarrioRepository barrioRepo;


    public void addBarrio(String name){

        barrioRepo.save(new Barrio((int)(barrioRepo.count()+1),name));
    }

    public int countBarrios(){
        return (int) barrioRepo.count();
    }

    public Barrio getBarrio(String nombre){
        return barrioRepo.findBarrioByName(nombre);
    }

}
