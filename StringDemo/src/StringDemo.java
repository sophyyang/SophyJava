/**
 * 
 * @author Sophy
 *
 */

import javax.swing.JOptionPane;
 

public class StringDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 String title = "Clifford's New Kitty";
		 System.out.println( title.toLowerCase());	
		 System.out.println( title.toUpperCase());	
		 String temp = title.substring(0,3);
		 System.out.println(temp.toUpperCase());
		 String temp2 = title.substring(3,6);
		 System.out.println(temp2.toUpperCase());
		 String abc = temp + "---" + temp2;
		 System.out.println(abc);
		 abc = abc.toUpperCase();
		 System.out.println(abc);
		 System.out.println(abc.length());
		 String newTitle = title.replace("f", "*");
		 System.out.println(newTitle);
		 
		 //reads a word and prints whether
		 wordCompareDemo();
				
	}

	public static void wordCompareDemo() {
		String in = JOptionPane.showInputDialog(null, "Please enter any characters: ", "Compare words", JOptionPane.QUESTION_MESSAGE);
 		if (in != null) {
				System.out.println("Your input "+ in + " is not null"); 
				if ( !in.isEmpty()  ) {		
					int inLength = in.length();
					String oddEven;
					if (inLength % 2 == 1 ) {
						oddEven = " Odd number";
					}
					else
					{
						oddEven = " Even number";
					}
					System.out.println("Total characters you enter: " + inLength + " (" + oddEven + ")");
					if (inLength < 5) {
						System.out.println(in + " is short");
					} else if (inLength >=10) {
						System.out.println(in + " is long");		
					}
				
					if (in.substring(inLength-1).equals("y")) {
						System.out.println(in + " end with the latter y");
					}
				
					if (in.substring(0,1).toUpperCase().equals(in.substring(inLength -1).toUpperCase()) ){
						System.out.println(in +" has the same first and last character. (" + in.substring(0,1).toUpperCase() + ","+ in.substring(inLength -1).toUpperCase() +")");
					}
					//compare
					if (in.indexOf(" ") > 0) {
						System.out.println("You enter two words!");
						int index = in.indexOf(" ") +1;
						String w1 = in.substring(0, index );
						String w2 = in.substring(index);
						if (w1.compareTo(w2) < 0 ){
							System.out.println(w1+" < "+w2);
						} else {
							System.out.println(w1+" >= "+w2);
						}
					}
					//middle character
					int midIndex = in.length()/2;
					System.out.println("The middle character of your input is '" + in.charAt(midIndex) + " position(" +  (midIndex + 1)  + ")'.");
					
				} else {
					System.out.println("You did not enter any character!");
				}
 		} else {
 			System.out.println("Your input is null");
 		}
 		
	}
	
	
	
}
