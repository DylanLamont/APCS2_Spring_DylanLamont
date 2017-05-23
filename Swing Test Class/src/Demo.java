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
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class Demo {
	public static void main (String[] args){
		System.out.println("To play, run the prgram and click in the window created");
		System.out.println("try to click inside the newest rectangle with in 3 seconds");
		System.out.println("To save you artwork, press 's'");
		Xyz object = new Xyz();
		//Time keeping system,  possible word games
	}

}

class Xyz extends JFrame{

	JPanel panel = new JPanel();
	JTextArea text = new JTextArea(1,15);
	int rx = 0;
	int ry = 0;
	int width = 0;
	int height = 0;
	int x;
	int y;
	public Xyz(){		
		addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e){
				x = e.getX();
				y = e.getY();
				System.out.println(x + " " + y);
				System.out.println(rx + " "+ ry);
				if ((x > rx && y > ry)&&(x < (rx + width) && y < (ry + height))){
					System.out.println("wow");
				}
				Graphics rect = getGraphics();
				rectagleDrawer(rect);
			}
		});
		addKeyListener( new KeyAdapter(){
			public void keyPressed(KeyEvent e){
				if (e.getKeyChar() == 's'){
					saveFile();
				}
			}
		});
		setLayout(new FlowLayout());
		setVisible(true);
		setSize(400,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel.add(text);
	}
	
	public void rectagleDrawer(Graphics g){
		g.setColor(new Color(((int)(Math.random()*256)),((int)(Math.random()*256)),((int)(Math.random()*256))));
		rx = ((int)(Math.random() * 400));
		ry = ((int)(Math.random() * 400));
		height = ((int)(Math.random() * 40)) + 10;
		width = ((int)(Math.random() * 40)) + 10;
		g.fillRect(rx,ry, width, height);

//		g.drawRect(((int)Math.random() * 300),((int)Math.random() * 300) , ((int)Math.random() * 50), ((int)Math.random() * 50));
	}
	
	public void saveFile(){
		try
        {
            BufferedImage image = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
            Graphics2D graphics2D = image.createGraphics();
            panel.paint(graphics2D);
            ImageIO.write(image,"jpeg", new File("/home/deniz/Desktop/jmemPractice.jpeg"));
        }
        catch(Exception exception)
        {
            //code
        }
	}
}
