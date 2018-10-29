package uy.edu.um.bbticg4.service.entities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uy.edu.um.bbticg4.exceptions.InvalidInformation;
import uy.edu.um.bbticg4.persistence.ClienteFinalRepository;
import uy.edu.um.bbticg4.persistence.ReservaRepository;
import uy.edu.um.bbticg4.persistence.RestaurantRepository;

@Service
public class ReservaMgr {

    @Autowired
    private ReservaRepository rr;
    @Autowired
    private ClienteFinalRepository cfr;
    @Autowired
    private RestaurantRepository restoRepo;

    public void generarReserva(ClienteFinal cf, Restaurant resto) throws InvalidInformation {
        if(resto == null || cf == null || !cfr.existsById(cf.getId()) || !restoRepo.existsById(resto.getId())){
            throw new InvalidInformation();
        }
        rr.save(new Reserva(cf, resto));
    }

    public void deleteReserva(Reserva reserva){
        rr.delete(reserva);
    }

}
