import java.io.*;
import java.util.Scanner;

public class Lab1

	{

	public static void main(String[] args)
		{

		System.out.println("3 points: ");
		Scanner in = new Scanner(System.in);
		double x1 = in.nextInt();
		double y1 = in.nextInt();

		double z1 = in.nextInt();
		double x2 = in.nextInt();
		double y2 = in.nextInt();
		double z2 = in.nextInt();
		double x3 = in.nextInt();

		double y3 = in.nextInt();

		double z3 = in.nextInt();



		Point3d point1 = new Point3d(x1, y1, z1);

		Point3d point2 = new Point3d(x2, y2, z2);
		Point3d point3 = new Point3d(x3, y3, z3);

		double answer = computeArea(point1, point2, point3);

		System.out.println("Answer is " +answer);
		}
	public static double computeArea (Point3d val1, Point3d val2, Point3d val3)
		{
		if (val1.equals(val2) || val2.equals(val3) || val3.equals(val1))
			System.out.print("Error");

		double a = val1.distance(val1,val2);

		double b = val3.distance(val2,val3);

		double c = val1.distance(val1,val3);

		double p=0.5*(a+b+c);
return Math.sqrt(p*(p-a)*(p-b)*(p-c));
		}


	
}
