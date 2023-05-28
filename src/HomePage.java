import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class HomePage {
	JFrame f;
	JPanel homePanel;
	public HomePage()
	{
		f = new JFrame("Home Page");
		f.setSize(800,500);
		f.setVisible(true);
		f.setLayout(null);
		homePanel = new JPanel();
		homePanel.setBackground(Color.black);
		f.add(homePanel);
	}
	public static void main (String arg[])
	{
		HomePage hp = new HomePage();
	}
}
