package Model;


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
	

	
}
