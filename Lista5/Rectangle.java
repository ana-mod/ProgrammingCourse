/**
 * 
 */
package lista5;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.GeneralPath;

/**
 * @author Ania
 *
 */
public class Rectangle implements MouseListener{

	int mx1, my1, mx2, my2;
//	boolean drawing = false;
//	GeneralPath path = null;
	
	public Rectangle(int x1, int y1){
		mx1 = x1;
		my1 = y1;
		//mx
	}
	
	public void display (Graphics g){
	
		g.setColor(Color.yellow);
		g.fillRect(mx1, my1, (mx2-mx1)*(mx2-mx1)+(my2-my1)*(my2-my1), (mx2-mx1)*(mx2-mx1)+(my2-my1)*(my2-my1)); // (x,y,wyliczony promienx2)

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
