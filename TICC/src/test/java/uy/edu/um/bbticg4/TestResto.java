package uy.edu.um.bbticg4;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import uy.edu.um.bbticg4.exceptions.*;
import uy.edu.um.bbticg4.service.TipoComidaMgr;
import uy.edu.um.bbticg4.service.entities.Restaurant;
import uy.edu.um.bbticg4.service.RestaurantMgr;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestResto {

    @Autowired
    RestaurantMgr restoMgr;

    @Autowired
    TipoComidaMgr tcMgr;

    public void testBasic(){
        try {

            // Se agrega un resto

            restoMgr.addRestaurant(1,"Bar","bar1", "bar@bar.com",
                    "1111","Pocitos");

        } catch (UserAlreadyExists clientAlreadyExists) {

            TestCase.fail(clientAlreadyExists.getMessage());

        } catch (InvalidUserInformation invalidRestoInformation) {
            invalidRestoInformation.printStackTrace();
        }

       try {

            // Se prueba agregar el mismo cliente con la cedula

            restoMgr.addRestaurant(1,"Bar","bar1", "bar@bar.com",
                    "1111","Pocitos");

            TestCase.fail("Resto ya existia");

        } catch (UserAlreadyExists restoAlreadyExists) {

            // Ok flujo correcto
        } catch (InvalidUserInformation invalidRestoInformation) {
            invalidRestoInformation.printStackTrace();
        }
    }

//    @Test
//    public void testConsulta(){
//        try {
//
//            restoMgr.addRestaurant(123,"Bar","bar1", "bar@bar.com",
//                    "1111","Pocitos");
//
//            Restaurant resto1 = restoMgr.obtenerResto(123);
//            resto1.addCategoriaComida("Pizza");
//            resto1.addCategoriaComida("Chivito");
//            resto1.addCategoriaComida("Pasta");
//
//            restoMgr.updateResto(resto1);
//            restoMgr.deleteResto(123);
//
//        } catch (UserAlreadyExists userAlreadyExists) {
//            userAlreadyExists.printStackTrace();
//        } catch (InvalidUserInformation invalidUserInformation) {
//            invalidUserInformation.printStackTrace();
//        }
//    }

    @Test
    public void testFiltroBasico(){
        try {

            restoMgr.addRestaurant(1234,"Barcito","bar1", "bar@bar.com",
                    "1111","Pocitos");

            restoMgr.addRestaurant(1235,"Barzon","bar1", "bar@bar.com",
                    "1111","Pocitos");

            List<Restaurant> listita = restoMgr.filtrarRestosPorBarrio("Pocitos");

            System.out.println(listita.toString());

            restoMgr.deleteResto(1234);
            restoMgr.deleteResto(1235);

            //Esto esta porque tenia que agregar restaurants para usar en el main y no sabia hacerlo de otra manera mas facil
            tcMgr.addTipoComida(1, "Parrilla");
            tcMgr.addTipoComida(2, "Pasta");
            tcMgr.addTipoComida(3, "Pizza");

            restoMgr.addRestaurant(1234,"Barcito","bar1", "bar@bar.com",
                    "1111","Pocitos");
            restoMgr.addCategoriaComida(restoMgr.obtenerResto(1234),1);

            restoMgr.addRestaurant(1235,"Barzon","bar1", "bar@bar.com",
                    "1111","Pocitos");
            restoMgr.addCategoriaComida(restoMgr.obtenerResto(1235),2);

            restoMgr.addRestaurant(12,"Barzon","bar1", "bar@bar.com",
                    "1111","MalvinNorte");
            restoMgr.addCategoriaComida(restoMgr.obtenerResto(12),1);

        } catch (UserAlreadyExists userAlreadyExists) {
            userAlreadyExists.printStackTrace();
        } catch (InvalidUserInformation invalidUserInformation) {
            invalidUserInformation.printStackTrace();
        } catch (TipoComidaAlreadyExists tipoComidaAlreadyExists) {
            tipoComidaAlreadyExists.printStackTrace();
        } catch (InvalidInformation invalidInformation) {
            invalidInformation.printStackTrace();
        } catch (TipoComidaException e) {
            e.printStackTrace();
        } catch (CategoriaComidaYaAgregadaException e) {
            e.printStackTrace();
        }
    }
}
