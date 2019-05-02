import java.awt.event.*;
import java.awt.geom.Line2D;
import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;
	
/**
 * Drawing applet that enables to draw rectangle, circle or polygon, resize/move it, change its color

 * @author Anna Modrzejewska
 * 
 */
public class Shapes extends JApplet implements ActionListener, MouseListener, MouseWheelListener, MouseMotionListener {

	/**
	 * the info button
	 */
	JButton info;
	/**
	 * the array containing all object with the same shape
	 */
	ArrayList<Rectangle> rectangleArray;
	ArrayList<Circle> circleArray;
	ArrayList<Polygon> polygonArray;
	/**
	 * the array containing x and y coordinates of polygon points
	 */
	ArrayList<Integer> coordsX = new ArrayList<Integer>();
	ArrayList<Integer> coordsY = new ArrayList<Integer>();
	/**
	 * (x1,y1) - mouse pressed coordinates, (x2,y2) - mouse released coordinates
	 */
	int x1, y1, x2, y2; 
	/**
	 * indicates which button was pressed - Rectangle, Circle or Polygon
	 */
	String shapeType=""; 
	/**
	 * coordinates of not finished shapes (when it's still dragging)
	 */
	Point startDrag, endDrag;
	

	/**
	 * sets applet layout to flow layout
	 * adds menubar and info button
	 */
	
	
	public void init () {
		
		setLayout(new FlowLayout());
		addMouseListener(this);
		addMouseWheelListener(this);
		addMouseMotionListener(this);
		
		add(createMenuBar(), BorderLayout.NORTH); 
		
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
	
	/**
	 * Paints checked background.
	 * 
	 * @param g2	the graphic target
	 */
	
	private void paintBackground(Graphics2D g2) {
		
		g2.setPaint(Color.LIGHT_GRAY);
		for (int i=0; i<getSize().width; i=i+10)
		{
			g2.draw(new Line2D.Double(i, 40, i, getSize().height));
		}
		for (int i=40; i<getSize().height; i=i+10)
		{
			g2.draw(new Line2D.Double(0, i, getSize().width, i));
		}
	}
	
	/**
	 * Paints on applet, sets transparency for shapes filling, displays all created shapes, paints shapes when mouse pressed, but not released yet
	 */
	public void paint (Graphics g) {
		
		super.paint(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		paintBackground(g2);
		
		g2.setStroke(new BasicStroke(2));
	    g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.50f));
	
	    for (int i = 0; i<rectangleArray.size() ; i++)
        {
	    	(rectangleArray.get(i)).display(g2);
        }
		for (int i = 0; i<circleArray.size() ; i++)
        {
			(circleArray.get(i)).display(g2);
        }
		for (int i = 0; i<polygonArray.size(); i++)
		{
			(polygonArray.get(i)).display(g2);
		}
		
	      if (startDrag != null && endDrag != null) {
	          g2.setPaint(Color.DARK_GRAY);
	          if (shapeType=="Rectangle")
	          {
	        	  Rectangle r = new Rectangle(startDrag.x, startDrag.y, endDrag.x, endDrag.y, Color.PINK);
	        	  g2.draw(r);
	          }
	          
	          if (shapeType=="Circle")
	          {
	        	  Circle c = new Circle(startDrag.x, startDrag.y, endDrag.x, endDrag.y, Color.BLUE);
	        	  g2.draw(c);
	          }
	      }	
		
	}

	/**
	 * Shows Option Pane when clicked on info button, in another case gets the name of shape (chosen from menu) and assigns to "shapeType" field 
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource()==info)
		{
			JOptionPane.showMessageDialog(null, "author: Ania Modrzejewska"+ "\n" 
												+"A drawing applet with following features:" + "\n" 
												+ "left mouse click + drag - draw shape" + "\n"
												+ "right mouse click on the shape - change color" + "\n"
												+ "drag mouse on the shape - move" + "\n"
												+ "mouse scroll on the shape - resize", "INFO", JOptionPane.INFORMATION_MESSAGE);
		}
		else
		{
			shapeType = e.getActionCommand().toString(); // which option was chosen
		}
		
	}

	/**
	 * Checks if right mouse button clicked.
	 * Checks if clicked inside the shape.
	 * Shows Color Chooser.
	 * Assigns chosen color to "c" field.
	 * Creates new shape with current dimension and new color.
	 * Replaces old shape with the new with different color.
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if (SwingUtilities.isRightMouseButton(e)) {
			
			for (int i = 0; i<rectangleArray.size() ; i++)
            {
    	    	if ((rectangleArray.get(i)).isHit(e.getX(), e.getY())) {
    	    		Color c = JColorChooser.showDialog(this,"Choose",Color.BLACK); 
    	    		Graphics g = getGraphics();
    	    		Graphics2D g2d = (Graphics2D)g;
    	    		g2d.setColor(c);
    	    		double maxx = (rectangleArray.get(i)).getMaxX();
    	    		double maxy = (rectangleArray.get(i)).getMaxY();
    	    		double minx = (rectangleArray.get(i)).getMinX();
    	    		double miny = (rectangleArray.get(i)).getMinY();
    	    		Rectangle rectangle1 = new Rectangle((int)maxx, (int)maxy, (int)minx, (int)miny, c);  
    	    		g2d.fill(rectangle1);
    	    		rectangleArray.set(i, rectangle1);
    	    	}
            }	
    	    
			for (int i = 0; i<circleArray.size() ; i++)
            {
            	if ((circleArray.get(i)).isHit(e.getX(), e.getY())) {
                   Color c=JColorChooser.showDialog(this,"Choose",Color.BLACK); 
                   Graphics g = getGraphics();
                   Graphics2D g2d = (Graphics2D)g;
                   g2d.setColor(c);
                   double cx = (circleArray.get(i)).getCenterX();
                   double cy = (circleArray.get(i)).getCenterY();
                   double maxx = (circleArray.get(i)).getMaxX();
                   double maxy = (circleArray.get(i)).getMaxY();
                   Circle circle1 = new Circle((int)cx, (int)cy, (int)(((maxx-cx)/Math.sqrt(2))+cx), (int)(((maxy-cy)/Math.sqrt(2))+cy), c);  
                   g2d.fill((circleArray.get(i)));
                   circleArray.set(i, circle1);
       	    	}		 
            }
		}
	}

	/**
	 * Gets coordinates of mouse pressed event if rectangle or circle chosen.
	 * Gets coordinates of mouse pressed event until it is pressed near the first press, draws dots where clicked and creates the polygon when polygon chosen.
	 */
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
		if (SwingUtilities.isLeftMouseButton(e)) {
			
		if(shapeType=="Rectangle" || shapeType=="Circle")
		{	
			x1 = e.getX();
			y1 = e.getY();
				
			startDrag = new Point(e.getX(), e.getY());
			endDrag = startDrag;
			repaint();		
			
		}
		
		else if (shapeType=="Polygon")
		{
				coordsX.add(e.getX());
				coordsY.add(e.getY());
				
			//	int r = 6; //Radius of the point.
		    //  int x = e.getX()-(r/2); //Position X (mouse will be in the center of the point)
		    //  int y = e.getY()-(r/2); //Position Y (mouse will be in the center of the point)

		    // Graphics g = getGraphics(); //Getting the Graphic object
		    // g.setColor(Color.black); //Setting color to black
		    // g.fillOval(x, y, r, r); //Drawing the point
			// g.dispose();
				
				//if(Math.abs(coordsX.get(0)-coordsX.get(coordsX.size()-1))<10 && Math.abs(coordsY.get(0)-coordsY.get(coordsY.size()-1))<10)
				//{
					Polygon polygon = new Polygon(coordsX, coordsY);
					polygonArray.add(polygon);
					repaint();
				//}
			}
		}
	}
	
	/**
	 * Creates rectangle/circle, nulls dragging coordinates.
	 */
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
		if (SwingUtilities.isLeftMouseButton(e)) {
			x2 = e.getX();
			y2 = e.getY();
		
			if (shapeType.equals("Rectangle"))
			{	
				Rectangle rectangle = new Rectangle(x1,y1,x2,y2,Color.PINK);
				rectangleArray.add(rectangle);
				startDrag = null;
				endDrag = null;
		        repaint();
			}
			
			if (shapeType.equals("Circle"))
			{
				Circle circle = new Circle(x1,y1,x2,y2,Color.BLUE);
				circleArray.add(circle);	
				startDrag = null;
				endDrag = null;
				repaint();
			}	
		}
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * Resizes shape in proportion to mouse wheel scroll 
	 */
	
	@Override
	public void mouseWheelMoved(MouseWheelEvent e){
		int x = e.getX();
        int y = e.getY();

        if (e.getScrollType() == MouseWheelEvent.WHEEL_UNIT_SCROLL) {
    	    for (int i = 0; i<rectangleArray.size() ; i++)
            {
    	    	if ((rectangleArray.get(i)).isHit(x, y)) {
                
    	    		float amount =  e.getWheelRotation() * 15f;
    	    		(rectangleArray.get(i)).addWidth(amount);
    	    		(rectangleArray.get(i)).addHeight(amount);
    	    		repaint();
    	    		
    	    		// rectangleArray.set(i, new Rectangle(x1, y2, (int)(x2+amount), (int)(y2+amount)));
    	    	}
            }
    	    for (int i = 0; i<circleArray.size(); i++)
    	    {
    	    	if ((circleArray.get(i)).isHit(x, y)) {
    	    		
    	    		float amount = e.getWheelRotation() * 5f;
    	    		(circleArray.get(i)).addWidth(amount);
    	    		(circleArray.get(i)).addHeight(amount);
    	    		repaint();
    	    		
    	    	//	circleArray.set(i, new Circle(x1, y1, (int)(x2+amount), (int)(y2+amount)));
    	    	}   	
    	    }
        }      
	}

	/**
	 * Gets coordinates of the last dragging point.
	 */
	
	@Override
	public void mouseDragged(MouseEvent e) {
		 endDrag = new Point(e.getX(), e.getY());
         repaint();
         
//         int dx = e.getX() - x1;
//        int dy = e.getY() - y1;
         
//         for (int i = 0; i<rectangleArray.size() ; i++)
//        {
//	    	if ((rectangleArray.get(i)).isHit(x1, y1)) {   
//
//	    		(rectangleArray.get(i)).addX(dx);
//	    		(rectangleArray.get(i)).addY(dy);
//	    		repaint();
//	    	x1=x1+dx;
//        y1=y1+dy;
//	    	}
//       }         
           
   }
	
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * @return menubar with 3 available shapes to choose 
	 */
	
	private JMenuBar createMenuBar(){
		
		JMenuBar menuBar;
		JMenu menu;
		JRadioButtonMenuItem rbMenuItem;
		
		menuBar = new JMenuBar();
		
		menu = new JMenu("Choose the shape");
		//menu.setMnemonic(KeyEvent.VK_M);
		menuBar.add(menu);
		
		ButtonGroup group = new ButtonGroup();
		
		rbMenuItem = new JRadioButtonMenuItem("Rectangle");
		rbMenuItem.setSelected(false);
		rbMenuItem.setMnemonic(KeyEvent.VK_R);
		group.add(rbMenuItem);
		rbMenuItem.addActionListener(this);
		menu.add(rbMenuItem);
		
		rbMenuItem = new JRadioButtonMenuItem("Circle");
		rbMenuItem.setMnemonic(KeyEvent.VK_C);
		group.add(rbMenuItem);
		rbMenuItem.addActionListener(this);
		menu.add(rbMenuItem);
		
		rbMenuItem = new JRadioButtonMenuItem("Polygon");
		rbMenuItem.setMnemonic(KeyEvent.VK_P);
		group.add(rbMenuItem);
		rbMenuItem.addActionListener(this);
		menu.add(rbMenuItem);
		
		return menuBar;
	}
}