import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

/**
 * Creates rectangle (x1,y1) mouse press coordinates, (x2,y2) mouse release coordinates, c color
 * 
 * @author Anna Modrzejewska
 *
 */
public class Rectangle extends Rectangle2D.Double {

	
	int x, y, w, h; //(x,y) - left upper corner, w - width, h - height
	Color c;
	/**
	 * Gets the coordinates and color of this rectangle.
	 * 
	 * @param x1	the first x-coordinate
	 * @param y1	the first y-coordinate
	 * @param x2	the second x-coordinate
	 * @param y2	the second y-coordinate
	 * @param c		the color
	 */
	public Rectangle(int x1, int y1, int x2, int y2, Color c)
	{
		x = Math.min(x1, x2);
		y = Math.min(y1, y2);
		w = Math.abs(x2-x1);
		h = Math.abs(y2-y1);
		this.c = c;
		setFrame(x, y, w, h);
	}
	
	/**
	 * Draws rectangle with (x,y) - upper-left point, w,h - width, height
	 * 
	 * @param g2d the graphic target
	 */
	public void display (Graphics2D g2d) {
		
		g2d.setPaint(Color.BLACK);
		Rectangle2D.Double rectangle = new Rectangle2D.Double(x, y, w, h);
		g2d.draw(rectangle);
		g2d.setPaint(c);
		g2d.fill(rectangle);
		
	}

	/**
	 * Indicates if inside this rectangle.
	 * 
	 * @param x1	the first coordinate
	 * @param y1	the second coordinate
	 * @return 		if inside/outside this rectangle
	 */
	public boolean isHit(float x1, float y1) {
		return getBounds2D().contains(x1, y1);
	}
	
	/**
	 * Adds amount to x coordinate
	 * @param x		amount added to x coordinate
	 */
	public void addX(float x) {
		this.x += x;
	}
	
	/**
	 * Adds amount to y coordinate
	 * @param y		amount added to y coordinate
	 */
	public void addY(float y) {
		this.y += y;
	}
	
	/**
	 * Adds amount to width
	 * @param w		amount added to width
	 */
	public void addWidth (float w) {
		this.w += w;
	}
	
	/**
	 * Adds amount to height
	 * @param h		amount added to height
	 */
	public void addHeight (float h) {
		this.h += h;
	}

}
