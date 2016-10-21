package Model;
import java.awt.Color;
import java.awt.Rectangle;
import java.util.List;

import Physics.Circle;
import Physics.LineSegment;

public class AbsorberGizmo implements GizmoInterface{

	private int xpos;
	private int ypos;
	private int width;
	private int height;
	private Rectangle rec;
	private Color colour;
	private List <LineSegment> listOfSeg;
	private LineSegment lseg;
	
	public AbsorberGizmo(int x, int y, int w, int h){
		xpos = x;
		ypos = y;
		width = w;
		height = h;
		rec = new Rectangle(x, y, width, height);
		colour = Color.BLUE;
		lseg = new LineSegment(x, y, x + w, y);
		listOfSeg.add(lseg);
	}
	
	public Rectangle getRect() {
		return rec;
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
		return width;
	}

	@Override
	public double getHeight() {
		// TODO Auto-generated method stub
		return height;
	}

	@Override
	public List<LineSegment> getLineSeg() {
		// TODO Auto-generated method stub
		return listOfSeg;
	}

	@Override
	public List<Circle> getCircles() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public class Ball {
		   
		   private double radius;
		   
		   private void setRadius(double value) {
		      this.radius = value;
		   }
		   
		   private double getRadius() {
		      return this.radius;
		   }
		   
		   private double xpos;
		   
		   private void setXpos(double value) {
		      this.xpos = value;
		   }
		   
		   private double getXpos() {
		      return this.xpos;
		   }
		   
		   private double ypos;
		   
		   private void setYpos(double value) {
		      this.ypos = value;
		   }
		   
		   private double getYpos() {
		      return this.ypos;
		   }
		   
		   private String/*No type specified!*/ velocity;
		   
		   private void setVelocity(String/*No type specified!*/ value) {
		      this.velocity = value;
		   }
		   
		   private String/*No type specified!*/ getVelocity() {
		      return this.velocity;
		   }
		   
		   public void getVelo() {
		      // TODO implement this operation
		      throw new UnsupportedOperationException("not implemented");
		   }
		   
		   public void setVelo() {
		      // TODO implement this operation
		      throw new UnsupportedOperationException("not implemented");
		   }
		   
		   public int getCircle() {
		      // TODO implement this operation
		      throw new UnsupportedOperationException("not implemented");
		   }
		   
		   public double getExactX() {
		      // TODO implement this operation
		      throw new UnsupportedOperationException("not implemented");
		   }
		   
		   public double getExactY() {
		      // TODO implement this operation
		      throw new UnsupportedOperationException("not implemented");
		   }
		   
		   public void setExactX() {
		      // TODO implement this operation
		      throw new UnsupportedOperationException("not implemented");
		   }
		   
		   public void setExactY() {
		      // TODO implement this operation
		      throw new UnsupportedOperationException("not implemented");
		   }
		   
		   }
	import java.awt.Color;
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
	
	
}
