package uy.edu.um.bbticg4.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uy.edu.um.bbticg4.exceptions.InvalidInformation;
import uy.edu.um.bbticg4.persistence.ClienteFinalRepository;
import uy.edu.um.bbticg4.persistence.MesaRepository;
import uy.edu.um.bbticg4.persistence.ReservaRepository;
import uy.edu.um.bbticg4.persistence.RestaurantRepository;
import uy.edu.um.bbticg4.service.entities.ClienteFinal;
import uy.edu.um.bbticg4.service.entities.Mesa;
import uy.edu.um.bbticg4.service.entities.Reserva;
import uy.edu.um.bbticg4.service.entities.Restaurant;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ReservaMgr {

    @Autowired
    private ReservaRepository rr;
    @Autowired
    private ClienteFinalRepository cfr;
    @Autowired
    private RestaurantRepository restoRepo;

    @Autowired
    private MesaRepository mesaRepo;

    public void generarReserva(ClienteFinal cf, Restaurant resto, Double cantidad, LocalDateTime hora)
            throws InvalidInformation {
        if(cf == null || resto == null || cantidad == null || hora == null ||
                !cfr.existsById(cf.getId()) || !restoRepo.existsById(resto.getId()) ||
                cantidad.equals(0) || hora.isBefore(LocalDateTime.now())){
            throw new InvalidInformation();
        }
        rr.save(new Reserva(cf, resto, cantidad, hora));
    }

    public void deleteReserva(Reserva reserva){
        rr.delete(reserva);
    }

    public List<Reserva> getReservas(Restaurant resto){
        return rr.findReservasByResto(resto);
    }
}
