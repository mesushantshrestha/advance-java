import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class GasStation3 extends JFrame implements ActionListener {
  private JLabel amount, gas, wash, dollar, washAmount;
  private JButton pay, print, clear;
  private JPanel southPanel, centerPanel, northPanel;
  private ImageIcon gasPic, washPic;
  private JTextField amountField;
  private JCheckBox check;
  public GasStation3(){
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
    pay.addActionListener(this);
    southPanel= new JPanel();
    southPanel.add(pay);
    print= new JButton("Print Receipt");
    southPanel.add(print);
    clear= new JButton("Clear");
    clear.addActionListener(this);
    southPanel.add(clear);
    add(southPanel, BorderLayout.SOUTH);
    
  setVisible(true);
  setSize(400,200);
  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  setTitle("Gas Station Cashier");
  }//end of constructor

  public void actionPerformed(ActionEvent event){
    if(event.getSource()== pay){
      String gasAmountField= amountField.getText();
      try{
        if(gasAmountField.equals("")){
        throw new amountException();
        }
        String carWash= "No";
        if(check.isSelected()){
          carWash= "Yes";
        }
        JOptionPane.showMessageDialog(null, "Gas Amount: $" + gasAmountField +"\nCar Wash: "+carWash);
      }// end of try
      catch(amountException e){
        JOptionPane.showMessageDialog(null, e.getMessage());
      }//end of catch

      
    }
    else if (event.getSource()== clear){
    amountField.setText("");
    check.setSelected(false);
    }
  
  }
  
  public static void main(String []args){
    GasStation3 app= new GasStation3();
  }//end of main 
}// end of class