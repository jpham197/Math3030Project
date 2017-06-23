public class Vector {
	private int x;
	private int y;
	private int z;

	public Vector(Point a, Point b){
		x=b.getX-a.getX;
		y=b.getY-a.getY;
		z=b.getZ-a.getZ;
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

	public int dotProduct(Vector p2) {
		return (x*p2.getX())+(y*p2.getY())+(z*getZ());
	}

	public Vector xProduct(Vector p2){
		Vector Purr=new Vector;
		Purr.setX(getY()*p2.getZ()-getZ()*p2.getY());
		Purr.setY(getZ()*p2.getX()-getX()*p2.getZ());
		Purr.setZ(getX()*p2.getY()-getY()*p2.getX());
		return Purr;
	}

	public boolean isParallel(Vector v) {
		if (x/v.getX() == y/v.getY()) && (y/v.getY() == z/v.getZ()) &&) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isEqual(Vector v) {
		if (x==v.getX()) && (y==v.getY()) && (z==z.getZ()) {
			return true;
		} else {
			return false;
		}
	}

	public String toString() {
		return "<"+x+", "+y+", "+z+">";
	}

}
