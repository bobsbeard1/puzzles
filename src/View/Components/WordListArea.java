package View.Components;

import Control.*;
import Model.*;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class WordListArea extends JPanel
{
	JButton addWord;
	JButton deleteWord;
	JList<String> wordList;
	DefaultListModel<String> listModel;
	JTextField inputText;
	WordList m_wordList;
	Controller m_control;
	
	public WordListArea(Controller control)
	{
		Dimension size = getPreferredSize();
		size.width = 200;

		m_control = control;
		listModel = new DefaultListModel<String> ();
		
		m_wordList = control.getModel().getWordList();
		
		
		// add lists to list
		String[] words = m_wordList.getAsArray();
		for (int i = 0; i < words.length; i++)
		{
			listModel.addElement(words[i]);
		}
		
		addWord = new JButton("Add Word");
		deleteWord = new JButton("Delete Word");
		inputText = new JTextField(8);
		wordList = new JList<String> (listModel);
		wordList.setPreferredSize(new Dimension (180, 700));
		setPreferredSize(size);
		//this.setBackground(Color.red);

		addWord.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.out.println(inputText.getText ());
				m_wordList.addWord (inputText.getText ());
				listModel.addElement(inputText.getText ());
				
				m_control.getModel().generatePuzzles ();
				
				m_control.getGUI().revalidate();
				m_control.getGUI().repaint();
			}
		});
		
		deleteWord.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.out.println("delete");
				
				String deletedWord = wordList.getSelectedValue();
				listModel.remove(wordList.getSelectedIndex());
				
				m_wordList.deleteWord(deletedWord);
				
				m_control.getModel().generatePuzzles ();
				
				m_control.getGUI().revalidate();
				m_control.getGUI().repaint();
			}
		});
		
		add(inputText);
		add(addWord);
		add(wordList);
		add(deleteWord);
		
		
		
	}
}
