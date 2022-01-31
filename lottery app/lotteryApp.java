import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.io.File; //create actual file
import java.io.FileWriter; //write content to file
import java.io.IOException; 
import java.util.Scanner;
import java.io.FileNotFoundException;
public class lotteryApp extends JFrame implements ActionListener{
  private JLabel welcome, logo, megaMillion, powerBall, cash4Life, pickThree, pickFour, bingoo, keno, background
    ,legalAge, playMultiplier, chooseNumbers, cancelReason;
  private JPanel northPanel, westPanel, centerPanel, eastPanel, southPanel, play, legalAgePanel, cancelPanel;
  private ImageIcon lottoLogo, mega, power, cash, pick3, pick4, bingo, kenoLogo, img;
  private JButton help, lock, validation, print, cancel, report, total, pay, random;
  private JRadioButton megaButton, powerButton, cashButton, pick3Button, pick4Button, bingoButton, kenoButton;
  private ButtonGroup lotteryGroup;
  private JComboBox megaCombo, powerCombo, cashCombo, pick3Combo, pick4Combo, bingoCombo, kenoCombo;
  private JFrame frame;
  private JCheckBox playMulti;
  private JTextField numbers;
  private JTextArea customerFeedBack;
  public lotteryApp(){
    super("Lotto App");
    welcome= new JLabel("Welcome to Virginia Lottery"); //North Panel
    welcome.setForeground(Color.WHITE);
    lottoLogo= new ImageIcon("logo.png");
    logo= new JLabel(lottoLogo);
    northPanel= new JPanel();
    northPanel.add(welcome);
    northPanel.add(logo);
    northPanel.setBackground(Color.GRAY);
    add(northPanel, BorderLayout.NORTH);
    
    help= new JButton("Setting"); //west panel
    westPanel= new JPanel();
    westPanel.add(help);
    lock= new JButton("Lock");
    westPanel.add(lock);
    validation= new JButton("Instant Validation");
    westPanel.add(validation);
    print= new JButton("Reprints");
    westPanel.add(print);
    print.addActionListener(this);
    report= new JButton("Report/ Functions");
    westPanel.add(report);
    cancel= new JButton("Cancel Ticket");
    westPanel.add(cancel);
    cancelReason= new JLabel("Cancel Reason");
    cancelPanel= new JPanel();
    cancelPanel.add(cancelReason);
    customerFeedBack= new JTextArea(20,10);
    cancelPanel.add(customerFeedBack);
    cancelPanel.setLayout(new GridLayout(2,1));
    westPanel.add(cancelPanel);
    add(westPanel, BorderLayout.WEST);
    westPanel.setLayout(new GridLayout(8,4)); 
    
    mega= new ImageIcon("mega.png"); //center panel
    megaMillion= new JLabel(mega);
    megaButton= new JRadioButton();
    lotteryGroup= new ButtonGroup();
    lotteryGroup.add(megaButton);
    String megaPrice[]={"2", "4", "6", "10", "20"};
    megaCombo= new JComboBox(megaPrice);
    centerPanel=new JPanel();
    centerPanel.add(megaMillion);
    centerPanel.add(megaButton);
    centerPanel.add(megaCombo);
    
    power= new ImageIcon("power.png");
    powerBall= new JLabel(power);
    powerButton= new JRadioButton();
    lotteryGroup.add(powerButton);
    powerCombo= new JComboBox(megaPrice);
    centerPanel.add(powerBall);
    centerPanel.add(powerButton);
    centerPanel.add(powerCombo);
    
    cash= new ImageIcon("cash.png");
    cash4Life= new JLabel(cash);
    cashButton= new JRadioButton();
    lotteryGroup.add(cashButton);
    cashCombo= new JComboBox(megaPrice);
    centerPanel.add(cash4Life);
    centerPanel.add(cashButton);
    centerPanel.add(cashCombo);
    
    pick3= new ImageIcon("pick3.png");
    pickThree= new JLabel(pick3);
    pick3Button= new JRadioButton();
    lotteryGroup.add(pick3Button);
    String pick []= {"1", "5", "10", "20"};
    pick3Combo= new JComboBox(pick);
    centerPanel.add(pickThree);
    centerPanel.add(pick3Button);
    centerPanel.add(pick3Combo);
    
    pick4= new ImageIcon("pick4.png");
    pickFour= new JLabel(pick4);
    pick4Button= new JRadioButton();
    lotteryGroup.add(pick4Button);
    String pick4Price[]= {"1","5","10","20"};
    pick4Combo= new JComboBox(pick4Price);
    centerPanel.add(pickFour);
    centerPanel.add(pick4Button);
    centerPanel.add(pick4Combo);
    
    bingo= new ImageIcon("bingo.png");
    bingoo= new JLabel(bingo);
    bingoButton= new JRadioButton();
    lotteryGroup.add(bingoButton);
    bingoCombo= new JComboBox(megaPrice);
    centerPanel.add(bingoo);
    centerPanel.add(bingoButton);
    centerPanel.add(bingoCombo);
    
    kenoLogo= new ImageIcon("keno.png");
    keno= new JLabel(kenoLogo);
    kenoButton= new JRadioButton();
    lotteryGroup.add(kenoButton);
    kenoCombo= new JComboBox(megaPrice);
    centerPanel.add(keno);
    centerPanel.add(kenoButton);
    centerPanel.add(kenoCombo);
    playMulti= new JCheckBox();
    play= new JPanel();
    play.add(playMulti);
    
    playMultiplier= new JLabel("Play Multiplier");
    playMultiplier.setForeground(Color.BLUE);
    play.add(playMultiplier);
    centerPanel.add(play);
    add(centerPanel, BorderLayout.CENTER);
    centerPanel.setLayout(new GridLayout(8, 3));
   
    legalAge= new JLabel("Legal Sale Age: 10-08-2002"); // north panel
    legalAge.setForeground(Color.RED);
    legalAgePanel= new JPanel();
    legalAgePanel.setLayout(new BorderLayout());
    legalAgePanel.add(legalAge, BorderLayout.EAST);
    northPanel.add(legalAgePanel);

    eastPanel= new JPanel(); 
    chooseNumbers= new JLabel("Playing Number"); 
    chooseNumbers.setForeground(Color.BLUE);
    eastPanel.add(chooseNumbers);
    numbers= new JTextField(6);
    eastPanel.add(numbers);

    southPanel=new JPanel();
    total= new JButton("Total"); // south panel
    southPanel.add(total);
    total.addActionListener(this);
    pay= new JButton("$Pay");
    southPanel.add(pay);
    pay.addActionListener(this);
    eastPanel.setLayout(new GridLayout(12,1));
    add(eastPanel, BorderLayout.EAST);
    add(southPanel, BorderLayout.SOUTH);
  setVisible(true);
  setSize(760,550);
  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  setTitle("Lotto App");
  
  }
  public void actionPerformed(ActionEvent event){
    if(event.getSource()==total){
      String playingNumber= numbers.getText();
      try{
        if(playingNumber.equals("")){throw new lottery();}
        else if(playingNumber.length()>9){
        throw new lottery("Playing Number more than 8!!!!");}
   
    String checkMultiplier="No";
    String typeLottery="";
    String price="";
    String totalAmount="";
    if(megaButton.isSelected()){
    typeLottery="MegaMillion";
    price= megaCombo.getSelectedItem().toString();
    }else if(powerButton.isSelected()){typeLottery="PowerBall";price= powerCombo.getSelectedItem().toString();}
    else if(cashButton.isSelected()){typeLottery="Cash4Life";price= cashCombo.getSelectedItem().toString();}
    else if(pick3Button.isSelected()){typeLottery="Pick3";price= pick3Combo.getSelectedItem().toString();}
    else if(pick4Button.isSelected()){typeLottery="Pick4";price= pick4Combo.getSelectedItem().toString();}
    else if(bingoButton.isSelected()){typeLottery="Bingo";price= bingoCombo.getSelectedItem().toString();}
    else if(kenoButton.isSelected()){typeLottery="Keno"; price= kenoCombo.getSelectedItem().toString();}
    if(playMulti.isSelected()){
    checkMultiplier="Yes";
    int amount= (Integer.parseInt(price))*2;
    totalAmount=String.valueOf(amount);
    }else{totalAmount=price;}

    String output="Your Lottery Summary:\nLottery Type: "+typeLottery+"\nAmount: $"+
                     totalAmount+"\nPlaying Number: "+playingNumber+"\nPlay Multiplier: "+checkMultiplier;
    JOptionPane.showMessageDialog(null, output);
    String URL= "jdbc:mysql://localhost/lottery?user=root&password=";
    try{
    Class.forName("com.mysql.jdbc.Driver");
    Connection connect= DriverManager.getConnection(URL);
    String sqlStatement= "insert into lotteryInformation values('"+playingNumber+"','"+typeLottery+"','"
      +totalAmount+"','"+checkMultiplier+"');";
    Statement stmt= connect.createStatement();
    stmt.execute(sqlStatement);  // write on the table.
  
    }
    catch(ClassNotFoundException e){
    e.printStackTrace();
    }
    catch(SQLException e){
    System.out.println(e.getMessage());
    }
    File myfile = new File("lottery.txt");
    try{
    FileWriter writer = new FileWriter(myfile, false);// keep adding every time you hit run
    writer.write(output);
    writer.close();
    }
    catch(IOException e){
    System.out.println(e.getMessage());
    
    }
    
      }
      catch(lottery e){JOptionPane.showMessageDialog(null,e.getMessage());}
    }
    else if(event.getSource()==pay){
    System.exit(0);
    
    }
    else if (event.getSource()==print){ //if you press reprint button, it will reprint the receipt.
    File myFile= new File("lottery.txt");
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
 
  public static void main(String []args){
  lotteryApp app= new lotteryApp();
  }
}


