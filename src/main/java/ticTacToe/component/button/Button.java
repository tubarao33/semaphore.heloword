package ticTacToe.component.button;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.HashSet;
import java.util.Set;

import ticTacToe.component.AbstractComponent;
import ticTacToe.component.button.Button.ButtonClickEvent.MouseButton;

public class Button extends AbstractComponent {
	
	public Button(int x, int y, int height, int width) 
	{
		super(x, y, height, width);
	}
	
	private void doMouseOverDecoration(Graphics g) 
	{
		Color color = g.getColor();
		g.setColor(Color.RED);
	    g.drawRect(position.x + 4, position.y + 4, dimension.width - 8, dimension.height - 8);
	    g.setColor(color);
	}
	
	public final class ButtonClickEvent {
		
		public static enum MouseButton{LEFT, MIDLE, RIGHT};
		
		public final Button source;
		public final MouseButton mouseButton;
		
		public ButtonClickEvent(Button source, MouseButton mouseButton) 
		{
			this.source = source;
			this.mouseButton = mouseButton;
		}
	}
	
	@Override
	protected void onMouseClick(MouseEvent me) 
	{
		dispatchButtonClickEvent(me);
	}
	
	@FunctionalInterface
	public interface ButtonClickListener
	{
		void onClick(ButtonClickEvent e);
	}
	
	@Override
	public void paint(Graphics g) 
	{
	    g.drawRect(position.x, position.y, dimension.width, dimension.height);
	    if(mouseOver) 
	    {
	        doMouseOverDecoration(g);
	    }
	}
	
	//Observer Pattern
	Set<ButtonClickListener> buttonClickListener = new HashSet<>();
	
	public void addButtonClickListener(ButtonClickListener listener) 
	{
		buttonClickListener.add(listener);
	}
	
	public void removeButtonClickListener(ButtonClickListener listener) 
	{
		buttonClickListener.remove(listener);
	}
	
	private void dispatchButtonClickEvent(MouseEvent me) 
	{
		MouseButton button = ((me.getButton() == MouseEvent.BUTTON1) ? MouseButton.LEFT :
							  (me.getButton() == MouseEvent.BUTTON2) ? MouseButton.MIDLE :
							   MouseButton.RIGHT);
		
		ButtonClickEvent event = new ButtonClickEvent(this, button);
		buttonClickListener.forEach(listener -> listener.onClick(event));
	}
	

}