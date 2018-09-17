package pruebapersistence;

import pruebapersistence.ClienteFinal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args){

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenceExample");

        ClienteFinal cliente1 = new ClienteFinal(1, "Pablo", "Perez",
                "pp@gmail.com" ,"094111111");

        Restuarante restuarante1 = new Restuarante("Los pibes 2", "lospi2@gmail.com",
                "Pocitos","099222111");
        restuarante1.setCuentaBancaria("8/1122");
        restuarante1.setRuc(1113222);

        Mesas mesa1= new Mesas(1,1,4, restuarante1);

        Mesas mesa2= new Mesas(2,3,4, restuarante1);

        EntityManager em = emf.createEntityManager();

        // Persist entity
        em.getTransaction().begin();
        em.persist(cliente1);

        List<Mesas> mesitas = new ArrayList<>();
        mesitas.add(mesa1);
        mesitas.add(mesa2);
        restuarante1.setListaMesas(mesitas);
        em.persist(restuarante1);

        em.persist(mesa1);
        em.persist(mesa2);

        Integer idRestaurante = restuarante1.getId_restaurente();
        Integer nroMesa = mesa1.getNroMesa();
        em.getTransaction().commit();

        em.getTransaction().begin();

        Restuarante restauranteGuardado = em.find(Restuarante.class, idRestaurante);
        //System.out.println(restauranteGuardado.getListaMesas());

        List<Mesas> mesasPrint = em.createQuery("select m from Mesas m").getResultList();

        em.getTransaction().commit();

        em.getTransaction().begin();
        em.remove(em.find(Mesas.class, mesa1.getIdMesa()));
        em.remove(em.find(Mesas.class, mesa2.getIdMesa()));
        em.remove(restauranteGuardado);
        em.getTransaction().commit();

        /* Retrieve entity */
        ClienteFinal clienteTemp = em.find(ClienteFinal.class, cliente1.getId());
        System.out.println(clienteTemp);

        /* Update entity */
        em.getTransaction().begin();
        clienteTemp.setFirstName("Pranil");
        System.out.println("Employee after updation :- " + clienteTemp);
        em.getTransaction().commit();
        System.out.println(em.find(ClienteFinal.class, 1));

        /* Remove entity */
        em.getTransaction().begin();
        em.remove(clienteTemp);
        em.getTransaction().commit();

        /* Check whether entity is removed or not */
        clienteTemp = em.find(ClienteFinal.class, cliente1.getId());
        System.out.println("Employee after removal :- " + clienteTemp);
        em.close();

        System.out.println(mesasPrint);
    }
}
