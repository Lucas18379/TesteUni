package Util;

// design pattern Singleton

import java.io.RandomAccessFile;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import static javax.management.remote.JMXConnectorFactory.connect;


public class Banco 
{
    static private Conexao con;
    static public Conexao getCon(){ return con;}

    private Banco() {
    }
    
    static public boolean conectar()
    {
       con=new Conexao();
       return con.conectar("jdbc:postgresql://localhost/","conveniencia","postgres","postgres123");
    }  
    public static boolean criarBD(String BD)
    { try{
        Class.forName("org.postgresql.Driver");
        String url = "jdbc:postgresql://localhost/";
        Connection con = DriverManager.getConnection(url,"postgres","postgres123");

        Statement statement = con.createStatement();
        statement.execute("CREATE DATABASE " +BD+" WITH OWNER = postgres ENCODING = 'UTF8' TABLESPACE = pg_default CONNECTION LIMIT = -1;");
        statement.close();
        con.close();
      }catch(Exception e)
      {  System.out.println(e.getMessage()); return false;}
         return true;                
    }
     public static boolean deletaBD(String BD)
    { try{
        Class.forName("org.postgresql.Driver");
        String url = "jdbc:postgresql://localhost/";
        Connection con = DriverManager.getConnection(url,"postgres","postgres123");

        Statement statement = con.createStatement();
        statement.execute("SELECT * FROM pg_stat_activity WHERE datname = '"+BD+"';");
        statement.execute("SELECT pg_terminate_backend (pg_stat_activity.pid) FROM pg_stat_activity WHERE pg_stat_activity.datname = '"+BD+"';");
        statement.execute("DROP DATABASE "+BD+";");
        statement.close();
        con.close();
      }catch(Exception e)
      {  System.out.println(e.getMessage()); return false;}
         return true;                
    }
    
    
    public static boolean criarTabelas(String script,String BD)
    { try{
        Class.forName("org.postgresql.Driver");
        String url = "jdbc:postgresql://localhost/"+BD;
        Connection con = DriverManager.getConnection(url, "postgres","postgres123");

        Statement statement = con.createStatement();
        RandomAccessFile arq=new RandomAccessFile(script, "r");
        while(arq.getFilePointer() < arq.length()) 
             statement.addBatch(arq.readLine());
        statement.executeBatch();

        statement.close();
        con.close();
      }
    catch(Exception e)
      {  System.out.println(e.getMessage()); 
      return false;
      }

      return true;
    }

}
