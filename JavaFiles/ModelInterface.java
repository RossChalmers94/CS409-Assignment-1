package Model;

import Controller.ControllerInterface;

public interface ModelInterface {

	public String setGizmoArray();
	
	public String getGizmoArray();
	
	public void setBall();
	
	public Ball getBall();
	
	public void addGizmo(Gizmo gizmo);
	
	public Gizmo getGizmo();
	
	public CollisionDetails getCollisionDetails();
	
	public CollisionDetails timeCollision();
	
	public void moveBall();
	
	public Ball moveBallForTime(Ball ball,double time);
   
   }
