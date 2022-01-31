public class vehicleException extends Exception{
  public vehicleException (){
  super("VehicleException: Error: Select a type of vehicle!!!");
  }// default constructor
  public vehicleException(String errorMessage){
  super(errorMessage);
  }// overload constructor

}