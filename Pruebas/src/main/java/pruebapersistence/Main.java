package pruebapersistence;

import pruebapersistence.ClienteFinal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

    public static void main(String[] args){

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenceExample");

        ClienteFinal cliente1 = new ClienteFinal();
        cliente1.setFirstName("Pablo");
        cliente1.setLastName("Perez");
        cliente1.setCelular("094111111");
        cliente1.setEmail("pp@gmail.com");
        cliente1.setId(1);

        EntityManager em = emf.createEntityManager();

        // Persist entity
        em.getTransaction().begin();
        em.persist(cliente1);
        em.getTransaction().commit();

        /* Retrieve entity */
        ClienteFinal clienteTemp = em.find(ClienteFinal.class, cliente1.getId());
        System.out.println(clienteTemp);

        /* Update entity */
        em.getTransaction().begin();
        clienteTemp.setFirstName("Pranil");
        System.out.println("Employee after updation :- " + clienteTemp);
        em.getTransaction().commit();

        /* Remove entity */
        em.getTransaction().begin();
        em.remove(clienteTemp);
        em.getTransaction().commit();

        /* Check whether entity is removed or not */
        clienteTemp = em.find(ClienteFinal.class, cliente1.getId());
        System.out.println("Employee after removal :- " + clienteTemp);
        em.close();
    }
}
