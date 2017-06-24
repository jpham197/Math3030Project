public class Point {

	private int x;
	private int y;
	private int z;

	public Point(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
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
}
