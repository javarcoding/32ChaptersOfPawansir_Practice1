package programs;

public class Extract_word_from_String {

	public static void main(String[] args) 
	{
		String str = "Hey this is Ram";
		String [] words = str. split(" ");
		for (String word :words )
		System. out. println(word);
	}

}
