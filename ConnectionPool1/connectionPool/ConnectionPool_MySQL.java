package connectionPool;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;

public class ConnectionPool_MySQL {

public static void main(String args[]){
  Connection conn=null;
  Statement stmt=null;
  try {
    Context ctx = null;
    Hashtable ht = new Hashtable();
    ht.put(Context.INITIAL_CONTEXT_FACTORY,"weblogic.jndi.WLInitialContextFactory");
    ht.put(Context.SECURITY_PRINCIPAL, "weblogic");
    ht.put(Context.SECURITY_CREDENTIALS, "weblogic1");
    ht.put(Context.PROVIDER_URL, "t3://localhost:7001");

    //Get a context for JNDI lookup
    ctx = new InitialContext(ht);
    javax.sql.DataSource ds = (javax.sql.DataSource) ctx.lookup("weblogic_ds_jndi_name");
    conn = ds.getConnection();

    System.out.println("Connection made...");

    //Execute SQL statements
    stmt = conn.createStatement();
    ResultSet rs = stmt.executeQuery("select * from dbJDBC.employees");

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
