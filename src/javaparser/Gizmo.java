package javaparser;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import physics.Circle;
import physics.LineSegment;

public class Gizmo implements GizmoInterface{
int x, y,triangleState;
String id, gizmoType;
Color colour;
List<LineSegment> lineSegs;
List<ArrayList<LineSegment>> rotateSegments;
List<Circle> circles;

	public Gizmo(int x, int y, String id, String gizmoType){
		this.x = x;
		this.y = y;
		this.id = id;
		this.gizmoType = gizmoType;
		triangleState = 0;
		rotateSegments = new ArrayList<ArrayList<LineSegment>>();
		lineSegs = createLines(gizmoType);
		circles = createCircles(gizmoType);
	}
	
	@Override
	public int getX1() {
		// TODO Auto-generated method stub
		return x;
	}

	@Override
	public int getY1() {
		// TODO Auto-generated method stub
		return y;
	}

	@Override
	public Color getColor() {
		return colour;
	}

	@Override
	public int getWidth() {
		return 1;
	}

	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getID() {
		// TODO Auto-generated method stub
		return id;
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return gizmoType;
	}
	
	@Override
	public List<LineSegment> getLineSegments() {
		// TODO Auto-generated method stub
		return lineSegs;
	}

	@Override
	public List<Circle> getCircles() {
		// TODO Auto-generated method stub
		return circles;
	}
	
	public void setLineSegments(List<LineSegment> lsegs){
		lineSegs = lsegs;
	}
	
	public void setCircles(List<Circle> circle){
		circles=circle;
	}
	public List<LineSegment> createLines(String gizmoType){
		List<LineSegment> gizmoLines = new ArrayList<LineSegment>();
		switch(gizmoType){
		case "Triangle":
			gizmoLines.add(new LineSegment(x,y,x ,y-1));
			gizmoLines.add(new LineSegment(x,y,x+1,y-1));
			gizmoLines.add(new LineSegment(x ,y-1, x+1,y-1));
			colour = Color.RED;
			break;
		case "Circle":
			colour = Color.CYAN;
			break;
		case "Square":
			int s = 1;
			gizmoLines.add(new LineSegment(x , y , x + s, y ));
			gizmoLines.add(new LineSegment(x , y , x, y + s));
			gizmoLines.add(new LineSegment(x + s , y, x +s , y + s));
			gizmoLines.add(new LineSegment(x , y + s , x + s, y + s));
			colour = Color.ORANGE;
			break;
		case "Absorber":
			gizmoLines.add(new LineSegment(x, y, x + 20, y));
			colour = Color.PINK;
			break;
		default:
			System.out.println("Invalid Gizmo Type");
			break;
		}
		
		return gizmoLines;
	}
	
	public List<Circle> createCircles(String gizmoType){
		List<Circle> gizmoCircles = new ArrayList<Circle>();
		switch(gizmoType){
		case "Triangle":
			gizmoCircles.add(new Circle(x,y-1,0));
			gizmoCircles.add(new Circle(x+1,y-1,0));
			gizmoCircles.add(new Circle(x,y,0));
			colour = Color.RED;
			break;
		case "Circle":
			gizmoCircles.add(new Circle(x + 0.5, y + 0.5, 0.5));
			break;
		case "Square":
			int s = 1;
			gizmoCircles.add(new Circle(x,y,0));
			gizmoCircles.add(new Circle(x+s,y,0));
			gizmoCircles.add(new Circle(x,y+s,0));
			gizmoCircles.add(new Circle(x+s,y+s,0));
			colour = Color.ORANGE;
			break;
		default:
			System.out.println("Invalid Gizmo Type");
			break;
		}
		return gizmoCircles;
	}

	public void fillRotateList(){
		ArrayList<LineSegment> firstTriangle = new ArrayList<LineSegment>();
		firstTriangle.add(new LineSegment(x,y,x ,y-1));
		firstTriangle.add(new LineSegment(x,y,x+1,y-1));
		firstTriangle.add(new LineSegment(x ,y-1, x+1,y-1));
		
		ArrayList<LineSegment> secondTriangle = new ArrayList<LineSegment>();
		secondTriangle.add(new LineSegment(x,y-1,x+1 ,y-1));
		secondTriangle.add(new LineSegment(x+1,y-1,x+1,y));
		secondTriangle.add(new LineSegment(x+1,y,x,y-1));
		
		ArrayList<LineSegment> thirdTriangle = new ArrayList<LineSegment>();
		thirdTriangle.add(new LineSegment(x,y,x+1 ,y-1));
		thirdTriangle.add(new LineSegment(x+1,y-1,x+1,y));
		thirdTriangle.add(new LineSegment(x+1,y,x,y));
		
		ArrayList<LineSegment> fourthTriangle = new ArrayList<LineSegment>();
		fourthTriangle.add(new LineSegment(x,y-1,x+1,y));
		fourthTriangle.add(new LineSegment(x,y,x,y-1));
		fourthTriangle.add(new LineSegment(x+1,y,x,y));
		rotateSegments.add(firstTriangle);
		rotateSegments.add(secondTriangle);
		rotateSegments.add(thirdTriangle);
		rotateSegments.add(fourthTriangle);
	}
	
	public void changeLineSegments(){
		fillRotateList();
		circles.clear();
		if(this.lineSegs.get(0).p1().x() == rotateSegments.get(triangleState).get(0).p1().x() && 
				this.lineSegs.get(0).p1().y() == rotateSegments.get(triangleState).get(0).p1().y() &&
				this.lineSegs.get(0).p2().x() == rotateSegments.get(triangleState).get(0).p2().x() &&
				this.lineSegs.get(0).p2().y() == rotateSegments.get(triangleState).get(0).p2().y()){
			System.out.println("WE'RE CHANGING LINE SEGMENTS");
			if(triangleState==3){
				this.lineSegs = rotateSegments.get(0);
				triangleState = 0;

			}else{
				this.lineSegs = rotateSegments.get(triangleState+1);
				triangleState = triangleState+1;
			}
		}
		for(LineSegment ls :  lineSegs){
			circles.add(new Circle(ls.p1().x(), ls.p1().y(), 0));
		}
	}
	
	public int getTriangleState(){
		return triangleState;
	}
	
	
}
