class Fibonacci{
	public static void main(String[] args){
		int a=0,b=1;
		System.out.println("1");
		for(int i=1;i<20;i++){
			int sum=a+b;
			System.out.println(sum);
			a=b;
			b=sum;
			if(sum>=89){
				break;
			}
		}
	}
}