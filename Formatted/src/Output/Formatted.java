/**
 * Author: Sophy Yang
 * Date: 10/24/2015
 */
package Output;

import java.util.Date;

public class Formatted {

	public static void main(String[] args) {
		String s = String.format("\u0024%,d", 1000000000); //d insert commas and format the number as a decimal integer
		System.out.println (s);
		s = String.format("\u0024%,.2f", 100000.9896384); //\u0024 $ sign
		System.out.println (s);
		s = String.format("%.2f", 100000.9896384); 
		System.out.println (s);
		s = String.format("%,6.1f",42.000); 
		System.out.println (s);
		s = String.format("%.3f",42.00000000); 
		System.out.println (s);
		s = String.format("%x",42); //haxadecimal 42 is 2a
		System.out.println (s);
		s = String.format("%c",42); // number 42 char is *
		System.out.println (s);
		s = String.format("%tc", new Date());		
		System.out.println (s);
		System.out.println(String.format("%tr", new Date()));
		Date today = new Date();
		System.out.println(String.format("%tA, %tB %td", today, today, today));
		System.out.println(String.format("%tA, %<tB %<td", today ));
		System.out.println("//==================================================");

		//==================================================
		System.out.println("\nFormatted Output");
 		System.out.println();
		System.out.printf("%f\n", 1.21997);
		System.out.println("====5====x====5====x");
 		System.out.printf("%20f\n", 1.21997);
 		System.out.println("====5====x====5====x");
 		System.out.printf("%.2f\n", 1.21997);
  		System.out.println("====5====x====5====x");
 		System.out.printf("%s\n", "Hello");
 		System.out.println("====5====x====5====x");
 		System.out.printf("%20s\n", "Hello");
 		System.out.println("====5====x====5====x");
		System.out.printf("%d\n", 24);
  		System.out.println("====5====x====5====x");
 		System.out.printf("%5d\n", 24);
 		System.out.println("====5====x====5====x");
 		System.out.printf("%7.2f\n", 1.21997);
  		System.out.println("====5=7==x====5====x");
 		System.out.printf("Quantity:%5d\n", 24);
 		System.out.println("====5====x====5====x");
 		System.out.printf("%d %.2f\n", 24, 1.245962441314554);
		System.out.println("====5====x====5====x");
		System.out.printf("Price per liter:\t%6.2f\n", 1.245962441314554);
 		System.out.println("====5====x====5====x====5====x");
		System.out.printf("Quantity: %d Total: %10.2f\n", 24, 1.245962441314554);
		System.out.println("====5====x====5====x====5====x");
		 

	}

}
