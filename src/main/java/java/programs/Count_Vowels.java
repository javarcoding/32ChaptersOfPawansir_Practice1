package programs;

import java.util.Iterator;

public class Count_Vowels {

	public static void main(String[] args)
	{
		
		String str= "BeginnersBook";
		int vcount=0, ccount=0;
		
		//Converting all the chars to lowercase
		
		str=str.toLowerCase();
		
		for (int i=0; i< str.length();i++ )
		{
			char ch=str.charAt(i);
			
			if (ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u') 
			{
				vcount++;
			}
			else if (ch>='a' && ch<='z') 
			{
				ccount++;
			} 
			
		}
		System.out.println("Number of Vowel:"+vcount);
		System.out.println("Number of constant:"+ccount);
		
		
	}

}
