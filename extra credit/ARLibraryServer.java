import java.net.ServerSocket;
import java.net.Socket;
import java.io.IOException; 
import java.io.ObjectInputStream;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
public class ARLibraryServer{
 public static void main(String []args){
    System.out.println("Arlington Server is running...");
    try{
    ServerSocket serverSocket= new ServerSocket(1098, 500);
    while(true){ //loop begins
    Socket socket= serverSocket.accept();
    ObjectInputStream inputStream= new ObjectInputStream(socket.getInputStream()); //server waiting for the client
    String requestFromClient= (String) inputStream.readObject();
   // System.out.println(requestFromClient);
    String URL= "jdbc:mysql://localhost/arlibrary?user=root&password=";
    try{
    Class.forName("com.mysql.jdbc.Driver");
    System.out.println("JDBC connected successfully");
    
    Connection connect= DriverManager.getConnection(URL);
    System.out.println("MySql connected successfully");
    
    String sqlStatement= "select title from book where isbn="+requestFromClient;
    
    Statement stmt= connect.createStatement();
    ResultSet result= stmt.executeQuery(sqlStatement); //return the result and save it 
    
 
    if(result.next()){
    socket= new Socket(InetAddress.getByName("localhost"), 1097);
    ObjectOutputStream outputStream= new ObjectOutputStream(socket.getOutputStream());
    //System.out.print("Server Says: ");
    String messageToClient= result.getString(1);
    outputStream.writeObject(messageToClient);
    outputStream.flush();
    }
    else{
    socket= new Socket(InetAddress.getByName("localhost"), 1097);
    ObjectOutputStream outputStream= new ObjectOutputStream(socket.getOutputStream());
    String noAvailable= requestFromClient+" is not available at Arglinton Library";
    outputStream.writeObject(noAvailable);
    outputStream.flush();
    }
    
    }// end of sql catch

    catch(ClassNotFoundException e){
    e.printStackTrace();
    }
    
    catch(SQLException e){
    System.out.println(e.getMessage());
    }
    }//end of loop
    }// end of io catch
    catch(ClassNotFoundException e){e.printStackTrace();}
    catch(IOException e){
    e.printStackTrace();
    }
 }//end public void
}// end of public
