package ticTacToe.gui.util.window;

import java.awt.Graphics;
import ticTacToe.component.AbstractComponent;

public class Table extends AbstractComponent {	
	
	public Table(int x, int y, int widht, int height)
	{
		super();
	}
	
	@Override
	public void paint(Graphics g)
	{	
		if(icon == null)
			return;
		
		int xLeft = position.x;
		int yTop = position.y;
		int width = dimension.width;
		int heigth = dimension.height;
		
		g.drawImage(icon.getImage(), xLeft, yTop, width, heigth, null);	
	}
}