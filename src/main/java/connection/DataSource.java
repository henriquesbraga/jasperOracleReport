package connection;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.SQLException;
import java.sql.Connection;

public class DataSource {
  private static HikariConfig config = new HikariConfig();
  private static HikariDataSource ds;

  static {
    config.setDriverClassName("oracle.jdbc.driver.OracleDriver");
    config.setJdbcUrl( "jdbc:oracle:thin:@localhost:1521/XE" );
    config.setUsername( "hr" );
    config.setPassword( "1234" );
    config.addDataSourceProperty( "cachePrepStmts" , "true" );
    config.addDataSourceProperty( "prepStmtCacheSize" , "250" );
    config.addDataSourceProperty( "prepStmtCacheSqlLimit" , "2048" );
    ds = new HikariDataSource( config );
  }

  private DataSource() {}

  public static Connection getConnection() throws SQLException {
    return ds.getConnection();
  }
}
