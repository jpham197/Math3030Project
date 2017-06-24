import java.util.Scanner;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) {

		Scanner user = new Scanner(System.in);

		String s = "";
		Point[] list = new Point[4];

		for(int i = 0; i < 4; i++) {
			System.out.println("Enter point " + (i-1) + "'s coordinates");
			System.out.println("x = ?");
			int x = user.nextInt();
			System.out.println("y = ?");
			int y = user.nextInt();
			System.out.println("z = ?");
			int z = user.nextInt();
			list[i] = new Point(x,y,z);
		}

		// for(int a = 0; a < 4; a++) {
		// 	System.out.println("")
		// }
		System.out.println(Arrays.toString(list));
		Vector v = new Vector(0, 0, 0);
		Vector v1 = v.getVector(list[0], list[1]);
		Vector v2 = v.getVector(list[1], list[2]);

		if ( 1> 0) {
			System.out.println("Points A, B, and C are collinear");
		} else {
			System.out.println("Points A, B, and C are not collinear");
		}
	}
}
