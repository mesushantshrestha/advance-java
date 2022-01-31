import java.net.Socket;
import java.net.InetAddress;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.io.ObjectInputStream;
import java.util.Scanner;
public class TCPClient {
  public static void main(String []args){
    System.out.println("Client begins.. ");
    Scanner input= new Scanner(System.in);
    try{
      ServerSocket serverSocket= new ServerSocket(1097,500);
        while(true){ //loop begins
  Socket socket= new Socket(InetAddress.getByName("localhost"), 1098);
  ObjectOutputStream outputStream= new ObjectOutputStream(socket.getOutputStream());
  System.out.print("Client says: ");
  String message= input.nextLine();
  outputStream.writeObject(message); // convert message to a stream of byte
  outputStream.flush(); //sends the output to the server
  System.out.println("Message send successfully...");
  
  socket= serverSocket.accept();
  ObjectInputStream inputStream= new ObjectInputStream(socket.getInputStream());
  String messageFromServer= (String) inputStream.readObject();
  System.out.println("Server says: "+ messageFromServer);
    }//loop ends
    }
    catch(IOException e){
    e.printStackTrace();
    }
    catch(ClassNotFoundException e){
    e.printStackTrace();
    }
  }


}