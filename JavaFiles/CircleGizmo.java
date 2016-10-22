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

public class CircleGizmo implements GizmoInterface {

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






