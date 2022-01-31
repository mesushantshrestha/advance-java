import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
public class GasStation1 extends JFrame {
  private JLabel amount, gas, wash, dollar, washAmount;
  private JButton pay, print, clear;
  private JPanel southPanel, centerPanel, northPanel;
  private ImageIcon gasPic, washPic;
  private JTextField amountField;
  private JCheckBox check;
  public GasStation1(){
    super("Gas Station Cashier");
    gasPic= new ImageIcon("gas.gif");
    gas= new JLabel(gasPic);
    northPanel= new JPanel();
    northPanel.add(gas);
    dollar= new JLabel("$");
    northPanel.add(dollar);
    amountField= new JTextField(7);
    northPanel.add(amountField);
    add(northPanel, BorderLayout.NORTH);
    check= new JCheckBox("$10.00");
    centerPanel= new JPanel();
    centerPanel.add(check);
    washPic= new ImageIcon("carwash.gif");
    wash= new JLabel(washPic);
    centerPanel.add(wash);
    
    add(centerPanel, BorderLayout.CENTER);
    pay= new JButton("Pay");
    southPanel= new JPanel();
    southPanel.add(pay);
    print= new JButton("Print Receipt");
    southPanel.add(print);
    clear= new JButton("Clear");
    southPanel.add(clear);
    add(southPanel, BorderLayout.SOUTH);
    
  setVisible(true);
  setSize(400,200);
  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  setTitle("Gas Station Cashier");
  }//end of constructor

  public static void main(String []args){
    GasStation1 app= new GasStation1();
  }//end of main 
}// end of class