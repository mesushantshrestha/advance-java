import java.net.ServerSocket;
import java.net.Socket;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.InetAddress;
import java.io.ObjectOutputStream;
import java.util.Scanner;
public class TCPServer {
  public static void main(String []args){
    System.out.println("Server is running...");
    Scanner input= new Scanner(System.in);
    try{
    ServerSocket serverSocket= new ServerSocket(1098, 500);
    while(true){ //loop begins
    Socket socket= serverSocket.accept();
    ObjectInputStream inputStream= new ObjectInputStream(socket.getInputStream());
    String messageFromClient= (String) inputStream.readObject();
    System.out.println("Client Says: "+ messageFromClient);
    
    socket= new Socket(InetAddress.getByName("localhost"), 1097);
    ObjectOutputStream outputStream= new ObjectOutputStream(socket.getOutputStream());
    System.out.print("Server Says: ");
    String messageToClient= input.nextLine();
    outputStream.writeObject(messageToClient);
    outputStream.flush();
    System.out.println("Message send");
    }//loop ends
    }
    catch(IOException e){
    e.printStackTrace();
    }
    catch(ClassNotFoundException e){
    e.printStackTrace();
    }
    System.out.println("Server ended...");
  }
}