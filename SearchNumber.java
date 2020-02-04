import java.util.Scanner;

class SearchNumber{
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int []arr = new int[10];
		System.out.println("enetr 10 integers ");
		for(int i=0;i<10;i++){
			arr[i]= scan.nextInt();
		}
		System.out.println("enter the number to be searched");
		int val = scan.nextInt();
		int f=0;
		// = input.nextInt();
		for(int i=0;i<10;i++){
			if(arr[i] == val){
				System.out.println(i+" "+val);
				f=1;
				break;
			}
			else
				continue;
		}
		if(f==0)
		{
			System.out.println("not found");
		}


	}
}