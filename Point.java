package alpha;

public class Point {
	public double x, y;
	public Point(double x, double y) {
		this.x = x; this.y = y;
	}
	
	public double distanceFromOrigin() {
		return Math.sqrt(x*x + y*y);
	}
	
	
	public void add(Point p) {
		this.x = p.x + x;
		this.y = p.y + y;
	}
	public void mul(double a) {
		this.x = x*a;
		this.y = y*a;
	}
	
	
	
}
