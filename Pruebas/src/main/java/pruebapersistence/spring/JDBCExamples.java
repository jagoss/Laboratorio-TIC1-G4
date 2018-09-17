package pruebapersistence.spring;

import pruebapersistence.ClienteFinal;

import java.sql.SQLException;
import java.util.List;

public class JDBCExamples {
    ExampleRepository repository;

    public JDBCExamples(ExampleRepository repository) {
        this.repository = repository;
    }

    public void printExamples() throws SQLException {
        List<ClienteFinal> result = repository.allExamples();

        result.forEach(example -> {
            System.out.println(example);
        });

    }

}
