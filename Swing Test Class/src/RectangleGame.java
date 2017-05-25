
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.*;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;
import java.util.Date;
import javax.swing.JTextArea;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class RectangleGame {
	public static void main (String[] args){
		System.out.println("To play, run the prgram and click in the window created");
		System.out.println("try to click inside the newest rectangle with in 3 seconds");
		System.out.println("To save you artwork, press 's'");
		System.out.println("To create beautiful artwork with a mix of ovals and rectangles, press 'a'");
		System.out.println("To create beautiful artwork with only rectangles, press 'r'");
		Xyz object = new Xyz();
	}
}

class Xyz extends JFrame{

	private JPanel panel = new JPanel();
	private JTextArea text = new JTextArea(1,15);
	private int rx = 0;
	private int ry = 0;
	private int width = 0;
	private int height = 0;
	private int x;
	private int y;
	//all above set so they're global
	private long endTime = new Date().getTime();							//first setting of unix time to avoid any issues
	private int imageCounter = 0;							//adds to tag of image to differentiate
	private int streakHit = 0;							//counts correct rectangle hits
	
	public Xyz(){
		setSize(400,400);
		addMouseListener(new MouseAdapter(){							//triggered action when mouse is clicked
			public void mousePressed(MouseEvent e){
				x = e.getX();							//gets click x and y
				y = e.getY();
				long clickTime = new Date().getTime();							//gets unix time (in milliseconds)
				if (((x > rx && y > ry)&&((x < (rx + width)) && (y < (ry + height)))) && (endTime > clickTime)){							//test so see if in box and on time
					streakHit++;
					System.out.println("\n ON TIME!\n Your streak is " + streakHit + "\n\n =============================================================");
				}else if (!((x > rx && y > ry)&&((x < (rx + width)) && (y < (ry + height))))){							//miss
					streakHit = 0;
					System.out.println("\nYou missed the whole box! \n Your streak is " + streakHit + "\n\n=============================================================");
				} else if (endTime < clickTime){							//late
					streakHit = 0;
					//if late or not on target, streak reset
					System.out.println("\nYou were way to slow! \n Your streak is " + streakHit + " \n\n=============================================================");
				} 
				Graphics rect = getGraphics();
				rectagleDrawer(rect);							//draws new rectangle
			}
		});
		addKeyListener( new KeyAdapter(){
			public void keyPressed(KeyEvent e){							//triggered action when a key is pressed
				if (e.getKeyChar() == 's'){							//if 's' pressed, saves jpg of panel
					saveFile();
				}
				else if (e.getKeyChar() == 'a'){							//'a' calls general art, with rectangles and ovals
					for( int i = 300; i > 0; i--){
						Graphics rect = getGraphics();
						artFunction(rect);
					}
				}
				else if (e.getKeyChar() == 't'){							//prints unix time, for curiosity
					System.out.println(new Date().getTime());
				}
				else if (e.getKeyChar() == 'r'){							//draws art with only rectangles
					for (int i = 300; i > 0; i--){
						Graphics rect = getGraphics();
						rectangleArtFunction(rect);
					}
				}
			}
		});
		setLayout(new FlowLayout());
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel.add(text);
	}
	
	public void rectagleDrawer(Graphics g){
		g.setColor(new Color(((int)(Math.random()*256)),((int)(Math.random()*256)),((int)(Math.random()*256))));							//sets graphic to random RBG color
		rx = ((int)(Math.random() * 350));							//sets x,y to random value from 0 to 350
		ry = ((int)(Math.random() * 350));
		height = ((int)(Math.random() * 40)) + 10;							//random size
		width = ((int)(Math.random() * 40)) + 10;
		g.fillRect(rx,ry, width, height);							//draws rectangle
		if (streakHit > 10){							//secret change to make high streaks harder
			endTime = new Date().getTime() + 2000;
		}else{
			endTime = new Date().getTime() + 4000;							//end time, or max time clicktime can occur is set to time of creation plus either 4 or 2 seconds
		}
	}
	
	public void saveFile(){
		try
        {
			Robot robot = new Robot();
			BufferedImage image = robot.createScreenCapture(new Rectangle(400,400));							//saves bufferedImage of 400x400 panel
			ImageIO.write(image,"jpeg", new File("./artwork/image" + imageCounter + ".jpeg"));							//writes to artwork folder the BufferedImage as a jpeg
            imageCounter++;							//used in name to avoid repeat name
            System.out.println("\n-\n-Your art was saved in your artwork folder\n-\n-");
        }
        catch(Exception exception)
        {
            System.out.println("\n-\n-\n-Something went wrong!\n-\n-");
        }
		
	}
	
	public void rectangleArtFunction(Graphics g){
		g.setColor(new Color(((int)(Math.random()*256)),((int)(Math.random()*256)),((int)(Math.random()*256))));
		rx = ((int)(Math.random() * 360));
		ry = ((int)(Math.random() * 360));
		height = ((int)(Math.random() * 30)) + 10;
		width = ((int)(Math.random() * 30)) + 10;
		g.fillRect(rx,ry, width, height);						//rectangle with random size between 10 and 40 with random size
	}
	public void artFunction(Graphics g){
		rectangleArtFunction(g);								// calls normal rectangle art draw, then draws random oval
		Graphics ovals = getGraphics();
		ovals.setColor(new Color(((int)(Math.random()*256)),((int)(Math.random()*256)),((int)(Math.random()*256))));
		int ox = ((int)(Math.random() * 360));
		int oy = ((int)(Math.random() * 360));
		int oHeight = ((int)(Math.random() * 30)) + 10;
		int oWidth = ((int)(Math.random() * 30)) + 10;
		ovals.fillOval(ox, oy, oWidth, oHeight);
	}

}
