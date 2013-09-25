package View.Components;

import java.awt.Color;
import java.awt.Dimension;

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
	public WordListArea(int height)
	{
		addWord = new JButton("Add Word");
		deleteWord = new JButton("Delete Word");
		inputText = new JTextField(8);
		setPreferredSize(new Dimension(200,height));
		this.setBackground(Color.red);
		add(inputText);
		add(addWord);
		add(deleteWord);
	}
}
