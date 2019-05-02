import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

/**
 * Creates circle (x1,y1) - center (mouse press) point, (x2,y2) edge (mouse release) point, c color
 * 
 * @author Anna Modrzejewska
 *
 */
public class Circle extends Ellipse2D.Double {
	
	double x, y, w, h;
	double r;
	Color c;
	
	/**
	 * Gets the coordinates and color of this circle
	 * 
	 * @param x1	center x-coordinate
	 * @param y1	center y-coordinate
	 * @param x2	edge x-coordinate
	 * @param y2	edge y-coordinate
	 * @param c		color
	 */
	public Circle (int x1, int y1, int x2, int y2, Color c){
		r = Math.sqrt(((x2-x1)*(x2-x1)+(y2-y1)*(y2-y1)));
		x = x1-r;
		y = y1-r;
		w = 2*r;
		h = 2*r;
		this.c = c;
		setFrame(x,y,w,h);
	}
	
	/**
	 * Draws circle with (x,y) - upper-left corner of the framing square, w,h - diameter
	 * 
	 * @param g2d the graphic target
	 */
	public void display (Graphics2D g2d) {

		g2d.setColor(Color.BLACK);
		Ellipse2D.Double circle = new Ellipse2D.Double(x, y, w, h);
		g2d.draw(circle);
		g2d.setPaint(c);
		g2d.fill(circle);
		
	}

	/**
	 * Indicates if inside this circle.
	 * 
	 * @param x1	the first coordinate
	 * @param y1	the second coordinate
	 * @return 		if inside/outside this circle
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