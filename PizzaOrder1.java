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
import javax.swing.JComboBox;
import javax.swing.JTextArea;

public class PizzaOrder1 extends JFrame {
  private JComboBox toppings;
  private JPanel centerPanel, northPanel, southPanel, centerPanel2;
  private JLabel size, specialReq;
  private JRadioButton small, medium, large;
  private ButtonGroup sizeGroup;
  private JTextArea specialComment;
  private JButton order, clear, stocking;
  public PizzaOrder1(){
  super("Pizza Order");
  
  String toppingOption[]={"--Select Topping--", "pepperoni","sausage","veggie"};
  toppings= new JComboBox(toppingOption);
  northPanel=new JPanel();
  northPanel.add(toppings);
  add(northPanel, BorderLayout.NORTH);
  
  size= new JLabel("Size");
  small= new JRadioButton("Small");
  medium= new JRadioButton("Medium");
  large=new JRadioButton("Large");
  sizeGroup= new ButtonGroup();
  sizeGroup.add(small);
  sizeGroup.add(medium);
  sizeGroup.add(large);
  centerPanel= new JPanel();
  centerPanel.add(size);
  centerPanel.add(small);
  centerPanel.add(medium);
  centerPanel.add(large);
  add(centerPanel, BorderLayout.CENTER);

 
  specialReq= new JLabel("Special Request:");
  specialComment= new JTextArea(3,12);
  centerPanel2= new JPanel();
  centerPanel2.add(specialReq);
  centerPanel2.add(specialComment);
  centerPanel.add(centerPanel2);
  add(centerPanel, BorderLayout.CENTER);
 
  
  order= new JButton("Order");
  clear= new JButton("Clear");
  stocking= new JButton("Stocking Pizza Dough");
  southPanel=new JPanel();
  southPanel.add(order);
  southPanel.add(clear);
  southPanel.add(stocking);
  add(southPanel, BorderLayout.SOUTH);
  
  setVisible(true);
  setSize(400,200);
  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  setTitle("Pizza Order");
  }
  public static void main(String [] args){
  
  PizzaOrder1 app= new PizzaOrder1();
  }
  
}
