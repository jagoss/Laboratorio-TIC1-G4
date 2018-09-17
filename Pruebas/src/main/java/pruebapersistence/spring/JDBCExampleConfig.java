package pruebapersistence.spring;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.sql.DataSource;

@Configuration
public class JDBCExampleConfig {

    @Value("${jdbc.url}")
    String jdbcUrl;
    @Value("root")
    String jdbcUser;
    @Value("${jdbc.pwd:goss123456}")
    String jdbcPwd;

    @Bean (name = "pool")
    public DataSource pool (){
        BasicDataSource ds = new BasicDataSource();
        ds.setUrl(jdbcUrl);
        ds.setUsername(jdbcUser);
        ds.setPassword(jdbcPwd);
        ds.setDefaultAutoCommit(true);
        ds.setInitialSize(10);
        ds.setMaxWaitMillis(20000);
        return ds;
    }
    @Bean
    SessionFactory sessionFactory(@Autowired @Qualifier("pool") javax.sql.DataSource ds) {
        org.hibernate.cfg.Configuration configuration = new org.hibernate.cfg.Configuration();
        configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL57Dialect");
        //configuration.addAnnotatedClass(ClienteFinal.class);
        //configuration.addResource("Example.hbm.xml");
        configuration.setProperty("hibernate.schema_update", "true");
        configuration.setProperty("hibernate.hbm2ddl.auto", "create");
        configuration.setProperty("hibernate.show_sql", "true");

        return configuration
                .buildSessionFactory(
                        new StandardServiceRegistryBuilder()
                                .applySettings(configuration.getProperties())
                                .applySetting(Environment.DATASOURCE, ds)
                                .build());

    }

    @Bean
    JDBCTemplate jdbcTemplate(@Autowired javax.sql.DataSource ds) {
        return new JDBCTemplate(ds);
    }


}
