import java.util.Scanner;

class SelectionSort{
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int arr[] = new int[5];
		System.out.println("enter the array elements");
		for(int i=0;i<5;i++){
			arr[i]= scan.nextInt();
		}
		for(int j=0;j<5;j++){
			for(int k=j+1;k<5;k++){
				if(arr[j]>arr[k]){
					int temp;
					temp=arr[j];
					arr[j]= arr[k];
					arr[k] = temp;
				}
			}
		}
		for(int m=0;m<5;m++){
			System.out.println(arr[m]);
		}
	}
}