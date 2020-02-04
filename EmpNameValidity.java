import java.util.Scanner;
class MyException extends Exception{
	MyException(String m){
		super(m);
	}
}
class EmpNameValidity{
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter first name");
		String fname = scanner.nextLine();
		System.out.println("enter last name");
		String lname = scanner.nextLine();
		try{
			if(fname== null || fname.isEmpty() && lname==null ||lname.isEmpty()){
				throw new MyException("User name is invalid");
			}
		}catch(Exception ex){
			System.out.println("Caught exception");
			System.out.println(ex.getMessage());
		}
	}
}