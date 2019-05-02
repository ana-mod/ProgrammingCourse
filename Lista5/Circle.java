/**
 * 
 */
package lista5;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Ellipse2D;

/**
 * @author Ana
 *
 */
public class Circle implements MouseListener{
	
	int mx1, my1, mx2, my2;
	
	public Circle (int x1, int y1, int x2, int y2){
		mx1 = x1;
		my1 = y2;
		mx2 = x2;
		my2 = y2;
	}
	
	public void display (Graphics g) {
		
		Graphics2D g2d = (Graphics2D)g;
		g2d.setColor(Color.yellow);
		double r = Math.sqrt(((mx2-mx1)*(mx2-mx1)+(my2-my1)*(my2-my1)));
		Ellipse2D.Double circle = new Ellipse2D.Double(mx1-r,my1-r,2*r,2*r);
		g2d.fill(circle);
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
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
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	
	
}
