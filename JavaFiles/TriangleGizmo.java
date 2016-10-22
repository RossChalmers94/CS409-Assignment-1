package Model;

import java.awt.*;
import java.util.List;

import Physics.Circle;
import Physics.LineSegment;

public class TriangleGizmo implements GizmoInterface {

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
	
	public TriangleGizmo getTriangle(String test, String test1, String test2, String test3) {
		return new TriangleGizmo(xpos ,ypos);
	}

	
	public LineSegment getLeftTriangle() {
		return lleft;
	}
	
	public LineSegment getRightTriangle() {
		return lright;
	}
	public LineSegment getBottomTriangle(String test, String test1, String test2, String test3) {
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
	
	public int[] getyPoints(String test, String test1, String test2, String test3) {
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
