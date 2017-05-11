//package newSwingDemoPackage;

import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.*;

public class Demo {
	public static void main (String[] args){
		Xyz object = new Xyz();
		
	}

}

class Xyz extends JFrame{
	public Xyz(){
		addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e){
				int x = e.getX();
				int y = e.getY();
				System.out.println(x + " , " + y);
			}
		});
		setLayout(new FlowLayout());
		setVisible(true);
		setSize(400,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
