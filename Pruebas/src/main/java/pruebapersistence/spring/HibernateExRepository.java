package pruebapersistence.spring;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import pruebapersistence.ClienteFinal;

import java.sql.SQLException;
import java.util.List;

public class HibernateExRepository implements ExampleRepository {

    @Autowired
    @NonNull
    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    @Override
    public List<ClienteFinal> allExamples() throws SQLException {
        try (Session session = sessionFactory.openSession()) {
            return (List<ClienteFinal>) session.createQuery("from Example").list();
        }
    }

    @Override
    public void save(ClienteFinal example) throws SQLException {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            session.save(example);

            session.getTransaction().commit();
        }
    }

}
