import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
public class MUTheater1 extends JFrame{
  private ImageIcon jumanji, badBoys;
  private JLabel jumanjiLabel, badBoysLabel, numberOfTicket;
  private JPanel pic1Panel, pic2Panel, ticketPanel, buttonPanel, boxPanel;
  private JRadioButton jumanjiButton, badBoysButton;
  private JComboBox ticketBox;
  private JButton reserve, cancel;
  private ButtonGroup buttonGroup;
  public MUTheater1 (){
  super("MU Movie Night");
  jumanji= new ImageIcon("poster1.jpg");
  jumanjiLabel= new JLabel(jumanji);
  buttonGroup= new ButtonGroup();
  jumanjiButton= new JRadioButton();
  buttonGroup.add(jumanjiButton);
  pic1Panel= new JPanel();
  pic1Panel.setLayout(new BorderLayout());
  pic1Panel.add(jumanjiLabel, BorderLayout.CENTER);
  pic1Panel.add(jumanjiButton, BorderLayout.SOUTH);
  
 add(pic1Panel, BorderLayout.WEST);
  
  badBoys= new ImageIcon("poster2.jpg");
  badBoysLabel= new JLabel(badBoys);
  pic2Panel= new JPanel();
  badBoysButton= new JRadioButton();
  buttonGroup.add(badBoysButton);
  pic2Panel.setLayout(new BorderLayout());
  pic2Panel.add(badBoysLabel, BorderLayout.CENTER);
  pic2Panel.add(badBoysButton, BorderLayout.SOUTH);
  add(pic2Panel, BorderLayout.EAST);
  
  numberOfTicket= new JLabel("Number Of Ticket(s):$10.00/Ticket ");
  ticketPanel= new JPanel();
  String numTicket []={"0","1","2","3","4","5"};
  ticketBox= new JComboBox(numTicket);
  ticketPanel.add(numberOfTicket);
  ticketPanel.add(ticketBox);
  
  reserve= new JButton("Reserve");
  buttonPanel= new JPanel();
  buttonPanel.add(reserve);
  cancel= new JButton("Cancel");
  buttonPanel.add(cancel);
  boxPanel= new JPanel();
  boxPanel.setLayout(new BorderLayout());
  boxPanel.add(ticketPanel, BorderLayout.NORTH);
  boxPanel.add(buttonPanel, BorderLayout.CENTER);
  add(boxPanel, BorderLayout.SOUTH);
  setVisible(true);
  setSize(550, 550);
  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  setTitle("MU Movie Night");
  
  }// end of constructor
  
  public static void main(String []args){
  MUTheater1 app= new MUTheater1();
  
  }
}// end of public class