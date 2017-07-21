public class Point {

	private int x;
	private int y;
	private int z;

	public Point(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public Point() {
		x = 0;
		y = 0;
		z = 0;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getZ() {
		return z;
	}

	public void setX(int d) {
		x = d;
	}

	public void setY(int d) {
		y = d;
	}
	public void setZ(int d) {
		z = d;
	}

	public String toString() {
		return "("+x+", "+y+", "+z+")";
	}

	public Point PointDouble(Point p1, Point p2) { //uses midpoint formula to find a third point outside of two points where one of the two points is the midpoint
		int newX = (p2.getX()*2)-p1.getX();
		int newY = (p2.getY()*2)-p1.getY();
		int newZ = (p2.getZ()*2)-p1.getZ();

		Point p3 = new Point(newX, newY, newZ);

		return p3;
	}
}
