//FIle IO
import java.io.File; //create actual file
import java.io.FileWriter; //write content to file
import java.io.IOException; 
public class WriteToFileExample {
  public static void main(String []args){
  File myfile = new File("data.txt");
  try{
    FileWriter writer = new FileWriter(myfile, true);// keep adding every time you hit run
    writer.write("Hello there \n");
    writer.write("1000");
    writer.write("\nMarymount\n");
    String firstName= "pope";
    writer.write(firstName);
    writer.close();
  }
  catch(IOException e){
    System.out.println(e.getMessage());
    
  }
  }

}