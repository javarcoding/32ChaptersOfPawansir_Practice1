package programs;

import java.util.Iterator;

public class SecoundHighestNumber {

	public static void main(String[] args) 
	{
		int array[] = {1,2,3, 4, 11, 12, 13, 14, 21, 22, 23, 24, 31, 32};
		
		int high=0;
		int nexthigh=0;
		
		System.out.println("The given array is::");
		for (int i=0;i<array.length;i++) 
		{
			System.out.print(array[i]+"\t");
			
		}
		
		for (int i=0;i<array.length;i++) 
		{
			if (array[i]>high) 
			{
				nexthigh=high;
				high=array[i];
			}
			else if (array[i]>nexthigh) 
			{
				nexthigh=array[i];
			}
			
		}
		
		System.out.println("Next highest Number is::"+nexthigh);
		System.out.println("Highest Number is::"+high);
		
	}

}
