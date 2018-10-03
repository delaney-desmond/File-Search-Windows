/*
 * This file runs in NetBeans 8.2
 * 
 * Delaney Desmond
 */
package search;

/**Class ItemNotFoundException is a custom exception
 * when it is thrown / caught, it means that the item in an array was not found
 *
 * @author Delaney
 */
public class ItemNotFoundException extends Exception{
    /**
     * Constructor that takes a String 
     * @param msg the message that will be outputted to the console
     */
    public ItemNotFoundException(String msg){
        super(msg);
    }
    
    /**
     * no-arg Constructor outputs a default message
     */
    public ItemNotFoundException(){
        super("Item not Found");
    }
}
