import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
public class databaseExample2 {
  public static void main (String []args){
    String URL= "jdbc:mysql://localhost/it230?user=root&password=";
    try{
    Class.forName("com.mysql.jdbc.Driver");
    System.out.println("JDBC connected successfully");
    
    Connection connect= DriverManager.getConnection(URL);
    System.out.println("MySql connected successfully");
    
    String sqlStatement= "select * from student";
    System.out.println(sqlStatement);
    
    Statement stmt= connect.createStatement();
    ResultSet result= stmt.executeQuery(sqlStatement); //return the result and save it 
    
    while(result.next()){
      System.out.println(result.getString(1)+ " "+ result.getString(2));
    
    }
    }
    catch(ClassNotFoundException e){
    e.printStackTrace();
    }
    catch(SQLException e){
    System.out.println(e.getMessage());
    }
}
  
  }