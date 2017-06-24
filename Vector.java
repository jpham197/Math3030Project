public class Vector {
	private int x;
	private int y;
	private int z;

	public Vector(int x, int y, int z){ //constructor
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public Vector(Vector v) {
		x = v.getX();
		y = v.getY();
		z = v.getZ();
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

	public int dotProduct(Vector p2) {
		return (x*p2.getX())+(y*p2.getY())+(z*getZ());
	}

	public Vector getVector(Point p1, Point p2) { //creates vector from two points (passed in as arguments)
		int i, j, k;
		i = p2.getX() - p1.getX();
		j = p2.getY() - p1.getY();
		k = p2.getZ() - p1.getZ();
		Vector v1 = new Vector(i, j, k);
		return v1;
	}

	public Vector xProduct(Vector p2){ //creates cross product by calling method on another vector
		Vector Purr = new Vector(0, 0, 0);
		Purr.setX(getY()*p2.getZ()-getZ()*p2.getY());
		Purr.setY(getZ()*p2.getX()-getX()*p2.getZ());
		Purr.setZ(getX()*p2.getY()-getY()*p2.getX());
		return Purr;
	}

	public boolean isParallel(Vector v) {
		if ((x/v.getX() == y/v.getY()) && (y/v.getY() == z/v.getZ())) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isEqual(Vector v) {
		// if (x==v.getX()) && (y==v.getY()) && (z==z.getZ()) {
		// 	return true;
		// } else {
		// 	return false;
		// }

		if (x==v.getX() && y==v.getY() && z==v.getZ()) {
			return true;
		} else {
			return false;
		}
	}

	public String toString() {
		return "<"+x+", "+y+", "+z+">";
	}

}
