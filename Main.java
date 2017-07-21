import java.util.Scanner;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) {

		Scanner user = new Scanner(System.in);
		Point[] list = new Point[4];
		boolean collinear = false;
		Vector vzero = new Vector(0, 0, 0);

		for(int i = 0; i < 4; i++) {
			System.out.println("Enter point " + (i+1) + "'s coordinates");
			System.out.println("x = ?");
			int x = user.nextInt();
			System.out.println("y = ?");
			int y = user.nextInt();
			System.out.println("z = ?");
			int z = user.nextInt();
			list[i] = new Point(x,y,z);
		}

		System.out.println(Arrays.toString(list));
		Vector v = new Vector(0, 0, 0);
		Vector v1 = v.getVector(list[0], list[1]);
		Vector v2 = v.getVector(list[1], list[2]);
		Vector vcross = v1.xProduct(v2);
		vcross = vcross.simplify();

		//check if points A, B, and C are collinear
		if (QuestionOne(vcross, vzero) == false) {
			QuestionTwo(list, vcross);
			QuestionThreeB(list, vcross);
		}

	}

	public static boolean QuestionOne(Vector vcross, Vector vzero) {
		if (vcross.equals(vzero)) {
			System.out.println("Points A, B, and C are collinear. Program ending...");
			return true;
		} else {
			System.out.println("Points A, B, and C are NOT collinear. Cross product result: " + vcross + "\nProceeding to part 2...");
			return false;
		}
	}

	public static void QuestionTwo(Point[] list, Vector vcross) {
		int x = list[0].getX();
		int y = list[0].getY();
		int z = list[0].getZ();
		int d = (vcross.getX()*(-x))+(vcross.getY()*(-y))+(vcross.getZ()*(-z));
		System.out.println("The equation of the plane that contains points A, B, and C is: ");
		System.out.println(vcross.getX() + "(x-" + x + ")+(" + vcross.getY() + ")(y-" + y + ")+(" + vcross.getZ() + ")(z-" + z + ") = 0\nor:");
		System.out.println(vcross.getX()+"x+("+vcross.getY()+")y+("+vcross.getZ()+")z + ("+d+") = 0");
	}

	public static void QuestionThree(Point[] list, Vector vcross) {
		//find line intersecting point and plane perpendicularly
		//point D, the 4th point
		int dx = list[3].getX();
		int dy = list[3].getY();
		int dz = list[3].getZ();

		//vcross is the direction vector of the plane
		int vx = vcross.getX();
		int vy = vcross.getY();
		int vz = vcross.getZ();

		//point A, from equation of the plane, is used to find value of T
		int ax = list[0].getX();
		int ay = list[0].getY();
		int az = list[0].getZ();

		//d minus a then times the correlating direction vector component
		int dax = vx*(dx-ax);
		int day = vy*(dy-ay);
		int daz = vz*(dz-az);
		int daxyzTotal = dax+day+daz;

		//value & components of t-parameter
		int tx = vx*vx;
		int ty = vy*vy;
		int tz = vz*vz;
		int txyzTotal = tx+ty+tz;

		double t = (-daxyzTotal)/txyzTotal;

		//point on plane perpendicular intersection components (aka midpoint):
		double mx = vx*t+dx;
		double my = vy*t+dy;
		double mz = vz*t+dz;
		System.out.println("Midpoint: " + mx + " " + my + " " + mz);

		double ex = (mx*2)-dx;
		double ey = (my*2)-dy;
		double ez = (mz*2)-dz;

		System.out.println("Point E: " + ex + " " + ey + " " + ez);

		System.out.println(daxyzTotal);
	}

	public static void QuestionThreeB(Point[] list, Vector vcross) {
		//find line intersecting point and plane perpendicularly
		//point D, the 4th point
		int dx = list[3].getX();
		int dy = list[3].getY();
		int dz = list[3].getZ();

		//vcross is the direction vector of the plane, also doubling as coefficients of T
		int vx = vcross.getX();
		int vy = vcross.getY();
		int vz = vcross.getZ();

		//point A, from equation of the plane, is used to find value of T
		int ax = list[0].getX();
		int ay = list[0].getY();
		int az = list[0].getZ();

		// //perpendicular line intersecting point D and ABC-plane
		// int lx = dx-vx;
		// int ly = dy-vy;
		// int lz = dz-vz;
		//
		// //multiplying perpendicular line components with vector components for solving T
		//
		// int vl1 = vx*lx;
		// int vl2 = vy*ly;
		// int vl3 = vz*lz;
		//
		// //value & components of t
		// int tx = vx*vx;
		// int ty = vy*vy;
		// int tz = vz*vz;
		// int txyzTotal = tx+ty+tz;
		//
		// double t = (-daxyzTotal)/txyzTotal;

		//constant from plane equation after plugging in line to find t
		int d2 = ((dx+(-ax))*vx)+((dy+(-ay))*vy)+((dz+(-az))*vz);

		//D value from plane equation
		// int d = (vcross.getX()*(-ax))+(vcross.getY()*(-ay))+(vcross.getZ()*(-az));

		int dTotal = -d2; //-(d + d2);

		double tCoeffTotal = (vx*vx)+(vy*vy)+(vz*vz);

		double tVal = dTotal / tCoeffTotal;

		double mx = dx + (vx*tVal);
		double my = dy + (vy*tVal);
		double mz = dz + (vz*tVal);

		//Midpoint : (mx, my, mz)
		System.out.println("Midpoint: (" + mx + ", " + my + ", " + mz + ")");

		double ex = (mx*2)-dx;
		double ey = (my*2)-dy;
		double ez = (mz*2)-dz;

		System.out.println("Point E: (" + ex + ", " + ey + ", " + ez + "), symmetric to D about the ABC-plane.");

		// System.out.println(vcross.getX() + " " + vcross.getY() + " " + vcross.getZ() + " ... " + ax + " " + " " + ay + " " + az);
		System.out.println("d2: " + d2 + "\ntCoeffTotal: " + tCoeffTotal + "\ntVal: " + tVal + "\n((dx+ax)*vx)+((dy+ay)*vy)+((dz+az)*vz)\ndx: " + dx + " ax: " + ax + " vx: " + vx + " dy: " + dy + " ay: " + ay + " vy: " + vy + " dz: " + dz + " az: " + az + " vz: " + vz);

	}
}
