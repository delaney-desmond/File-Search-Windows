/*
 * This file runs in NetBeans 8.2
 * 
 * Delaney Desmond
 */
package search;
import java.io.File;
/**FindFile searches through a given directory to find a given file
 *
 * @author Delaney
 */
public class FindFile {
    private int maxFiles; 
    private int count = 0;
    private String[] files;
    
    /**
     * Constructor takes one parameter and creates a new String[] array
     * @param maxFiles the maxFiles that can be outputted
     */
    public FindFile(int maxFiles){
        this.maxFiles = maxFiles;
        String[] maxNumOfFiles = new String[maxFiles]; //I set files to have size
            //maxFiles because then I will never have to create a String with a 
            //bigger size, (because once it reaches maxfiles, prgm exits. 
        files = maxNumOfFiles;
    }
    
    /**
     * Recursive directorySearch takes a key and a pathname, then searches for all
     *      instances of the key
     * @param target the file being searched for
     * @param dirName the directory we are searching inside of
     * @throws IllegalArgumentException if directory is invalid, throws this
     * @throws MaxFilesReachedException is maxFiles is reached, throws this
     */
    public void directorySearch(String target, String dirName) throws IllegalArgumentException, MaxFilesReachedException{
        File directory = new File(dirName); //creating a File object of dirName
        
        if(directory.isDirectory()){ //checking to see if dirName is a folder...
            for(File tmp : directory.listFiles()){ //creating a tmp File of the 
                    //first item in directory
                if(tmp.isDirectory()){ //if tmp is a folder, recurse (if that is a word)
                    directorySearch(target, tmp.toString());
                }else{ //if tmp is not a folder, compare key and tmp
                    if(target.equals(tmp.getName())){ //if they are equal...
                        if(getCount() == maxFiles){ //compare count and maxFiles
                            throw new MaxFilesReachedException(); //if equal, throw excep
                        }else{
                            files[getCount()] = tmp.toString();//otherwise, add 
                                //tmp address to files[]
                            count++; //and increment count
                        }
                    }
                }
            }
        }else{ //if it is not a folder, throw IllegalArgumentException
            throw new IllegalArgumentException("This is not a valid pathname.");
        }
          
    }
    
    /**
     * Accessor getCount 
     * @return a copy of count.
     */
    public int getCount(){
        int copy = count;
        return copy;
    }
    
    /**
     * Accessor getFiles
     * @return a copy of files
     */
    public String[] getFiles(){
        String[] copy = new String[files.length];
        System.arraycopy(files, 0, copy, 0, files.length);
        return copy;
    }

    
}
