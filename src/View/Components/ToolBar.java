package View.Components;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

public class ToolBar extends JPanel
{
	public ToolBar(int height)
	{
		setPreferredSize(new Dimension(200,height));
		this.setBackground(Color.orange);
	}
}
