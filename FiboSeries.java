import java.util.Scanner;
class NumException extends Exception{
	NumException(String a){
		super(a);
	}
}
class FiboSeries{
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("enter the last value of the fibonacci series");
		int ctrl = scan.nextInt();
		try{
			if(ctrl<0){
				throw new NumException("the input given is invalid");
			}
			else{
				System.out.println("FiboSeries of "+ctrl + "numbers");
				for(int i=0;i<ctrl;i++){
					System.out.println(fibonacciSeries(i) +" ");
				}
			}
		}catch(Exception ex){
			System.out.println("Exception: only positive inputs are allowed");
		}
	}
		static int fibonacciSeries(int m){
			if(m==0){
				return 0;
			}
			if(m==1|| m==2){
				return 1;
			}
			return fibonacciSeries(m-2) + fibonacciSeries(m-1);
		}
	
}