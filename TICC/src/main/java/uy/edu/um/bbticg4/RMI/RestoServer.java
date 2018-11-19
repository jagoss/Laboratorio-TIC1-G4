/*
package uy.edu.um.bbticg4.RMI;

import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;
import org.springframework.remoting.rmi.RmiServiceExporter;



@Configuration
public class RestoServer{

    @Bean
    RmiServiceExporter exporter(@Qualifier("reservasRemoteImpl") ReservasRemote implementation) {
        Class<ReservasRemote> interfazReserva = ReservasRemote.class;
        RmiServiceExporter exporter = new RmiServiceExporter();
        exporter.setServiceInterface(ReservasRemote.class);
        exporter.setService(new ReservasRemoteImpl());
        exporter.setServiceName("Reservas App");
        exporter.setRegistryPort(8080);

        return exporter
    }


}

*/