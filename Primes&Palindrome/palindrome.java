import java.util.Scanner;

public class palindrome 
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		String s=scan.nextLine();;
		isPalindrome(s);
	}

	public static String reverseString(String s)
	{
		String s1="";
		for(int i=s.length()-1;i>=0;--i)
		{
			s1+=s.charAt(i);
		}
		return s1;
	}
	
	public static void isPalindrome(String s)
	{
		if(s.equals(reverseString(s)))
		{
			System.out.println("Полиндром");
	        }
		else
		{
        		System.out.println("Не полиндром");
        	}
	}
}
