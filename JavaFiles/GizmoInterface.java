package Model;

import java.awt.Color;
import java.util.List;

import Physics.Circle;
import Physics.LineSegment;

public interface GizmoInterface {
   public double getX1();
   
   public double getY1();
   
   public Color getColor();
   
   public double getWidth();
   
   public double getHeight();
   
   public List <LineSegment> getLineSeg();
   
   public List <Circle> getCircles();
   
   }
