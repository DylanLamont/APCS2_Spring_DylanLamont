//package newSwingDemoPackage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.*;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;
import java.util.Date;
import java.util.*;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;

public class Demo {
	public static void main (String[] args){
		Xyz object = new Xyz();
		//Time keeping system,  possible word games
	}

}

class Xyz extends JFrame{
	String word = "";
	ArrayList<String> wordList = new ArrayList<String>();
	JPanel panel = new JPanel();
	JTextArea text = new JTextArea();
	JTextArea playerText = new JTextArea();
	String playerWord = "";
	
	public Xyz(){
		wordList.add("worldly"); wordList.add("classroom"); wordList.add("programming"); wordList.add("desk"); wordList.add("intellegent");wordList.add("board"); wordList.add("computer"); wordList.add("shoe"); wordList.add("book");

		word =wordList.get((int)(Math.random()*wordList.size()));
		
		text = new JTextArea(1,word.length());
		
		playerText =new JTextArea(1,word.length());
		
		
		addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e){
				int x = e.getX();
				int y = e.getY();
				System.out.println(x + " , " + y);
			}
		});
		addKeyListener( new KeyAdapter(){
			public void keyPressed(KeyEvent e){
				boolean isNotCorrect = true;
			//	while (isNotCorrect){
					
					text.setText(word);
					playerText.setText("");
					char newLetter = e.getKeyChar();
					if(newLetter == e.VK_BACK_SPACE && playerWord.length()>0){
						playerWord = playerWord.substring(0, playerWord.length());
					}else if (newLetter == e.VK_BACK_SPACE && playerWord.length() ==0){
						playerWord = "";
					}else{
						playerWord += newLetter;
						//System.out.println(playerWord);
					}
					playerText.setText(playerWord);
					
					if (playerWord.equalsIgnoreCase(word)){
						text.setText("You won!");
						isNotCorrect = false;
					}
				}
//				if (e.getKeyChar() == 't'){
//					Date d = new Date();
//					System.out.println(d.getTime());
//				}
			
		});
		setLayout(new FlowLayout());
		setVisible(true);
		setSize(400,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel.add(text);
		add(panel);
	}
}
