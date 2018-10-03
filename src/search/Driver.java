/*
 * This file runs in NetBeans 8.2
 * 
 * Delaney Desmond
 */
package search;


/**This driver includes a main and a test method.
 *the test method makes the code more concise and the results are organized better
 * @author Delaney
 */
public class Driver {
    /**
     * main created instances of tests and tests them using the test method
     * @param args 
     */
    public static void main(String[] args){
        FindFile instancesOverMax = new FindFile(9); //testing what the prgm will
            //do when there are more instances than the max...
        FindFile existsOnce = new FindFile(10);//testing when the file exists once
        FindFile existsMult = new FindFile(10);//testing when the file exists 10xs
        FindFile doesntExist = new FindFile(10);//testing when the file doesn't exist
        FindFile incorrectPathname = new FindFile(12);//testing when the directory is wrong
        
	test(instancesOverMax, "blue.txt", "C:\\Users\\Delaney\\Desktop");
        test(existsOnce, "longwords.txt", "C:\\Users\\Delaney\\Desktop\\CSS 143\\Assignment Work\\DesmondDelaney_Recursion\\Recursion");
        test(existsMult, "blue.txt", "C:\\Users\\Delaney\\Desktop");
        test(doesntExist, "dneiusgbksjrmfiuebrg.txt", "C:\\Users\\Delaney\\Desktop");
        test(incorrectPathname, "blue.text", "notAPathname");
        
    }
    
    /**
     * A short method used to test different instances of FindFile
     * @param ff the instance of FindFile we will be using
     * @param target the key file we are looking for
     * @param pathname the directory we will start with
     */
    public static void test(FindFile ff, String target, String pathname){
        try{
            ff.directorySearch(target, pathname); //calling the recursive func
            String[] array = ff.getFiles(); //getting the array of addresses with the key
            //I assigned the address of the array in the obj to another array
            //so it would be easier for me to read when I was testing.
            
            if(ff.getCount() ==0){ //when the count == 0, that means it wasn't found
                System.out.println("\nFile not found");
            }else{ //if it isn't zero, it was found at elast once...
                System.out.println("\nFound " + ff.getCount() + " instance[s].");
                for(int i = 0; i < ff.getCount(); i++){
                    System.out.println(array[i]); //printing out the array in a
                            //way that is easy to read
                }
            }
        }catch(MaxFilesReachedException e){ //if the maxFiles was reached, catch
                //exception and output the values I got before reaching maxFiles
            System.out.println(e.getMessage()+"\nREACHED MAX NUM OF FILES("+ff.getCount()+"), here are the pathnames we found:\n ");
            String[] array = ff.getFiles();
            for(int i = 0; i < ff.getCount(); i++){
                System.out.println(array[i]);
            }
            System.out.println("Goodbye!");
            //System.exit(0); //this is commented out because otherwise it won't
                //test the rest of my tests
        }catch(IllegalArgumentException b){ 
            System.out.println("Invalid Pathname.");
        }
        
    }
}
