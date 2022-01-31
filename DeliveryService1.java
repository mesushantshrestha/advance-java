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

public class DeliveryService1 extends JFrame {
  private JLabel weight, typeOfDelivery;
  private JTextField enterWeight;
  private JPanel northPanel, centerPanel, southPanel;
  private JRadioButton local, longDistance;
  private ButtonGroup deliveryGroup;
  private JCheckBox insurance;
  private JButton goButton, resetButton;
  
  public DeliveryService1(){
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
  resetButton= new JButton("Reset");
  southPanel= new JPanel();
  southPanel.add(goButton);
  southPanel.add(resetButton);
  add(southPanel, BorderLayout.SOUTH);
  
  setVisible(true);
  setSize(400,200);
  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  setTitle("Delivery Service");
  }
  
  public static void main(String[]args){
  DeliveryService1 app= new DeliveryService1();
  }
  
  
}
