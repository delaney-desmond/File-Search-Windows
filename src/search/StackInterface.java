/*
 * This program runs in NetBeans IDE version 8.2
 * @author Delaney Desmond
 * 
 */
package search;

import java.util.Arrays;

/**
 * This class holds all the required methods outlined in the homework prompt
 * tested in ArrayBasedDataStructures.java
 */
public class StackInterface {
    private Object[] array = new Object[10];
    private int size = 0;
    
    
    /**
     * push pushes an Object to the top of the stack/ the end of the array
     * @param obj the Object being pushed into the array
     */
    public void push(Object obj){
        if(size == array.length){ //if there isn't sufficient room in the array, then it makes a deep copy with double the length
            Object[] copyArray = new Object[(array.length*2)];
            
            for(int i = 0; i < size; i++){
                copyArray[i] = array[i];
            }
            array = copyArray;
        }
        array[size] = obj; //assigning the Object to the last available index
        ++size;//incrementing size
    }
    
    /**
     * pop returns/removes the last Object and decrements the accumulator
     * @return the Object that was removed
     */
    public Object pop(){
        if(size == 0){ //Array has no Object to return, inform the user
            System.out.println("Array is empty.");
        }
        Object returned = array[size-1]; //returns the last array inputted, which is the element at the previous index in relation to size
        array[size] = null; //assigning th ecell to hold null
         
        --size; //decrementing size
        if(array.length >= (size*4)){ //if the size of the array is four times the int in size...
            Object[] newArray = new Object[(array.length/2)]; //create a new array with half the size, copy all elements into it..
            
            for(int index = 0; index < size; index++){
                newArray[index] = array[index];
            }
            array = newArray; //then change the original array to reference the copied array
        }
        
        return returned;
    }
    
    /**
     * Accessor that returns a copy of the accumulator size
     * @return returns a copy of size to avoid a privacy leak
     */
    public int size(){
        int copy = size;
        return copy;
    }
    
    /**
     * toString returns the elements in the array backwards, like a Stack Object would.
     * @return the elements backwards
     */
    @Override
    public String toString(){
        String returned = array[size-1]+", ";
        for(int i = size-2; i >= 0; i--){
            returned = returned + array[i]+", ";
        }
        return returned;
    }
    
    /**
     * if this array is empty...
     * @return true, else return false
     */
    public boolean isEmpty(){
        if(size == 0){
            return true;
        }else{
            return false;
        }
    }
    
    /**
     * equals compares the arrays in two objects to determine if they are equal (the code for equals in this class is the same as in ALI and QI)
     * (Except for the type StackInterface)
     * @param obj the other object that this.array will be tested against
     * @return a boolean stating whether they are equal or not
     */
    @Override
    public boolean equals(Object obj){
        if(obj == null || !(obj instanceof StackInterface)) return false;
        StackInterface that = (StackInterface) obj;
        if(Arrays.equals(array, that.array)){
            return true;
        }else{
            return false;
        }
    }
    
}
