package View.Components;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class WordListArea extends JPanel
{
	JButton addWord;
	JButton deleteWord;
	JList wordList;
	JTextField inputText;
	public WordListArea()
	{
		Dimension size = getPreferredSize();
		size.width = 200;

		
		addWord = new JButton("Add Word");
		deleteWord = new JButton("Delete Word");
		inputText = new JTextField(8);
		setPreferredSize(size);
		this.setBackground(Color.red);

		add(inputText);
		add(addWord);

		add(deleteWord);
	}
}
