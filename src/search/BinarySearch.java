/*
 * This file runs in NetBeans 8.2
 * 
 * Delaney Desmond
 */
package search;

/**BinarySearch has two methods that search through a sorted array 
 * search searches iteratively ad recSearch searches recursively
 * @author Delaney
 */
public class BinarySearch extends SearchAlgorithm {
    /**
     * search searches through a sorted array by finding the median String and comparing
     *      it to the String being searched for
     * @param words the array we are searching
     * @param wordToFind the word we are searching for
     * @return the index where the key is found
     * @throws ItemNotFoundException when the key is never found
     */
    @Override
    public int search(String[] words, String wordToFind) throws ItemNotFoundException {
        int highIndex = words.length;
        int lowIndex = 0;
        int midPoint;
        int retVal = -1; 
        boolean go = true;
        while(go){
            midPoint = (highIndex+lowIndex)/2; //finding the midPoint,
            if(words[midPoint].equals(wordToFind)){ //if the midPoint is equal to 
                        //the key, then end the loop and save the index
                retVal = midPoint;
                go = false;
            }else{
                incrementCount(); //incrementing the counter in the parent class
                if(words[midPoint].compareTo(wordToFind) < 0){ //if midpoint came
                        //before wordToFind, changing the lowIndex and finding new 
                        //midPoint
                    lowIndex = midPoint-1;
                    int tmp = midPoint;
                    midPoint = (highIndex+lowIndex)/2;
                    if(tmp == midPoint){
                        break; //if the previous midpoint and the new one are the 
                            //same, then the word cannot be found. break out of
                            //the loop and throw exception
                    }
                    //System.out.println("Count: "+getCount()+" words[midPoint]: "+words[midPoint]+" wordToFind: "+wordToFind+" midpoint: "+midPoint);
                }else if(words[midPoint].compareTo(wordToFind) > 0){ //if midpoint 
                        //came after wordToFind, changing the highIndex and finding
                        //new midpoint
                    highIndex = midPoint+1;
                    int tmp = midPoint;
                    midPoint = (highIndex+lowIndex)/2;
                    if(tmp == midPoint){
                        break;
                    }
                    //System.out.println("Count: "+getCount()+" words[midPoint]: "+words[midPoint]+" wordToFind: "+wordToFind+" midpoint: "+midPoint);

                }
            }
        }
        if(retVal == -1){ //if wordToFind wasn't found, throw exception
            throw new ItemNotFoundException("Item not found");
        }
        return retVal;
    }
    
    /**
     * recSearch calls another recSearch that takes four parameters and finds the key
     * @param words the array we are searching in
     * @param wordToFind the key we are searching for
     * @return the index of the word, if found
     * @throws ItemNotFoundException if the Item is not found
     */
    @Override
    public int recSearch(String[] words, String wordToFind) throws ItemNotFoundException {
        int lowIndex = 0; //creating initial lowIndex and highIndex,
        int highIndex = words.length-1;
        int num = recSearch(words, wordToFind, lowIndex, highIndex); //calling 
            //different recSearch with 4 parameters, to properly recurse
        if(num == -1){ //if -1 is returned, throw exception
            throw new ItemNotFoundException("Item not found");
        }
        
        return num;
        
    }
    
    /**
     * recSearch takes 4 parameters, and finds the index of a String inside an array
     * @param words the array searching in
     * @param wordToFind the key we are looking for
     * @param lowIndex the lower threshold of the section we are comparing the key to
     * @param highIndex the upper threshold of the section we are comparing the key to
     * @return the index of the key, -1(if not found) or recSearch(x,x,x,x)
     */
    public int recSearch(String[] words, String wordToFind, int lowIndex, int highIndex){
        int midPoint = (highIndex+lowIndex)/2; //finds the new midpoint
        super.incrementCount();//increments count
        
        if(words[midPoint].equals(wordToFind)){ //if the midpoint == the key, return midPoint
            return midPoint;
        }else{
            if(words[midPoint].compareTo(wordToFind) < 0){ //else block is basically 
                    //the same as in iterative search above...
                lowIndex = midPoint+1;
                int tmp = midPoint;
                midPoint = (highIndex+lowIndex)/2;
                if(tmp == midPoint) return -1;
            }else if(words[midPoint].compareTo(wordToFind) > 0){
                highIndex = midPoint-1;
                int tmp = midPoint;
                midPoint = (highIndex+lowIndex)/2;
                if(tmp == midPoint) return -1;
            }
        }
        return recSearch(words, wordToFind, lowIndex, highIndex); //recurses until
            //midPoint is equal to wordToFind, then returns midPoint or -1
            //if wordToFind cannot be found.
    }
    
}
