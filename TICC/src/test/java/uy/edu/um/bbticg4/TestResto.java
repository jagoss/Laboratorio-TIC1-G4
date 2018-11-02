package uy.edu.um.bbticg4;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import uy.edu.um.bbticg4.exceptions.*;
import uy.edu.um.bbticg4.service.BarrioMgr;
import uy.edu.um.bbticg4.service.TipoComidaMgr;
import uy.edu.um.bbticg4.service.entities.Barrio;
import uy.edu.um.bbticg4.service.entities.Restaurant;
import uy.edu.um.bbticg4.service.RestaurantMgr;

import java.util.LinkedList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

@SpringBootTest(classes= MainClienteFinalFiltro.class)
@RunWith(SpringRunner.class)
public class TestResto {

    @Autowired
    RestaurantMgr restoMgr;

    @Autowired
    TipoComidaMgr tcMgr;

    @Autowired
    BarrioMgr barrioMgr;

    @Test
    public void testFiltroBasicoAgregadoYBorrado() {
        try {

            Barrio pocitos = barrioMgr.getBarrio("Pocitos");
            Barrio malvinNorte = barrioMgr.getBarrio("MalvinNorte");
            Barrio buceo = barrioMgr.getBarrio("Buceo");

            List<Barrio> listaBarrio = new LinkedList<>();
            listaBarrio.add(pocitos);

            restoMgr.addRestaurant("Barloco", "bar555", "barcito",
                    "125", (long) 3, "b@barcito.com", "1133", "Un lugar45",
                    pocitos);
            restoMgr.addRestaurant("Balon", null, "barcito",
                    "141", (long) 32, "bar@b.com", "13", "Unpo",
                    buceo);
            restoMgr.addRestaurant("BarBuco", "bar10", "barBu",
                    "151", (long) 24, "barbu@barc.com", "233", "Un74",
                    malvinNorte);

            assertTrue(restoMgr.existsByRuc((long)3));
            assertTrue(restoMgr.existsByRuc((long)32));
            assertTrue(restoMgr.existsByRuc((long)24));

            List<Restaurant> listita = restoMgr.filtrarRestosPorBarrio(listaBarrio);
            assertEquals(restoMgr.findRestoByRuc((long) 3).getId(), listita.get(1).getId());

            listaBarrio.add(malvinNorte);
            listita = restoMgr.filtrarRestosPorBarrio(listaBarrio);
            assertEquals(restoMgr.findRestoByRuc((long) 3).getId(), listita.get(2).getId());
            assertEquals(restoMgr.findRestoByRuc((long) 24).getId(), listita.get(3).getId());

            assertTrue(restoMgr.deleteRestoByRuc((long)3));
            assertTrue(restoMgr.deleteRestoByRuc((long)32));
            assertTrue(restoMgr.deleteRestoByRuc((long)24));

        } catch (UserAlreadyExists userAlreadyExists) {
            userAlreadyExists.printStackTrace();
        } catch (InvalidUserInformation invalidUserInformation) {
            invalidUserInformation.printStackTrace();
        }catch (Exception e){
            restoMgr.deleteRestoByRuc((long)3);
            restoMgr.deleteRestoByRuc((long)32);
            restoMgr.deleteRestoByRuc((long)24);
        }
    }
}
