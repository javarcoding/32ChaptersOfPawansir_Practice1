package Second_Programs;

public class SmallestNumberExample4 
{
	public static void main(String[] args) 
	{
		//initializing numbers to compare  
		int x = 110, y = 170, z = 169;  
		
		if(x<=y)    
		{  
			if(x<=z)
			{
				//prints x, if the above two conditions are true  
				System.out.println("The smallest number is: "+x);
			}
			else 
			{
				//prints z, if the condition defined in outer if is true and the condition defined in inner if is false  
				System.out.println("The smallest number is: "+z); 
			}
		}   
		else   
		{  
			if(y<=z)
			{
				//prints y, if the condition defined in outer if is false and the condition defined in inner if is true  
				System.out.println("The smallest number is: "+y); 
			}
			else  
			{
				//prints z, if the condition defined in both inner and outer loop is false  
				System.out.println("The smallest number is: "+z); 
			}
		}  
	}

}
