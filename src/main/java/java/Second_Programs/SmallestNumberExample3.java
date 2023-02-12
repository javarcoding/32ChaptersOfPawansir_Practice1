package Second_Programs;

public class SmallestNumberExample3 {

	public static void main(String[] args) 
	{
		//initializing numbers to compare  
		int a=101, b=8, c=19;  
		
		//comparing numbers, a with b and a with c   
		//if both conditions are true, prints a  
		if(a<=b && a<=c)
		{
			System.out.println(a+" is the smallest number"); 
		}
			//comparing b with a and b with c  
			//if both conditions are true, prints b  
		else if (b<=a && b<=c)
		{
			System.out.println(b+" is the smallest number");
		}
		else
		{
			//prints c if the above conditions are false  
			System.out.println(c+" is the smallest number");
		}
	}

}
