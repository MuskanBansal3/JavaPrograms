import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TextFileModify{	
	static void modifyFile(String filePath, String oldString, String newString){
		File fileToBeModified = new File(filePath);	
		String oldContent = "";
		BufferedReader reader = null;
		FileWriter writer = null;
		try{
			reader = new BufferedReader(new FileReader(fileToBeModified));		
			String line = reader.readLine();	
			while (line != null){
				oldContent = oldContent + line + System.lineSeparator();		
				line = reader.readLine();
			}		
			String newContent = oldContent.replaceAll(oldString, newString);						
			writer = new FileWriter(fileToBeModified);			
			writer.write(newContent);
		}
		catch (IOException e){
			e.printStackTrace();
		}
		finally{
			try{
				reader.close();	
				writer.close();
			} 
			catch (IOException e){
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("enter the string to be modified");
		String old = scan.nextLine();
		System.out.println("enter the string to be put in place of the old one..");
		String fresh = scan.nextLine();
		modifyFile("C:/javaprograms/JavaFileInput.txt", old, fresh);
		
		System.out.println("done");
	}
}