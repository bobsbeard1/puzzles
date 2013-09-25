package View.Components;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ToolBar extends JPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JButton generateButton;
	JButton rearrangeButton;
	JButton saveButton;
	JButton loadButton;
	
	
	public ToolBar(int height)
	{
		generateButton = new JButton("Generate Puzzle");
		rearrangeButton = new JButton("Rearrange");
		saveButton = new JButton("Save Puzzle");
		loadButton = new JButton("Load Puzzle");

		setPreferredSize(new Dimension(200,height));
		this.setBackground(Color.orange);
		
		
		generateButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
		rearrangeButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
		saveButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
		loadButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		add(generateButton);
		add(rearrangeButton);
		add(saveButton);
		add(loadButton);
	}
}
