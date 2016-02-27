/**
* Created by Alexander Mark Thompson
*
* CS 350 -- Project 2 -- New Tetris
*
* Description: Sets up everything and runs the program.
*
*/

import javax.swing.JFrame;

public class MinoTest {
	public static void main( String[] args){
		JFrame application = new JFrame("New Tetris");
		
		CTetriMino ctetrimino = new CTetriMino();
		application.add(ctetrimino);
		
		application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		application.setSize(800, 1000);
		application.setVisible(true);
	}
}
