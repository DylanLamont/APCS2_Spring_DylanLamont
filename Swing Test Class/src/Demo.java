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
import javax.swing.JButton;
import java.awt.Graphics;
import javax.swing.JComponent;
import javax.swing.JFrame;



public class Demo {
	public static void main (String[] args){
		Xyz object = new Xyz();
		//boolean isOnTime = true;
		
		
	}

}

class Xyz extends JFrame{
	
	JPanel panel  = new JPanel();
	int rx;
	int ry;
	int height;
	int width;
	int counter = 0;
	
	public Xyz(){
		panel.setLocation(0, 0);
		
	
	//	newButton.setLayout(null);
	//	newButton.setBounds((int) (Math.random() * 400), (int) (Math.random() * 400), 10, 10);
		addMouseListener(new MouseAdapter(){
			
			public void mousePressed(MouseEvent e){
				Graphics graphic = getGraphics();
				drawRect(graphic);
				if ((e.getX() > rx && e.getX() < rx + width) && (e.getY() > ry && e.getY() < ry + height)){
					graphic.dispose();
					counter++;
				}
				System.out.println(counter);
			}
		});
		addKeyListener( new KeyAdapter(){
			public void keyPressed(KeyEvent e){
				
							
				if (e.getKeyChar() == 't'){
					Date d = new Date();
					System.out.println(d.getTime());
				}
			}
		});
		
		

		setLayout(new FlowLayout());
		setVisible(true);
		setSize(400,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	public void drawRect(Graphics g){
		 rx = ((int)(Math.random() * 400));
		 ry = ((int)(Math.random() * 400));
		 height = ((int)(Math.random() * 30));
		 width = ((int)(Math.random() * 30));
		 g.fillRect(rx,ry, width, height);
	}
}