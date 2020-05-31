public class Primes 
{
    public static void main(String[] args)
    {
	for(int i=2;i<100;i++)
		{
		boolean b=true;
		if(i==2)
			{
			System.out.println("Число 2 - простое число.");
			}
		else
			{
			for(int j=2;j<i;j++)
				{
				if(i%j==0)
					{
					b=false;
					}
				}
			if(b==true)
				System.out.println("Число "+i+" - простое число.");
			}
		}
	}
}