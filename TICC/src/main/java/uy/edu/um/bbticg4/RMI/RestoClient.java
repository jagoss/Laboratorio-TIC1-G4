/*
package uy.edu.um.bbticg4.RMI;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;
import org.springframework.boot.SpringApplication;

public class RestoClient {

    @bean
    RmiProxyFactoryBean rmiProxy() {
        RmiProxyFactoryBean rmiProxyFactory = new RmiProxyFactoryBean();
        rmiProxyFactory.setServiceURL("rmi://localhost:8080/ReservasApp");
        rmiProxyFavtory.setServiceInterface(ReservasApp.class);

        return rmiProxyFactory;
    }

    public static void main(String[] args) throws RestoLlenoException {
        ReservasRemote reservasRemote = SpringApplication.run(RestoClient.class args).getBean(ReservasRemote.class);



    }
}
}

*/