/*
 * This file runs in NetBeans 8.2
 * 
 * Delaney Desmond
 * check recSearch javadoc comment for my findings on how the recSearch class compiles
 */
package search;

/** LinearSearch has two methods, one of which searches through an array iteratively 
 *      and one of which 'searches' through an array recursively. 
 *      (the recursive recSearch throws a StackOverflow Exception).
 * @author Delaney
 */
public class LinearSearch extends SearchAlgorithm{
    
    /**
     * search searches through an unsorted or sorted array to find a certain word.
     * @param words the array that is being searched
     * @param wordToFind the key to find
     * @return the index of the word or throws an exception if not found
     * @throws ItemNotFoundException if the String is not found
     */
    @Override
    public int search(String[] words, String wordToFind) throws ItemNotFoundException {
        int retVal = -1;
        for(int i = 0; i < words.length; i++){ //iteratively going through each word
            if(words[i].equals(wordToFind)){ //checking to see if equal
                return i; //if equal, return index
            }
            super.incrementCount(); //incrementing the count for each comparison
        }
        
        if(retVal == -1){ //if never found, throw ItemNotFoundException
            throw new ItemNotFoundException("Item not found.");
        }
        return retVal;
    }
    
    /**
     * Theoretically, recSearch should do the same thing as search above, but it
     *      actually throws a "StackOverflowError"
     * @param words the array being searched through
     * @param wordToFind the String being searched for
     * @return supposed to return the index of the key
     * @throws ItemNotFoundException if the word isn't found
     */
    @Override
    public int recSearch(String[] words, String wordToFind) throws ItemNotFoundException {
        int retVal = -1;
        if(words[getCount()].equals(wordToFind)) retVal = getCount();
        if(getCount() == words.length-1){
            if(retVal != -1){
                return retVal;
            }
            else{
                throw new ItemNotFoundException("Item not found.");
            }
        }
        return recSearch(words, wordToFind);
    }
    
}
