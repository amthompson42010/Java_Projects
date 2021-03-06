/**
* Created by Alexander Mark Thompson
*
* CS 350 -- Project 2 -- New Tetris
*
* Description: Sets up the Mouse Events and Listeners, and draws 
*              the window.
*
*/

import java.awt.Color;
import java.awt.Image;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.*;

import java.util.*;

public class CTetriMino extends JPanel
	implements MouseListener, MouseMotionListener
{
	private ArrayList<CMino> originals;
	private ArrayList<CMino> duplicates;
	
	private CMino MinoToBeMoved;
	private int m_nOffsetX;
	private int m_nOffsetY;
	
	private Image backBuffer;
	private Graphics gBackBuffer;
	
	boolean isInitialized;
	
	public CTetriMino(){
		isInitialized = false;
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
	}
	
	void init(){
		duplicates = new ArrayList<CMino>();
		originals = new ArrayList<CMino>();
		Color[] colors = {Color.red, Color.green, Color.blue, Color.magenta, Color.cyan, Color.yellow, Color.black};
		int count = colors.length;
		int dx = 10;
		int dy = 40;
		int gap = 20;
		int length = 30;
		for (int i = 0; i < count; i++){
			originals.add(new CMino((i<count/2)?0:1, dx+i*(length+gap), dy, length, length, colors[i]));
		}
		MinoToBeMoved = null;
		
		backBuffer = createImage(getSize().width, getSize().height);
		gBackBuffer = backBuffer.getGraphics();
	}
	
	public void paintComponent( Graphics g){
		if (!isInitialized){
			isInitialized = true;
			init();
		}
		
		gBackBuffer.setColor(Color.white);
		gBackBuffer.clearRect(0, 0, getSize().width, getSize().height);
		
		for (int i = 0; i < originals.size(); i++){
			originals.get(i).draw(gBackBuffer);
		}
		
		for(int i = 0; i<duplicates.size(); i++){
			duplicates.get(i).draw(gBackBuffer);
		}
		
		g.drawImage(backBuffer, 0, 0, null);
	}
	
	public void mouseClicked(MouseEvent e){
		if(e.isMetaDown()){
			for(int i = duplicates.size()-1; i>=0; i++){
				if(duplicates.get(i).containPoint(e.getX(), e.getY())){
					duplicates.remove(i);
					repaint();
					break;
				}
			}
		}
	}
	
	public void mousePressed(MouseEvent e){
		if(e.isMetaDown()) return;
		
		// First, check the originals, from top down (i.e. back to front)
				for (int i=duplicates.size()-1; i>=0; i--) {
					CMino p=duplicates.get(i);
					if (p.containPoint(e.getX(), e.getY())) {
						duplicates.remove(i);
						duplicates.add(p);	// move to the end, i.e. the top
						MinoToBeMoved=p;
						m_nOffsetX=e.getX()-MinoToBeMoved.getX();
						m_nOffsetY=e.getY()-MinoToBeMoved.getY();
						repaint();
						return;
					}
				}
				// Second, check the orginals 
				for (int i=originals.size()-1; i>=0; i--) {
					CMino p=originals.get(i);
					if (p.containPoint(e.getX(), e.getY())) {
						CMino p2=new CMino(p); // make a copy of p
						duplicates.add(p2);	// add to the end
						MinoToBeMoved=p2;	// p2 is selected, to be moved
						m_nOffsetX=e.getX()-MinoToBeMoved.getX();
						m_nOffsetY=e.getY()-MinoToBeMoved.getY();
						repaint();
						return;
					}
				}
		    }

		    public void mouseReleased( MouseEvent e )
		    {
				MinoToBeMoved=null; // no shape selected
		   }

		    public void mouseEntered( MouseEvent e )
		    {
		    }

		    public void mouseExited( MouseEvent e )
		    {
		    }

		    public void mouseMoved( MouseEvent e )
		    {
		    }
		    
		    public void mouseDragged( MouseEvent e )
		    {
		        if (e.isMetaDown()) return;	// ignore right button
		    	
				if (MinoToBeMoved!=null) {
					MinoToBeMoved.setX(e.getX()-m_nOffsetX);
					MinoToBeMoved.setY(e.getY()-m_nOffsetY);
					repaint();
				}

		    } // end method mouseDragged
	}

