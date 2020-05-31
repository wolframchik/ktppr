public class Point3d 
{
	private double xCoord;
	private double yCoord;
	private double zCoord;

public Point3d(double x, double y, double z)
{
	xCoord=x;
	yCoord=y;
	zCoord=z;
}

public Point3d() {this(0,0,0);}
public double getX() {return xCoord;}
public double getY() {return yCoord;}
public double getZ() {return zCoord;}
public void setX(double val) {xCoord=val;}
public void setY(double val) {yCoord=val;}	
public void setZ(double val) {zCoord=val;}

public static boolean sravnenie(Point3d Point1, Point3d Point2)
{
if(Point1.xCoord==Point2.xCoord)
	{
	if(Point1.yCoord==Point2.yCoord)
		{
		if(Point1.xCoord==Point2.xCoord)
			{
			return true;
			}
		}
	}
return false;
}

public double distance(Point3d Point1, Point3d Point2)
{
double a=Point1.xCoord-Point2.xCoord;
double b=Point1.yCoord-Point2.yCoord;
double c=Point1.zCoord-Point2.zCoord;
return Math.sqrt(a*a+b*b+c*c);
}

public double ploshad(Point3d Point1, Point3d Point2, Point3d Point3)
{
double a=distance(Point1,Point2);
double b=distance(Point1,Point3);
double c=distance(Point2,Point3);
double p=0.5*(a+b+c);
return Math.sqrt(p*(p-a)*(p-b)*(p-c));
}

}
