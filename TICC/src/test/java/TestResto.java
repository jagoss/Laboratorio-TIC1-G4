import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import um.edu.uy.bbticg4.exceptions.RestoAlreadyExists;
import um.edu.uy.bbticg4.service.entities.Restaurant;
import um.edu.uy.bbticg4.service.entities.RestaurantMgr;

import static junit.framework.TestCase.fail;


@SpringBootTest(classes = RestaurantMgr.class)
@RunWith(SpringRunner.class)
public class TestResto {

    @Autowired
    RestaurantMgr restoMgr;

    @Test
    public void testBasic(){
        try {

            // Se agrega un cliente

            restoMgr.addRestaurant(123, "Barcito","Pocitos");

        } catch (RestoAlreadyExists clientAlreadyExists) {

            fail(clientAlreadyExists.getMessage());

        }


        try {

            // Se prueba agregar el mismo cliente con la cedula

            restoMgr.addRestaurant(1231, "Barcito","Pocitos");

            fail("Resto ya existia");

        } catch (RestoAlreadyExists restoAlreadyExists) {

            // Ok flujo correcto
        }
    }
}
