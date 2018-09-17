package pruebapersistence.spring;

import pruebapersistence.ClienteFinal;

import java.sql.SQLException;
import java.util.List;

public interface ExampleRepository {

    List<ClienteFinal> allExamples() throws SQLException;

    void save(ClienteFinal example) throws SQLException;

}
