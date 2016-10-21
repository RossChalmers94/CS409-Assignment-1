package Model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.util.List;

import Physics.Circle;
import Physics.LineSegment;
import Physics.Vect;

/**
 * @author Murray Wood Demonstration of MVC and MIT Physics Collisions 2014
 */

public class CircleGizmo extends Model {

	private double radius;
	private double xpos;
	private double ypos;
	private Circle theCircle;

	private Color colour;
	private List <LineSegment> lineSeg;
	private List <Circle> circles;

	// x, y coordinates and x,y velocity
	public CircleGizmo(double x, double y) {
		xpos = x; // Centre coordinates
		ypos = y;
		colour = Color.orange;
		radius = 12.5;
		
		theCircle = new Circle(xpos, ypos, radius);
		circles.add(theCircle);
	}

	public double getRadius() {
		return radius;
	}

	public List <Circle> getCircle() {
		return  circles;
	}
	
	public List <Circle> getCircles(){
		return circles;
	}

	// Ball specific methods that deal with double precision.
	public double getExactX() {
		return xpos;
	}

	public double getExactY() {
		return ypos;
	}

	public void setExactX(double x) {
		xpos = x;
	}

	public void setExactY(double y) {
		ypos = y;
	}

	public double getX1() {

		return xpos;
	}

	public double getY1() {

		return ypos;
	}

	public double getWidth() {
		return radius*2;
	}

	public double getHeight() {
		return radius*2;
	}

	@Override
	public Color getColor() {
		// TODO Auto-generated method stub
		return colour;
	}

	@Override
	public List<LineSegment> getLineSeg() {
		// TODO Auto-generated method stub
		return lineSeg;
	}

}

public class Model extends ModelClass {

	@Override
	public String setGizmoArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getGizmoArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setBall() {
		
		ball = new Ball(485, 460, 100, 100);
	}

	@Override
	public Ball getBall() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addGizmo(Gizmo gizmo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Gizmo getGizmo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CollisionDetails getCollisionDetails() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CollisionDetails timeCollision() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void moveBall() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Ball moveBallForTime(Ball ball, double time) {
		// TODO Auto-generated method stub
		return null;
	}
   
   }

public class SquareGizmo extends Model{
	
	private int xpos,ypos,s;
	private Rectangle rec;
	private Color colour;
	private LineSegment ltop;
	private LineSegment lleft;
	private LineSegment lright;
	private LineSegment lbottom;	
	private Circle topleft,topright,bottomleft,bottomright;
	private List <LineSegment> lineSeg;
	private List <Circle> circles;
	
	// gws = new Walls(0, 0, 500, 500);
	
	public SquareGizmo(int x, int y){
		xpos = x;
		ypos = y;
		s = 25;
		rec = new Rectangle(x, y, s, s);
		colour = Color.CYAN;
		ltop = new LineSegment(x , y , x + s, y );
		lineSeg.add(ltop);
		lleft = new LineSegment(x , y , x, y + s );
		lineSeg.add(lleft);
		lright = new LineSegment(x + s , y, x +s , y + s  );
		lineSeg.add(lright);
		lbottom = new LineSegment(x , y + s , x + s, y + s);
		lineSeg.add(lbottom);
		
		topleft = new Circle(x,y,0);
		circles.add(topleft);
		topright = new Circle(x+s,y,0);
		circles.add(topright);
		bottomleft = new Circle(x,y+s,0);
		circles.add(bottomleft);
		bottomright = new Circle(x+s,y+s,0);
		circles.add(bottomright);
		
	}

	public SquareGizmo getRect() {
		return new SquareGizmo(xpos, ypos);
	}
	
	public LineSegment getLinetop() {
		return ltop;
	}
	
	public LineSegment getLinebottom() {
		return lbottom;
	}
	public LineSegment getLineleft() {
		return lleft;
	}
	public LineSegment getLineright() {
		return lright;
	}

	
	public int getX() {
		return xpos;
	}

	public int getY() {
		return ypos;
	}

	public int getSize() {
		return s;
	}
	

	
	public Color getColour() {
		return colour;
	}

	public Circle getTopLeft() {
		// TODO Auto-generated method stub
		return topleft;
	}

	public Circle getTopRight() {
		// TODO Auto-generated method stub
		return topright;
	}

	public Circle getBottomLeft() {
		// TODO Auto-generated method stub
		return bottomleft;
	}

	public Circle getBottomRight() {
		// TODO Auto-generated method stub
		return bottomright;
	}
	

	@Override
	public List<LineSegment> getLineSeg() {
		// TODO Auto-generated method stub
		return lineSeg;
	}

	@Override
	public List<Circle> getCircles() {
		// TODO Auto-generated method stub
		return circles;
	}

	@Override
	public double getX1() {
		// TODO Auto-generated method stub
		return xpos;
	}

	@Override
	public double getY1() {
		// TODO Auto-generated method stub
		return ypos;
	}

	@Override
	public Color getColor() {
		// TODO Auto-generated method stub
		return colour;
	}

	@Override
	public double getWidth() {
		// TODO Auto-generated method stub
		return s;
	}

	@Override
	public double getHeight() {
		// TODO Auto-generated method stub
		return s;
	}
	
}

public class TriangleGizmo extends Triangle {

	private int xpos;
	private int ypos;
	private int[] xpoints, ypoints;
	private int size;
	private Color colour;
	private Graphics triangle;
	private LineSegment lleft;
	private LineSegment lbottom;
	private LineSegment lright;
	private Polygon p;
	private Circle left,right,bottom;
	private List <LineSegment> lineSeg;
	private List <Circle> circles;
	
	
	
	
	public TriangleGizmo(int x, int y){
		xpos = x;
		ypos = y;
		colour = Color.MAGENTA;
		
		int[] xList = {x+25, x, x+25};
		int[] yList = {y-25, y-25, y};
		
		xpoints = xList;
		ypoints = yList;
		
		lleft = new LineSegment(x+25,y-25,x ,y-25);
		lineSeg.add(lleft);
		lbottom = new LineSegment(x+25,y-25,x+25,y);
		lineSeg.add(lbottom);
		lright = new LineSegment(x ,y-25, x+25,y);
		lineSeg.add(lright);
		
		
		left = new Circle(x,y-25,0);
		circles.add(left);
		right = new Circle(x + 25,y - 25,0);
		circles.add(right);
		bottom = new Circle(x + 25,y,0);
		circles.add(bottom);
		
		p = new Polygon(xList, yList, 3);
	}
	
	public TriangleGizmo getTriangle() {
		return new TriangleGizmo(xpos ,ypos);
	}

	
	public LineSegment getLeftTriangle() {
		return lleft;
	}
	
	public LineSegment getRightTriangle() {
		return lright;
	}
	public LineSegment getBottomTriangle() {
		return lbottom;
	}
	
	public int getX() {
		return xpos;
	}

	public int getY() {
		return ypos;
	}
	
	public int[] getxPoints() {
		return xpoints;
	}
	
	public int[] getyPoints() {
		return ypoints;
	}

	public int getSize() {
		return size;
	}
	
	public Color getColour() {
		return colour;
	}

	public Circle getRight() {
		// TODO Auto-generated method stub
		return right;
	}

	public Circle getLeft() {
		// TODO Auto-generated method stub
		return left;
	}

	public Circle getBottom() {
		// TODO Auto-generated method stub
		return bottom;
	}

	@Override
	public double getX1() {
		// TODO Auto-generated method stub
		return xpos;
	}

	@Override
	public double getY1() {
		// TODO Auto-generated method stub
		return ypos;
	}

	@Override
	public Color getColor() {
		// TODO Auto-generated method stub
		return colour;
	}

	@Override
	public double getWidth() {
		// TODO Auto-generated method stub
		return 25;
	}

	@Override
	public double getHeight() {
		// TODO Auto-generated method stub
		return 25;
	}

	@Override
	public List<LineSegment> getLineSeg() {
		// TODO Auto-generated method stub
		return lineSeg;
	}

	@Override
	public List<Circle> getCircles() {
		// TODO Auto-generated method stub
		return circles;
	}


	
}
