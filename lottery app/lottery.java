public class lottery extends Exception{
  public lottery (){
  super("Error!!! Please select the playing number");
  }// default constructor
  public lottery(String errorMessage){
  super(errorMessage);
  }// overload constructor

}