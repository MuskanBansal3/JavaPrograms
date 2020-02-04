
import java.util.Scanner;
class AgeException extends Exception{
	public AgeException(){
		super("the age u entered is not valid");
	}
} 


public class AgeChecker{
	public static void main(String[] args) {
		Scanner age = new Scanner(System.in);
		System.out.println("Enter your Age");
		int a = age.nextInt();

	try{
		if(a<15){
			throw new AgeException();
		}
	}
	catch(AgeException ex){
		ex.printStackTrace();
	}
	finally{
		System.out.println("your age is" +a );
	}
	}
}