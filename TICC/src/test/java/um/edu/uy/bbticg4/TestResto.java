package um.edu.uy.bbticg4;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import um.edu.uy.bbticg4.exceptions.InvalidRestoInformation;
import um.edu.uy.bbticg4.exceptions.RestoAlreadyExists;
import um.edu.uy.bbticg4.service.entities.RestaurantMgr;
import static junit.framework.TestCase.fail;


@SpringBootTest
@RunWith(SpringRunner.class)
public class TestResto {

    @Autowired
    RestaurantMgr restoMgr;

    @Test
    public void testBasic(){
        try {

            // Se agrega un resto

            restoMgr.addRestaurant(10,"Bar","Pocitos");

        } catch (RestoAlreadyExists clientAlreadyExists) {

            TestCase.fail(clientAlreadyExists.getMessage());

        } catch (InvalidRestoInformation invalidRestoInformation) {
            invalidRestoInformation.printStackTrace();
        }

       try {

            // Se prueba agregar el mismo cliente con la cedula

            restoMgr.addRestaurant(10, "Bar","Pocitos");

            TestCase.fail("Resto ya existia");

        } catch (RestoAlreadyExists restoAlreadyExists) {

            // Ok flujo correcto
        } catch (InvalidRestoInformation invalidRestoInformation) {
            invalidRestoInformation.printStackTrace();
        }
    }
}
