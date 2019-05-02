package lista5;

import java.awt.event.*;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButtonMenuItem;
	
public class Figury extends JApplet implements MouseListener, ActionListener {

	 JButton info;
	 ArrayList<Rectangle> rectangleArray;
	 ArrayList<Circle> circleArray;
	 ArrayList<Polygon> polygonArray;
	 Rectangle rectangle;
	 Circle circle;
	 Polygon polygon;
	 public int mx1, my1, mx2, my2;
	 
	public void init () {
		
		setLayout(new FlowLayout());
		
		Menu menu = new Menu();
		add(menu.createMenuBar(), BorderLayout.NORTH); //could use here setJMenuBar(menu.createMenuBar());
		addMouseListener(this);
		
		info = new JButton("info");
		info.setBackground(Color.DARK_GRAY);
		info.setForeground(Color.LIGHT_GRAY);
		info.setPreferredSize(new Dimension(60, 25));
		info.addActionListener(this);
		add(info, BorderLayout.EAST);

		rectangleArray = new ArrayList<Rectangle>();
		circleArray = new ArrayList<Circle>();
		polygonArray = new ArrayList<Polygon>();
		
	}
	
	public void paint (Graphics g) {
		
		super.paint(g);	
		
		//Graphics2D g2d = (Graphics2D)g;
		
		for (int i = 0; i<rectangleArray.size() ; i++)
        {
           (rectangleArray.get(i)).display(g);
        }
		for (int i = 0; i<circleArray.size() ; i++)
        {
           (circleArray.get(i)).display(g);
        }
		for (int i = 0; i<polygonArray.size() ; i++)
        {
           (polygonArray.get(i)).display(g);
        }
		//repaint();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		//Menu shape = new Menu();
		//if(shape.shape()=="r") {
		//	int mx = e.getX();
		//	int my = e.getY();
		//	rectangle = new Rectangle(mx, my);
		//	rectangleArray.add(rectangle);
		//	repaint();
		//};
		
		
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

		mx1 = e.getX();
		my1 = e.getY();

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		mx2 = e.getX();
		my2 = e.getY();
		circle = new Circle(mx1,my1,mx2,my2);
		circleArray.add(circle);
		repaint();
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(null, "INFO: author, przeznaczenie", "about", JOptionPane.INFORMATION_MESSAGE);
	}
	
}

