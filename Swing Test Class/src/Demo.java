//package newSwingDemoPackage;

import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.*;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;

public class Demo {
	public static void main (String[] args){
		Xyz object = new Xyz();
		//Time keeping system,  possible word games
	}

}

class Xyz extends JFrame{
	String word = "";
	
	public Xyz(){
		addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e){
				int x = e.getX();
				int y = e.getY();
				System.out.println(x + " , " + y);
			}
		});
		addKeyListener( new KeyAdapter(){
			public void keyPressed(KeyEvent e){
				word += e.getKeyChar();
				System.out.println(e.getKeyChar());
				if (e.getKeyCode() == KeyEvent.VK_SPACE){
					System.out.println(word);
				}if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE){
					word = "";
				}
			}
		});
		setLayout(new FlowLayout());
		setVisible(true);
		setSize(400,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
