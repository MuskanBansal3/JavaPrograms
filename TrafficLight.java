import java.util.Scanner;
class EmpException extends Exception{
	EmpException(String s){
		super(s);
	}
}
class TrafficLight{
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("enter the color");
		String str = scan.nextLine();
		switch(str){
			case "red":
				System.out.println("the vehicles should stop");
				break;
			case "green":
				System.out.println("the vehicles may go");
				break;
			case "yellow":
				System.out.println("the vehicles should be in ready to go state");
				break;
			default:
				System.out.println("nothing to show");

		}
	}
}