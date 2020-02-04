import java.util.Scanner;
class NewException extends Exception{
	NewException(String p){
		super(p);
	}
}

class PrimeNumberToN{
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("enter max number");
		int maxNumber = scan.nextInt();
		try{
			if(maxNumber<0){
				throw new NewException("input is invalid");
			}
			else{
				for(int i=2;i<=maxNumber;i++){
					int num = 0;
					for(int j=2;j<i;j++){
						if(i%j==0){
							num++;
							break;
						}
					}
					if(num==0){
						System.out.println(i);
					}
				}
			}
		}catch(Exception ex){
			System.out.println("Exception - input is invalid");
		}
	}
}