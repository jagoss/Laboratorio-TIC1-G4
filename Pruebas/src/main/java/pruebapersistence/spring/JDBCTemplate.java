package pruebapersistence.spring;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class JDBCTemplate {

    DataSource ds;

    public  JDBCTemplate(DataSource ds){
        this.ds = ds;
    }

    Object execute(JDBCTemplateCallback callback) throws SQLException{
        try (Connection con = ds.getConnection()){
        return callback.execute(con);
        }
    }
}