package appTest;

import java.net.URL;

import javax.swing.ImageIcon;

import ticTacToe.gui.util.window.MainWindow;
import ticTacToe.gui.util.window.Table;

public class AppBackgroundTest {
	
	static ImageIcon loadImage(String pathWithFileName) 
	{
		URL url = AppBackgroundTest.class.getResource(pathWithFileName);
		return new ImageIcon(url);
	}
	
	public static void main(String[] args) 
	{
		
		final String path = "../ticTacToe/images/";
		
		MainWindow window = new MainWindow();
		
		ImageIcon icon = loadImage(path + "background.jpg");
		window.setBackground(icon);
		
		icon = loadImage(path + "tic-tac-toe.png");
		Table table = new Table(50,50,200,200);
		window.add(table);

	}
}