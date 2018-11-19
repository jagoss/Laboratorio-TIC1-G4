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
public class AppConfig{

    @value("${Server.port}")
    integer port;

    @value("${server.host}")
    String host;

    @bean
    public BackendService loadServer(@Autowired BackendServiceImp bsImp) throws RemoteException {

        System.setProperty("java.rmi.server.hostname", host);
        String name = "backend";
        BackendService bs = bsImp;
        BackendService oStub = (BackendService) UnicastRemoteObject.exportObject(bs, port:8080);
        Registry oRegistry = LocateRegistry.createRegistry(port);
        oRegistry.rebind(name, oStub);
        System.out.println("Server Cargado");

        return bs;
    }
}

*/