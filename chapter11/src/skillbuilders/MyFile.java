package skillbuilders;

import java.io.File;
import java.util.Scanner;

public class MyFile 
{

	public static void main(String[] args) 
	{
		File textFile;
		String path;
		
		Scanner input = new Scanner(System.in);
		
		//Obtain file name from the user
		System.out.println("Enter a file name: ");
		
		//record the user input
		path = input.next();
		
		//Determine if the file exists
		
		textFile = new File(path);
		
		if(textFile.exists())
		{
			System.out.println("File exists.");
		}
		else
		{
			System.out.println("File does not exist.");
		}
		
		

	}

}