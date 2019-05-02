import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.GeneralPath;
import java.util.ArrayList;


/**
 * Creates polygon (coordsX, coordsY) nodes
 * 
 * @author Anna Modrzejewska
 *
 */
public class Polygon extends GeneralPath.Double {

	private ArrayList<Integer> coordsX;
	private ArrayList<Integer> coordsY;

	/**
	 * Gets presses points (nodes of this polygon)
	 * 
	 * @param coordsX 	the x coordinates of mouse presses
	 * @param coordsY	the y coordinates of mouse presses
	 */
	public Polygon(ArrayList<Integer> coordsX, ArrayList<Integer> coordsY) 
	{
		this.coordsX = coordsX;
		this.coordsY = coordsY;
	}
	
	/**
	 * Creates polygon
	 * 
	 * @param g2d	the graphic target
	 */
	public void display (Graphics2D g2d)
	{
	
		g2d.setColor(Color.BLACK);
		GeneralPath polygon = new GeneralPath();
		
		polygon.moveTo(coordsX.get(0),coordsY.get(0));
		
		for (int i=1; i<coordsX.size(); i++)
		{
			//while(Math.abs(coordsX.get(0)-coordsX.get(i))>10 && Math.abs(coordsY.get(1)-coordsY.get(i))>10)
			polygon.lineTo(coordsX.get(i), coordsY.get(i));
		}
		
		polygon.closePath();
		
		g2d.draw(polygon);
		g2d.setPaint(Color.YELLOW);
		g2d.fill(polygon);
		
	}
	
}
	
