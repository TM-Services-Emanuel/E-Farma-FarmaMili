package Componentes;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.dbcp2.BasicDataSource;

/**
 *
 * @author TM-SERVICES
 */
public class DataSourceService1 {

    private static BasicDataSource basicDataSource = null;
    private final String bd = Config.getBD();
    private final String user = Config.getUserServerCruce();
    private final String pass = Config.getPasswordServerCruce();

    public DataSourceService1() {   
        final String servidor = Config.getIPServerCruce() + ":" + Config.getPortServerCruce();
        final String url = "jdbc:mariadb://" + servidor + "/" + bd + "";
        if (null == basicDataSource) {
            basicDataSource = new BasicDataSource();
            basicDataSource.setDriverClassName("org.mariadb.jdbc.Driver");
            basicDataSource.setUsername(user);
            basicDataSource.setPassword(pass);
            basicDataSource.setUrl(url);
            basicDataSource.setMaxTotal(200);
            basicDataSource.setMinIdle(50);
            basicDataSource.setMaxIdle(100);
        }
    }

    public BasicDataSource getDataSource() {
        return basicDataSource;

    }

    public BasicDataSource getReconect() {
        final String servidor = Config.getIPServerCruce() + ":" + Config.getPortServerCruce();
        final String url = "jdbc:mariadb://" + servidor + "/" + bd + "";
        basicDataSource = new BasicDataSource();
        basicDataSource.setDriverClassName("org.mariadb.jdbc.Driver");
        basicDataSource.setUsername(user);
        basicDataSource.setPassword(pass);
        basicDataSource.setUrl(url);
        basicDataSource.setMaxTotal(200);
        basicDataSource.setMinIdle(50);
        basicDataSource.setMaxIdle(100);
        return basicDataSource;
    }

}
