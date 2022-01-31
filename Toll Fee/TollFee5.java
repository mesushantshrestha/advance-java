import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import java.io.File; //create actual file
import java.io.FileWriter; //write content to file
import java.io.IOException; 
import java.util.Scanner;
import java.io.FileNotFoundException;
public class TollFee5 extends JFrame implements ActionListener{
  private JLabel type, car, truck, motorCycle, typeFee;
  private JPanel northPanel, centerPanel, southPanel;
  private JRadioButton carButton, truckButton, motorCycleButton;
  private ImageIcon carImg, truckImg, motorCycleImg;
  private JComboBox feeType;
  private ButtonGroup vehicle;
  private JButton pay, print, clear;
  public TollFee5(){
  super("Toll Fee Cashier System");
  type= new JLabel("Type of Vehicle:");
  northPanel= new JPanel();
  northPanel.add(type);
  
  carButton= new JRadioButton();
  northPanel.add(carButton);
  
  carImg= new ImageIcon("car.gif");
  car= new JLabel(carImg);
  northPanel.add(car);
  
  truckButton= new JRadioButton();
  vehicle= new ButtonGroup();
  northPanel.add(truckButton);
  
  truckImg= new ImageIcon("truck.gif");
  truck= new JLabel(truckImg);
  northPanel.add(truck);
  
  motorCycleButton= new JRadioButton();
  vehicle= new ButtonGroup();
  northPanel.add(motorCycleButton);
  
  motorCycleImg= new ImageIcon("motorcycle.gif");
  motorCycle= new JLabel(motorCycleImg);
  northPanel.add(motorCycle);
  vehicle= new ButtonGroup();
  vehicle.add(carButton);
  vehicle.add(truckButton);
  vehicle.add(motorCycleButton);
  add(northPanel, BorderLayout.NORTH);
  
  typeFee= new JLabel("Type of Fee:");
  centerPanel= new JPanel();
  centerPanel.add(typeFee);
  
  String types[]= {"Regular Tolls", "Peek Weekends"};
  feeType= new JComboBox(types);
  centerPanel.add(feeType);
  add(centerPanel, BorderLayout.CENTER);
  
  pay= new JButton("Pay Fee");
  southPanel= new JPanel();
  southPanel.add(pay);
  pay.addActionListener(this);
  print= new JButton("Print Receipt");
  southPanel.add(print);
  print.addActionListener(this);
  clear= new JButton("Clear");
  southPanel.add(clear);
  clear.addActionListener(this);
  add(southPanel, BorderLayout.SOUTH);
  setVisible(true);
  setSize(500,200);
  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  setTitle("Toll Fee Cashier System");
  }
  public void actionPerformed(ActionEvent event){
    if(event.getSource()==pay){
      try{
        if(!carButton.isSelected()&&!truckButton.isSelected()&&!motorCycleButton.isSelected()){
          throw new vehicleException();
        }
      
      String type="";
      if(carButton.isSelected()){
      type="2 Axels";
      }
      else if(truckButton.isSelected()){
      type="3 or more Axels";
      }
      else if(motorCycleButton.isSelected()){
      type= "Motorcycle";
      }
      String typeFee= feeType.getSelectedItem().toString();;
      String regularFee="";
      if(carButton.isSelected()){
        regularFee="3";
        }else if(truckButton.isSelected()){
        regularFee="4";
        }else if(motorCycleButton.isSelected()){
        regularFee="1";
        }
       String totalFee="";
      if(typeFee=="Regular Tolls"){
        totalFee="$"+regularFee;
        }
      else if(typeFee=="Peek Weekends"){
      int peekFee= (Integer.parseInt(regularFee))+3; //converts string to integer
      String total= String.valueOf(peekFee);// convert back from int to string
      totalFee= "$"+total;
      }
   
      String output= "Toll Receipt: \n"+"Vehicle Type: "+type+"\nFee Type: "+typeFee+"\nFee: "+ totalFee;
      File myFile= new File("receipt.txt");
      try{
      FileWriter writer= new FileWriter(myFile); // writes a file
      writer.write(output);
      writer.close();
      JOptionPane.showMessageDialog(null, output);
      }
      catch(IOException e){

      }
      }// end of try catch of file writer
      catch(vehicleException e){
      JOptionPane.showMessageDialog(null, e.getMessage());
      }// end of catch 
     
    }
    else if(event.getSource()==clear){
    vehicle.clearSelection();
    feeType.setSelectedIndex(0);
  }
    else if(event.getSource()==print){
    File myFile= new File("receipt.txt");
    try{
    Scanner reader= new Scanner(myFile); //reads if pressed print receipt button
    while(reader.hasNextLine()){
    String data = reader.nextLine();
    System.out.println(data);
    }
    reader.close();
    }
    catch(FileNotFoundException e){
    System.out.println(e.getMessage());
    }
    }
    
  }
    
  public static void main(String[]args){
  TollFee5 app= new TollFee5();
  
  }

}