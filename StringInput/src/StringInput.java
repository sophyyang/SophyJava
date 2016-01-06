
/**
 * 
 * @author Sophy
 * Date: 2015-10-28
 * String Input
 */

/*
 * charAt
 * length
 * substring
 * 
 * next nextDouble nextInt //java.util.Scanner
 * 
 */
import java.util.Scanner;

import javax.swing.JOptionPane;

public class StringInput {

	public static void main(String[] args) {
		//*echo user input first and last name
		//PrintMyName();
		/*
		 * Escape Sequences
		 */
		EscapeSequences();
//		//Pop-Up windows		
//		PopUpWindow();
//		//Multiple If Statement
//		MultipleIf();
//		//Multiple Decision Revisited
		MultipleDecision(); 
	}
	
	  static void PrintMyName() {
		Scanner in = new Scanner(System.in);
		String promptN = "Please enter your first and last name: ";
		
		System.out.print(promptN);
		String firstN = in.next(); //only read one word first name
		String lastN = in.next();  //need another in.next() to read last name
		
		System.out.println(firstN + " " + lastN);
		
		in.close();	
		//charAT
		System.out.println("The third character of the first name is " + firstN.charAt(2));
		System.out.println("The last character of the last name is " + lastN.charAt(lastN.length()-1));
		//substring (index, position)
		System.out.println("Substring( 1, " + firstN.length() + ") " +firstN.substring(1,firstN.length()));
		//Start from x to the end
		int index = lastN.length() - 3;
		System.out.println("Substring(" + index + ") " + lastN.substring(index));
		
		char start = lastN.charAt(0);		
		System.out.println(java.lang.Character.toUpperCase(start));
		String x = firstN;
		System.out.println(x.substring(0,1).toUpperCase() + x.substring(1));
		 

	}
	
	  static void EscapeSequences() {
		/*
		 * Escape Sequences
		 * backslash \
		 * newline character \n
		 * Tab \t
		 * Return \r
		 * $ \u0024
		 */
		
	}
	
	  static void PopUpWindow() {
		String input = JOptionPane.showInputDialog("Enter Your First Name and Last Name: ");
		int mySpace = input.indexOf(" ");
		System.out.println(mySpace);
		String output = input.substring(0, 1).toUpperCase();
		output += input.substring(1,mySpace);
		output += " ";
		output +=  input.substring(mySpace + 1,mySpace +2).toUpperCase();
		output += input.substring(mySpace + 2);
		System.out.println(output);
		JOptionPane.showMessageDialog(null, "My Name is " + output, "Welcome", JOptionPane.PLAIN_MESSAGE);
	}
	
	  static void MultipleIf() {
		Scanner in = new Scanner(System.in);
		String promptN = "Please enter a number: ";
		boolean again= false;
		
 		while (!again) {
			int total = 0;
			System.out.println(promptN);
			int n = in.nextInt();
			if (n > 10) {
				System.out.print("*****");
				total += "*****".length();
			}

			if (n > 7) { 
				System.out.print("****"); 
				total +=  "****".length();
			}

			if (n > 4) { 
				System.out.print("***");
				total +=  "***".length();
			}

			if (n > 1) { 
		       System.out.print("**");
				total +=  "**".length();
 			}

			System.out.println("*");
			total += "*".length();
			System.out.println("Total " + total + " *");
			
			int yesNo = JOptionPane.showConfirmDialog(null, promptN);
			System.out.println(yesNo);
			if (yesNo == 1) { //0=Yes, 1=NO, 2=Cancel
				again = true;
			}
		}	
		in.close();
	}

	  static void MultipleDecision() {
		Scanner in = new Scanner(System.in);
		String promptN = "Please enter a number: ";
		boolean again= true;
		
 		while (again) {
			int total = 0;
			System.out.println(promptN);
			int n = in.nextInt();
			if (n > 10) {
				System.out.print("*****");
				total += "*****".length();
			}

			else if (n > 7) { 
				System.out.print("****"); 
				total +=  "****".length();
			}

			else if (n > 4) { 
				System.out.print("***");
				total +=  "***".length();
			}

			else if (n > 1) { 
		       System.out.print("**");
				total +=  "**".length();
 			}

			System.out.println("*");
			total += "*".length();
			System.out.println("Total " + total + " *");
			
			int yesNo = JOptionPane.showConfirmDialog(null, promptN);
			System.out.println("Your ans is " + yesNo);
			
			if (yesNo != 0) { //0=Yes, 1=NO, 2=Cancel
				again = false;				
			}
		}	
		in.close();
	}

}
