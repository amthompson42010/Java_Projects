/*
 * CS 350 
 * Project 1
 * Alexander M. Thompson
 * Description: This program in the end should draw a function and graph based on what the user puts in the file.  
 */
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.*;
import javax.swing.JPanel;

public class Curve extends JPanel {
	private int drawingStyle;
	private int numSegments;
	
	public Curve(int style, int segments){
		drawingStyle = style;
		numSegments = segments;
	}
	
	public void paintComponent( Graphics g){
		super.paintComponent( g );
		Graphics2D g2 = (Graphics2D)g;
		
		AffineTransform at = g2.getTransform();
        at.translate(0, getHeight());           /*Sets a new origin*/
        at.scale(1, -1);
        
        g2.setTransform(at);
       
		g.drawLine(60, 100, 60, 500);     /*Draws the y-axis*/
		g.drawLine(60, 300, 750, 300);    /*Draws the x-axis*/
		
		/*Small Lines x-axis*/
		for(int l = (69+69); l < 750; l += 69){
			g.drawLine(l, 310, l, 290);
		}
		g.drawLine(750, 310, 750, 290);
		
		/*Small Line y-axis*/
		g.drawLine(50, 100, 79, 100);
		g.drawLine(50, 200, 79, 200);
		g.drawLine(50, 400, 79, 400);
		g.drawLine(50, 500, 79, 500);
		
		/*Small Lines Labels y-axis*/
		g2.drawString("1.0", 25, 500);
		g2.drawString("5.0", 25, 400);
		g2.drawString("-5.0", 25, 200);
		g2.drawString("-1.0", 25, 100);
	
		
		/*Small Lines Labels x-axis*/
		g2.drawString("0.10", (65+65), 280);
		g2.drawString("0.20", (66*3), 280);
		g2.drawString("0.30", (66*4), 280);
		g2.drawString("0.40", (66*5), 280);
		g2.drawString("0.50", (66*6), 280);
		g2.drawString("0.60", (66*7), 280);
		g2.drawString("0.70", (66*8), 280);
		g2.drawString("0.80", (66*9), 280);
		g2.drawString("0.90", (66*10), 280);
		g2.drawString("1.0", (66*11), 280);
		
		
		double x_length = 1.0/numSegments;
		
		for(double i = 0; i <= 1 - x_length; i+= (1.0/numSegments) ){
			/*Defines the intial x's and y's*/
			double x1 = (i);
			double x2 = (i + 1.0/numSegments);
			double y1;
			double y2;
			switch(drawingStyle){
			case 1:						
				y1 = 1.0 - x1;
				y2 = 1.0 - x2;
				g.drawLine((int)(x1*690+60), (int)(y1*200+300), (int)(x2*690+60), (int)(y2*200+300));
				break;
			case 2:
				y1 = Math.exp(-.25 * x1);
				y2 = Math.exp(-.25 * x2);
				g.drawLine((int)(x1*690+60), (int)(y1*200+300), (int)(x2*690+60), (int)(y2*200+300));
				break;
			case 3:
				y1 = Math.exp(-.5 * x1);
				y2 = Math.exp(-.5 * x2);
				g.drawLine((int)(x1 * 690 + 60), (int)(y1*200+300), (int)(x2*690+60), (int)(y2*200+300));
				break;
			case 4:
				y1 = Math.exp(-.75 * x1);
				y2 = Math.exp(-.75 * x2);
				g.drawLine((int)(x1*690+60), (int)(y1*200+300), (int)(x2*690+60), (int)(y2*200+300));
				break;
			default:
				y1 = Math.exp(-x1);
				y2 = Math.exp(-x2);
				g.drawLine((int)(x1*690+60), (int)(y1*200+300), (int)(x2*690+60), (int)(y2*200+300));
				break;
			}
		}
		
		
	}
}
