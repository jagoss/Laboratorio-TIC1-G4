package pruebapersistence.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.text.ParseException;

public class SpringMain {
    public static void main(String[] args) throws ClassNotFoundException, SQLException, ParseException {

        ApplicationContext ctx = new AnnotationConfigApplicationContext(JDBCExampleConfig.class);
        JDBCExamples example = ctx.getBean(JDBCExamples.class);
        example.printExamples();
        System.exit(0);
    }
}
