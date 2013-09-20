package View;

import javax.swing.*;

public class GUI extends JPanel
{
	JFrame frame;

	public GUI()
	{
		frame = new JFrame("Puzzle420");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 500);
		frame.setLocationRelativeTo(null);

	}

	public JFrame getFrame()
	{
		return frame;
	}

	public void draw()
	{
		frame.setVisible(true);
	}

}
