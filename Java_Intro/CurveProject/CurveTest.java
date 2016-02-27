/*
 * CS 350 
 * Project 1
 * Alexander M. Thompson
 * Description: This program in the end should draw a function and graph based on what the user puts in the file.  
 */

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JFrame;


public class CurveTest{

		public static void main(String[] args)
		{
			int style = 0;
			int segments = 0;
			Scanner input;
			  try {
				  input=new Scanner(new File("curve.txt"));
				  style = input.nextInt();
				  segments = input.nextInt();
				  input.close();
			  }
			  catch (IOException e) {
				   System.err.println(e);
				   System.exit(1);
			  }
			  Curve panel = new Curve(style, segments);
		      
		      JFrame application = new JFrame("Curve"); /*creates a new JFrame*/

		      application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		      application.add( panel ); /* add the panel to the frame*/
		      application.setSize( 920, 560 ); /* set the desired size*/
		      application.setVisible( true ); /* show the frame*/
		}
}

