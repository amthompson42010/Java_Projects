/**
* Created by Alexander Mark Thompson
*
* CS 350 -- Project 2 -- New Tetris
*
* Description: Sets up the different blocks for Tetris, including 
*              their shape, color, and points within.
*
*/

import java.awt.Color;
import java.awt.Graphics;

public class CMino {
	
	private int Type;
	private int X;
	private int Y;
	private int Width;
	private int Height;
	private Color FillColor;
	
	public CMino(int type, int x, int y, int w, int h, Color c){
		Type = type;
		X = x;
		Y = y;
		Width = w;
		Height = h;
		FillColor = c;
	}
	
	public CMino(CMino src){
		Type = src.Type;
		X = src.X;
		Y = src.Y;
		Width = 10;
		Height = 10;
		FillColor = src.FillColor;
	}
	
	public int getX(){ return X; }
	public void setX(int x) { X=x;}
	public int getY() { return Y; }
	public void setY(int y) { Y=y; }
	
	public void draw(Graphics g){
		g.setColor(FillColor);
		switch(Type){
		case 0:
			g.fillOval(X, Y, Width, Height);
			g.fillOval(X + Width, Y, Width, Height);
			g.fillOval(X, Y - Height, Width, Height);
			g.fillOval(X + Width, Y - Height, Width, Height);
			break;
		case 1:
			g.fillOval(X, Y, Width, Height);
			g.fillOval(X + Width, Y, Width, Height);
			g.fillOval(X + (2 * Width), Y, Width, Height);
			g.fillOval(X + (3 * Width), Y, Width, Height);
			break;
		case 2:
			g.fillOval(X, Y, Width, Height);
			g.fillOval(X + Width, Y, Width, Height);
			g.fillOval(X + Width, Y - Height, Width, Height);
			g.fillOval(X + (2 * Width), Y, Width, Height);
			break;
		case 3:
			g.fillOval(X, Y, Width, Height);
			g.fillOval(X + Width, Y, Width, Height);
			g.fillOval(X + (2 * Width), Y, Width, Height);
			g.fillOval(X + (2 * Width), Y - Height, Width, Height);
			break;
		case 4:
			g.fillOval(X, Y, Width, Height);
			g.fillOval(X,  Y - Height, Width, Height);
			g.fillOval(X + Width, Y, Width, Height);
			g.fillOval((X + (2 * Width)), Y, Width, Height);
			break;
		case 5:
			g.fillOval(X,  Y, Width, Height);
			g.fillOval(X + Width, Y, Width, Height);
			g.fillOval(X +(2 * Width), Y - Height, Width, Height);
			g.fillOval(X + Width, Y - Height, Width, Height);
			break;
		case 6: 
			g.fillOval(X, Y - Height, Width, Height);
			g.fillOval(X + Width, Y, Width, Height);
			g.fillOval(X + Width, Y - Height, Width, Height);
			g.fillOval(X + (2 * Width), Y, Width, Height);
			break;
		}
	}
	
	public boolean containPoint(int x, int y){
		switch(Type){
		case 0:
		{
			double a = Width / 2.0;
			double b = Height / 2.0;
			double xc = X + a;
			double yc = Y + b;
			return ((x-xc) * (x-xc)/(a * a) + (y - yc) * (y - yc) / (b * b) <= 1.0);
		}
		case 1:
		{
			double a = Width / 2.0;
			double b = Height / 2.0;
			double xc = X + a;
			double yc = Y + b;
			return ((x-xc) * (x-xc)/(a * a) + (y - yc) * (y - yc) / (b * b) <= 1.0);
		}
		case 2:
		{
			double a = Width / 2.0;
			double b = Height / 2.0;
			double xc = X + a;
			double yc = Y + b;
			return ((x-xc) * (x-xc)/(a * a) + (y - yc) * (y - yc) / (b * b) <= 1.0);
		}
		case 3:
		{
			double a = Width / 2.0;
			double b = Height / 2.0;
			double xc = X + a;
			double yc = Y + b;
			return ((x-xc) * (x-xc)/(a * a) + (y - yc) * (y - yc) / (b * b) <= 1.0);
		}
		case 4:
		{
			double a = Width / 2.0;
			double b = Height / 2.0;
			double xc = X + a;
			double yc = Y + b;
			return ((x-xc) * (x-xc)/(a * a) + (y - yc) * (y - yc) / (b * b) <= 1.0);
		}
		case 5:
		{
			double a = Width / 2.0;
			double b = Height / 2.0;
			double xc = X + a;
			double yc = Y + b;
			return ((x-xc) * (x-xc)/(a * a) + (y - yc) * (y - yc) / (b * b) <= 1.0);
		}
		case 6:
		{
			double a = Width / 2.0;
			double b = Height / 2.0;
			double xc = X + a;
			double yc = Y + b;
			return ((x-xc) * (x-xc)/(a * a) + (y - yc) * (y - yc) / (b * b) <= 1.0);
		}
		}
		return false;
	}
}
