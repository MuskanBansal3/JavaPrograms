import java.util.Scanner;
class EmpException extends Exception{
	EmpException(String s){
		super(s);
	}
}
class EmpSalary{
	public static void main(String[] args) {
		System.out.println("Enter the salary");
		Scanner scanner = new Scanner(System.in);
		int salary = scanner.nextInt();
		try{
			if(salary<3000){
				throw new EmpException("salary is not valid");
			}
			else{
				System.out.println("Salary is Valid");
			}
		}catch(Exception ex){
			System.out.println("The salary of employee should not be less than 3000");
		}
	}
}