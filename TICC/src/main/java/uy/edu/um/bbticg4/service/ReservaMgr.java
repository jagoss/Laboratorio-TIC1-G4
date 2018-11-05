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

    public void generarReserva(ClienteFinal cf, List<Mesa> listaMesa, Integer cantidad, LocalDateTime hora)
            throws InvalidInformation {
        if(listaMesa == null || cf == null || cantidad == null || hora == null ||
                !cfr.existsById(cf.getId()) ||
                cantidad.equals(0) || hora.isBefore(LocalDateTime.now())){
            throw new InvalidInformation();
        }
        for(int i= 0; i<listaMesa.size(); i++){
            if (!mesaRepo.existsById( listaMesa.get(i).getId() )){
                throw new InvalidInformation();
            }
        }
        rr.save(new Reserva(cf, listaMesa, cantidad, hora));
    }

    public void deleteReserva(Reserva reserva){
        rr.delete(reserva);
    }

    public List<Reserva> getReservas(Restaurant resto){
        return rr.obtenerReservasdeResto(resto.getListaMesa());
    }
}
