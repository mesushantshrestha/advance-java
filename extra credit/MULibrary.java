import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.net.Socket;
import java.net.InetAddress;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.io.ObjectInputStream;
public class MULibrary extends JFrame implements ActionListener {
  private JLabel isbn, title, welcome, muIcon;
  private JPanel centerPanel, southPanel, northPanel;
  private JTextField isbnArea, titleArea;
  private ImageIcon mu;
  private JButton add, search, searchMU, searchArg;
  
  public MULibrary() {
  super("MU Library");

  welcome= new JLabel("Welcome to Marrymount Library");
  northPanel= new JPanel();
  northPanel.add(welcome);
  add(northPanel, BorderLayout.NORTH);
  
  mu= new ImageIcon("pic.png");
  muIcon= new JLabel(mu);
  northPanel.add(muIcon);
  isbn= new JLabel("ISBN: ");
  centerPanel= new JPanel();
  centerPanel.add(isbn);
  
  isbnArea= new JTextField(20);
  centerPanel.add(isbnArea);
  add(centerPanel, BorderLayout.CENTER);
  
  title= new JLabel("Title: ");
   centerPanel.add(title);
   
  titleArea= new JTextField(20);
  centerPanel.add(titleArea);
  
  add= new JButton("Add New Book");
  southPanel= new JPanel();
  southPanel.add(add);
  add.addActionListener(this);
  
  searchMU= new JButton("Search ISBN- MU Library");
  southPanel.add(searchMU);
  searchMU.addActionListener(this);
  
  searchArg= new JButton("Search ISBN- Arlington Library");
  southPanel.add(searchArg);
  searchArg.addActionListener(this);
  add(southPanel, BorderLayout.SOUTH);

  
  setVisible(true);
  setSize(600,200);
  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  setTitle("MU Library");
  
  } 
  public void actionPerformed(ActionEvent event){
    if(event.getSource()==add){
      String isbnInput= isbnArea.getText();
      String titleInput= titleArea.getText();
      String output= "The following book is successfully added to MU Library."+ "\nISBN: "+isbnInput+"\nTitle: "
        +titleInput;
      JOptionPane.showMessageDialog(null, output);
      String URL= "jdbc:mysql://localhost/mulibrary?user=root&password=";
    try{
    Class.forName("com.mysql.jdbc.Driver");
    Connection connect= DriverManager.getConnection(URL);
    String sqlStatement= "insert into book values('"+isbnInput+"','"+titleInput+"');";
    Statement stmt= connect.createStatement();
    stmt.execute(sqlStatement);  // write on the table.
  
    }
    catch(ClassNotFoundException e){
    e.printStackTrace();
    }
    catch(SQLException e){
    System.out.println(e.getMessage());
    }
      isbnArea.setText("");
      titleArea.setText("");
    }
    else if(event.getSource()==searchMU){
    String isbnNumber= isbnArea.getText();
   String URL= "jdbc:mysql://localhost/mulibrary?user=root&password=";
    try{
    Class.forName("com.mysql.jdbc.Driver");
    Connection connect= DriverManager.getConnection(URL);
    String sqlStatement= "select title from book where isbn="+isbnNumber;
    
    Statement stmt= connect.createStatement();
    ResultSet result= stmt.executeQuery(sqlStatement); //return the result and save it 
    try{
      if(result.next()){
       String outputMessage= "ISBN: "+isbnNumber+"\nTitle: "+ result.getString(1)+"\nAvailable at MU Library";
      JOptionPane.showMessageDialog(null, outputMessage);
      }
    else{
      throw new ISBN(isbnNumber+" is not available at MU Library");
      }
      
    }
      catch(ISBN e){
    JOptionPane.showMessageDialog(null, e);
    }
    }
    catch(ClassNotFoundException e){
    e.printStackTrace();
    }
    catch(SQLException e){
    System.out.println(e.getMessage());
    }
    }
    else if(event.getSource()==searchArg){
    String isbnNumber= isbnArea.getText();
    try{
      ServerSocket serverSocket= new ServerSocket(1097,500);
      while(true){
  Socket socket= new Socket(InetAddress.getByName("localhost"), 1098);
  ObjectOutputStream outputStream= new ObjectOutputStream(socket.getOutputStream());
  
  outputStream.writeObject(isbnNumber); // convert message to a stream of byte
  outputStream.flush(); //sends the output to the server
  
  socket= serverSocket.accept();
  ObjectInputStream inputStream= new ObjectInputStream(socket.getInputStream());
  String messageFromServer= (String) inputStream.readObject();
  JOptionPane.showMessageDialog(null, "ISBN:"+isbnNumber+"\nTitle: "+messageFromServer);
  System.exit(0);
    }
    }
    catch(IOException e){
    e.printStackTrace();
    }
    catch(ClassNotFoundException e){
    e.printStackTrace();
    }
  }
  }
  public static void main(String []args){
  MULibrary app= new MULibrary();
  
  }

}