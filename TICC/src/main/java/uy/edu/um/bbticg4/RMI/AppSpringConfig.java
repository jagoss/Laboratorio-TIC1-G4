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

@configuration
public class AppSpringConfig {

    @value("${server.port}")
    integer port;

    @value("${server.host}")
    String host;

    @Bean
    public BackendService backendServiceClient() throws RemoteException, NotBoundException {

        String sObjectService = "backend";

        Registry oRegistry = LocateRegistry.getRegistry(host, port);
        BackendService bs = (BackendService) oRegistry.lookup(sObjectService);


        System.out.println("Cargado");
        return bs;
    }
}

*/