import java.io.IOException;

/**Ormuco Programming Test Question A
 * The goal for this question is to write a program that accepts two lines (x1, x2) and (x3,x4) 
 * on the x-axis and returns whether they overlap. As an example, (1,5) and (2,6) overlaps but not (1,5) and (6,8).
 * @author: Carolyn Doan
 */

/** Test Cases:
 * 0 0 0 0 // No overlap, wrong format
 * 1 5 2 6 // Overlaps
 * 1 5 5 7 // No overlap
 * 2 6 1 5 // Overlaps
 * 1 5 6 8 // No overlap
 * -1 -5 -6 -7 // No overlap, , wrong format
 * -4 -1 -8 -2 // Overlaps
 * -4 -1 -2 2 // Overlaps
 */
public class Question_A {
	  
	/**For the purpose of this question, we will assume that it is 2 vertical lines on the same y coordinate or 0, 
	   * and the line goes from L1_LowerBound to L1_UpperBound. 
	   * We will also assume that if the end points touch, then that is not an overlap
	   * @param args is the command line arguments 
	   * @param args will contain the two lines, in the form of "Line1_LowerBound Line1_UpperBound Line2_LowerBound Line2_UpperBound" 
	   * A sample input would be 1 2 3 4
	   * The program will print out if the lines overlap or not
	 */
	
	public static void main(String[] args)  {
		if (args.length<4 || args.length>4) // Error checking
		{
			System.err.println("You have entered an invalid input");
			System.exit(1);
		}
		
		int L1_LowerBound, L1_UpperBound, L2_LowerBound, L2_UpperBound; 
		try {
			L1_LowerBound =  Integer.parseInt(args[0]); 
			L1_UpperBound =  Integer.parseInt(args[1]); 
			L2_LowerBound =  Integer.parseInt(args[2]); 
			L2_UpperBound =  Integer.parseInt(args[3]); 
			
			//Checking for points and incorrect argument format
			if (L1_LowerBound >= L1_UpperBound || L2_LowerBound >= L2_UpperBound) 
			{
				System.err.println("You have entered a point or incorrect line format");
				System.exit(1);
			}
			
			// Check if the two lines are the same
			if (L1_LowerBound == L2_LowerBound && L1_UpperBound == L2_UpperBound)
			{
				System.err.println("Lines overlap"); 
				return;
			}
			
			// Checking if the lines are in range of each other
			if ((L1_LowerBound < L2_LowerBound && L2_LowerBound < L1_UpperBound) 
					|| (L1_LowerBound < L2_UpperBound && L2_UpperBound < L1_UpperBound))
			{
				System.err.println("Lines overlap"); 
			}
			else if ((L2_LowerBound < L1_LowerBound && L1_LowerBound < L2_UpperBound) 
					|| (L2_LowerBound < L1_UpperBound && L1_UpperBound < L2_UpperBound)) 
			{
				System.err.println("Lines overlap"); 
			}
			else {
				System.err.println("Lines do not overlap");
			}
				
		}
		catch(NumberFormatException e){
			System.err.println("You have entered an invalid input");
			System.exit(1);
		}
	
	}
		
}
