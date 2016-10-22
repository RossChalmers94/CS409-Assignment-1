package Model;
import Model.Gizmo;
import Physics.Circle;
import Physics.LineSegment;

import java.awt.Color;
import java.awt.Rectangle;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

public class SquareGizmo implements GizmoInterface{
	
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

	public SquareGizmo getRect(String test, String test1, String test2, String test3) {
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
	public LineSegment getLineright(String test, String test1, String test2, String test3) {
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
	

	
	public Color getColour(String test, String test1, String test2, String test3) {
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
   
