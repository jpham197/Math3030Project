public class Point {

	private int x;
	private int y;
	private int z;

	public Point(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public getX() {
		return x;
	}

	public getY() {
		return y;
	}

	public getZ() {
		return z;
	}

	public setX(int d) {
		x = d;
	}

	public setY(int d) {
		y = d;
	}
	public setZ(int d) {
		z = d;
	}

	public Vector getVector(Point p1, Point p2)
		return ("<"+(p2.getX() - p1.getX()) + ", " +(p2.getY() - p1.getY()) +", "+(p2.getZ() - p1.getZ)+">") ;
	}

	public String toString() {
		return "("+x+", "+y+", "+z+")";
	}
}
