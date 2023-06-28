package Componentes;

import java.sql.Connection;
import org.mariadb.jdbc.MariaDbConnection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
    
    private final String ruta = "127.0.0.1:3306";
    //private final String ruta = "192.168.1.1:3306";
    private final String bd = "bd_farmacia";
    private final String usuario = "root";
    //private final String password = "";
    private final String password = "emanuel4744832";

    public Connection getConexion() {
        MariaDbConnection cn = null;
        try {
            //MySQL
            Class.forName("org.mariadb.jdbc.Driver");
            cn = (MariaDbConnection) DriverManager.getConnection("jdbc:mariadb://"+ruta+"/"+bd+"", ""+usuario+"", ""+password+"");
            
            //MySQL
            //Class.forName("com.mysql.jdbc.Driver");
            //cn = DriverManager.getConnection("jdbc:mysql://"+servidor+"/"+bd+"", ""+usuario+"", ""+password+"");
            
            //PostgreSQL
//            Class.forName("org.postgresql.Driver");
//            cn = DriverManager.getConnection("jdbc:postgresql://"+servidor+":5432/"+bd+"", ""+usuario+"", ""+password+"");
            /*SQL SERVER*/
//            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
//            cn = DriverManager.getConnection("jdbc:odbc:bdfarmacia","root","");
            
        } catch (ClassNotFoundException | SQLException e) {
            cn = null;
        }
        return cn;
    }

}
