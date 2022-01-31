
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
public class ReadFile{
  public static void main (String[]args){
    File myFile= new File("data.txt");
    try{
    Scanner reader= new Scanner(myFile);
    while(reader.hasNextLine()){
    String data= reader.nextLine();
    System.out.println(data);
    }
    reader.close();
    }
    catch(FileNotFoundException e){
    System.out.println(e.getMessage());
    }
  }

}