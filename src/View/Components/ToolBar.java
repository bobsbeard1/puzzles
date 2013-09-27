package View.Components;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
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
	
	
	public ToolBar()
	{
		Dimension size = new Dimension();
		size.width = 200;
		generateButton = new JButton("Generate Puzzle");
		rearrangeButton = new JButton("Rearrange");
		saveButton = new JButton("Save Puzzle");
		loadButton = new JButton("Load Puzzle");

		setPreferredSize(size);
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
		setLayout(new GridBagLayout());
		GridBagConstraints constraint = new GridBagConstraints();
		constraint.anchor = GridBagConstraints.FIRST_LINE_START;
		constraint.insets = new Insets(1, 1, 5, 5);
		
		constraint.weighty = .1;
		constraint.gridx = 0;
		constraint.gridy = 0;
		add(generateButton, constraint);
		constraint.gridx = 0;
		constraint.gridy = 1;
		add(rearrangeButton, constraint);
		constraint.gridx = 0;
		constraint.gridy = 2;
		add(saveButton, constraint);
		constraint.weighty = 10;
		constraint.gridx = 0;
		constraint.gridy = 3;
		add(loadButton, constraint);
	}
}
