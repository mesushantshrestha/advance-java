import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class DeliveryService3 extends JFrame implements ActionListener{
  private JLabel weight, typeOfDelivery;
  private JTextField enterWeight;
  private JPanel northPanel, centerPanel, southPanel;
  private JRadioButton local, longDistance;
  private ButtonGroup deliveryGroup;
  private JCheckBox insurance;
  private JButton goButton, resetButton;
  
  public DeliveryService3(){
  super("Delivery Service");
  
  weight= new JLabel("Enter weight in pounds");
  enterWeight= new JTextField(7);
  northPanel= new JPanel();
  northPanel.add(weight);
  northPanel.add(enterWeight);
  add(northPanel, BorderLayout.NORTH);
  
  typeOfDelivery= new JLabel("Type of Delivery:");
  local= new JRadioButton("Local");
  longDistance= new JRadioButton("Long Distance");
  deliveryGroup= new ButtonGroup();
  deliveryGroup.add(local);
  deliveryGroup.add(longDistance);
  centerPanel= new JPanel();
  centerPanel.add(typeOfDelivery);
  centerPanel.add(local);
  centerPanel.add(longDistance);
  add(centerPanel, BorderLayout.CENTER);
  centerPanel.setLayout(new GridLayout(0,3));
  
  insurance= new JCheckBox("Insurance");
  centerPanel.add(insurance);
  add(centerPanel, BorderLayout.CENTER);
  
  goButton= new JButton("Go");
  goButton.addActionListener(this);
  resetButton= new JButton("Reset");
  resetButton.addActionListener(this);
  southPanel= new JPanel();
  southPanel.add(goButton);
  southPanel.add(resetButton);
  add(southPanel, BorderLayout.SOUTH);
  
  setVisible(true);
  setSize(400,200);
  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  setTitle("Delivery Service");
  }
  
  public void actionPerformed(ActionEvent event){
    if(event.getSource() == goButton){
      String weight= enterWeight.getText();
      String checkInsurance= "No";
      if(insurance.isSelected()){
        checkInsurance="Yes";
      }
      String deliveryType= "";
      if(local.isSelected()){
      deliveryType="Local";
      }else if(longDistance.isSelected()){
        deliveryType="Long Distance";
      }
      String outputMessage= "Delivery Information" +"\nWeight: "+weight+"\nType of Delivery: "+deliveryType+
                             "\nInsurace: "+checkInsurance
                              +"\nPrice: "+ priceCalculator(weight);
      
    JOptionPane.showMessageDialog(null, outputMessage);
    }
    else if(event.getSource() ==resetButton){
    enterWeight.setText("");
    deliveryGroup.clearSelection();
    insurance.setSelected(false);

    //put clear items 
    
    }
    
  }//end of the action performed
  public String priceCalculator(String weight){
  //String weight1= enterWeight.getText();
  double price= Double.parseDouble(weight);
  String priceCalc="0";
  if(local.isSelected() && price<5){
    priceCalc="5.75";
  }else if(local.isSelected() && price>=5 && price<20){
    priceCalc= "10.75";
  }else if(local.isSelected() && price>=20){
    priceCalc= "20.75";
  }else if(longDistance.isSelected()&& price<5){
    priceCalc="35.75";
  }else if(longDistance.isSelected() &&price>=5){
    priceCalc="47.75";
  }
  if(insurance.isSelected()){
    double insuranceAdd= (Double.parseDouble(priceCalc))+4.0;
    priceCalc= String.valueOf(insuranceAdd);
  }
  return "$"+priceCalc;
  }//end of price calculator
  
  public static void main(String[]args){
  DeliveryService3 app= new DeliveryService3();
  }
  
  
}
