/*
 * This file runs in NetBeans 8.2
 * 
 * Delaney Desmond
 */
package search;

/**MaxFilesReachedException is an extra Exception class that I made for FindFile
 * when the maxFiles is reached, throw this exception
 * @author Delaney
 */
public class MaxFilesReachedException extends Exception{
    /**Constructor
     * MaxFilesReachedException prints a String from user to the console
     * @param msg the String that will be printed to the console
     */
    public MaxFilesReachedException(String msg){
        System.out.println(msg);
    }
    
    /**no-arg Constructor
     * MaxFilesReachedException prints a pre-determined String to the console
     */
    public MaxFilesReachedException(){
        System.out.println("Max Files Reached.");
    }
}
