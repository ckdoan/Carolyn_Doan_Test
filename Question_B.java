import java.util.Scanner;

/**Ormuco Programming Test Question B
 * The goal of this question is to write a software library that accepts 2 version string as input and returns whether one is greater than, 
 * equal, or less than the other. As an example: “1.2” is greater than “1.1”. Please provide all test cases you could think of.
 * @author: Carolyn Doan
 */


/** Test Cases:
 * 1.2 1.1  // returns -1
 * 1.1 1.1.1  // returns -1
 * 3.0 2.9.9  // returns 1
 * 1.1 1.1  // returns 0 
 */

public class Question_B {
	
	/**This method compares two version strings
	   * @param vers1 is the version1 string
	   * @param vers2 is the version2 string 
	   * @return 0 if the two versions are equal
	   * @return -1 if version1 is less than version2
	   * @return 1 if version1 is greater than version2
	 */
	public static int versionCompare(String vers1 , String vers2) {
		 String[] vers1Parts = vers1.split("\\.");
	     String[] vers2Parts = vers2.split("\\.");
	     
	     int length = Math.max(vers1Parts.length, vers2Parts.length);
	     for(int i = 0; i < length; i++) {
	    	int temp1=0, temp2=0; 
	    	
	    	if ( i < vers1Parts.length) {
	    		temp1 = Integer.parseInt(vers1Parts[i]);
	    	}
	    	else {
	    		temp1 = 0;
	    	}
	    	
	    	if ( i < vers2Parts.length) {
	    		temp2 = Integer.parseInt(vers2Parts[i]);
	    	}
	    	else {
	    		temp2 = 0; 
	    	}
	    	
	        if(temp1 < temp2) {
	            return -1;
	        }
	        if(temp1 > temp2) {
	            return 1;
	        }
	     }
	     return 0;
	}
	
	/**
	   * @param args is the command line arguments 
	   * @param args will contain the two versions in the form of "version1 version2" 
	   * A sample input would be 1.1 1.1.1
	   * The program will print out the two versions and the comparison results. 
	   		* 0 if the two versions are equal
	   		*-1 if version1 is less than version2
	   		* 1 if version1 is greater than version2	 
	 */
	public static void main(String[] args)  {
		if (args.length<2 || args.length>2) // Error checking
		{
			System.err.println("You have entered an invalid input");
			System.exit(1);
		}
		
		String version1, version2; 
		version1 = args[0];
		version2 = args[1];
		
		if(!version1.matches("[0-9]+(\\.[0-9]+)*") || !version2.matches("[0-9]+(\\.[0-9]+)*") ) {
			throw new IllegalArgumentException("Invalid version format");
		}
	         
		System.out.println("Version 1: " + version1);
		System.out.println("Version 2: " + version2);
		
		int result = versionCompare(version1, version2);
		System.out.println("Comparison Result: " + result);
		
	}
}
