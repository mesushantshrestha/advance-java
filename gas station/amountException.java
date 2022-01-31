public class amountException extends Exception{
  public amountException (){
  super("Error: Amount is required!!!");
  }// default constructor
  public amountException(String errorMessage){
  super(errorMessage);
  }// overload constructor

}