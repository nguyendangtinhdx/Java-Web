package exception;

public class InvalidInput extends Exception {
    public InvalidInput(String d){  
        super(d);   // gọi non - parameter constructor của Exception để throws ra message trong exception 
       }  
}
