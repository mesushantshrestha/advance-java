import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class databaseExample1 {
  public static void main (String []args){
    String URL= "jdbc:mysql://localhost/it230?user=root&password=";
    try{
    Class.forName("com.mysql.jdbc.Driver");
    System.out.println("JDBC connected successfully");
    
    Connection connect= DriverManager.getConnection(URL);
    System.out.println("MySql connected successfully");
    
    String sqlStatement= "insert into student values ('883', 'Papu', 'B', 4, 500.00)";
    
    Statement stmt= connect.createStatement();
    stmt.execute(sqlStatement);
    System.out.println("Executed sucessfully");
    }
    catch(ClassNotFoundException e){
    e.printStackTrace();
    }
    catch(SQLException e){
    System.out.println(e.getMessage());
    }
}
  
  }