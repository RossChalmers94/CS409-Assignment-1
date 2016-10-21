package Model;

import java.awt.Color;
import java.util.Set;
import java.util.HashSet;

import Physics.Angle;
import Physics.Geometry;
import Physics.Circle;
import Physics.LineSegment;

public class FlipperGizmo {

	private double x1pos;
	private double y1pos;
	private double x2pos;
	private double y2pos;
	private LineSegment centreLseg;
	private LineSegment topLseg;
	private LineSegment bottomLseg;
	private Circle circle1;
	private Circle circle2;
	private String rotate;

	public FlipperGizmo(double x1, double y1, double x2, double y2,
			String rotation) {

		x1pos = x1;
		y1pos = y1;
		x2pos = x2;
		y2pos = y2;
		rotate = rotation;

		centreLseg = new LineSegment(x1pos, y1pos, x2pos, y2pos);

		topLseg = new LineSegment(x1pos - 5, y1pos, x2pos - 5, y2pos);
		bottomLseg = new LineSegment(x1pos + 5, y1pos, x2pos + 5, y2pos);

		circle1 = new Circle(x1pos, y1pos, 5);
		circle2 = new Circle(x2pos, y2pos, 5);

	}

	public int getX1() {

		return (int) centreLseg.p1().x();
	}

	public int getY1() {

		return (int) centreLseg.p1().y();
	}

	public Color getColor() {

		return Color.BLUE;
	}

	public int getWidth() {

		return (int) ((int) centreLseg.length() + circle1.getRadius() * 2);
	}

	public int getHeight() {

		return 10;
	}

	public int getX2() {
		return (int) centreLseg.p2().x();
	}

	public int getY2() {
		return (int) centreLseg.p2().y();
	}

	public int getTopX1() {
		return (int) topLseg.p1().x();
	}

	public int getTopY1() {
		return (int) topLseg.p1().y();
	}

	public int getTopX2() {
		return (int) topLseg.p2().x();
	}

	public int getTopY2() {
		return (int) topLseg.p2().y();
	}

	public int getBottomX1() {
		return (int) bottomLseg.p1().x();
	}

	public int getBottomY1() {
		return (int) bottomLseg.p1().y();
	}

	public int getBottomX2() {
		return (int) bottomLseg.p2().x();
	}

	public int getBottomY2() {
		return (int) bottomLseg.p2().y();
	}

	public double getLength() {
		return centreLseg.length();
	}

	public void riseClockwise() {

		centreLseg = Geometry.rotateAround(centreLseg, circle1.getCenter(),
				new Angle(0.0872664626));
		circle1 = Geometry.rotateAround(circle1, centreLseg.p1(), new Angle(
				0.0872664626));
		circle2 = Geometry.rotateAround(circle2, centreLseg.p1(), new Angle(
				0.0872664626));
		topLseg = Geometry.rotateAround(topLseg, circle1.getCenter(),
				new Angle(0.0872664626));
		bottomLseg = Geometry.rotateAround(bottomLseg, circle1.getCenter(),
				new Angle(0.0872664626));

	}

	public void dropClockwise() {

		centreLseg = Geometry.rotateAround(centreLseg, circle1.getCenter(),
				new Angle(-0.0872664626));
		circle1 = Geometry.rotateAround(circle1, centreLseg.p1(), new Angle(
				-0.0872664626));
		circle2 = Geometry.rotateAround(circle2, centreLseg.p1(), new Angle(
				-0.0872664626));
		topLseg = Geometry.rotateAround(topLseg, circle1.getCenter(),
				new Angle(-0.0872664626));
		bottomLseg = Geometry.rotateAround(bottomLseg, circle1.getCenter(),
				new Angle(-0.0872664626));
	}

	public void riseAntiClockwise() {

		centreLseg = Geometry.rotateAround(centreLseg, circle1.getCenter(),
				new Angle(-0.0872664626));
		circle1 = Geometry.rotateAround(circle1, centreLseg.p1(), new Angle(
				-0.0872664626));
		circle2 = Geometry.rotateAround(circle2, centreLseg.p1(), new Angle(
				-0.0872664626));
		topLseg = Geometry.rotateAround(topLseg, circle1.getCenter(),
				new Angle(-0.0872664626));
		bottomLseg = Geometry.rotateAround(bottomLseg, circle1.getCenter(),
				new Angle(-0.0872664626));

	}

	public void dropAntiClockwise() {

		centreLseg = Geometry.rotateAround(centreLseg, circle1.getCenter(),
				new Angle(0.0872664626));
		circle1 = Geometry.rotateAround(circle1, centreLseg.p1(), new Angle(
				0.0872664626));
		circle2 = Geometry.rotateAround(circle2, centreLseg.p1(), new Angle(
				0.0872664626));
		topLseg = Geometry.rotateAround(topLseg, circle1.getCenter(),
				new Angle(0.0872664626));
		bottomLseg = Geometry.rotateAround(bottomLseg, circle1.getCenter(),
				new Angle(0.0872664626));
	}

}
