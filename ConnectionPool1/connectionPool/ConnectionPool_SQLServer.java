package connectionPool;




import java.sql.*;
import java.util.*;
import javax.naming.*;
import java.sql.Connection;
import java.util.*;

/**
 * Class Demonstrates the use of a Connection Pool
 * Application Server: Weblogic 8.1
 * Database : SQL Server 2005
 * Schema: Master
 * Table: Members
 * Connection Pool Name: SQLServer2000_dbJDBC_connectionPool
 * Data Source Name: SQLServer2000_dbJDBC_dataSourceName
 * Data Source JNDI Name: SQLServer2000_dbJDBC_dataSourceJNDI
 * JNDI Name: SQLServer2000_dbJDBC_JNDI
 *
 * Jar Files Needed: weblogic.jar
 *
 * @author Ankur
 *
 */
public class ConnectionPool_SQLServer {

public static void main(String args[]){
  Connection conn=null;
  Statement stmt=null;
  try {
    Context ctx = null;
    Hashtable ht = new Hashtable();
    ht.put(Context.INITIAL_CONTEXT_FACTORY,"weblogic.jndi.WLInitialContextFactory");
    ht.put(Context.PROVIDER_URL, "t3://localhost:7001");

    //Get a context for JNDI lookup
    ctx = new InitialContext(ht);
    javax.sql.DataSource ds = (javax.sql.DataSource) ctx.lookup("SQLServer2000_dbJDBC_dataSourceJNDI");
    conn = ds.getConnection();

    System.out.println("Connection made...");

    //Execute SQL statements
    stmt = conn.createStatement();
    ResultSet rs = stmt.executeQuery("select * from dbJDBC.dbo.Employees");

      while (rs.next()) {
    		System.out.println("-------------------------------------------");
        	//1st column starts from ONE.
          System.out.println("Employee Number: "+rs.getInt(1));
          System.out.println("Employee Name: "+rs.getString("eName"));
          System.out.println("Employee Email: "+rs.getString("eMail"));
          System.out.println("-------------------------------------------");
      }
 
  }
  catch(Exception e)
  {
    System.out.println("Exception in Connection Pool1.execute()-->"+e);
  }

}
}
