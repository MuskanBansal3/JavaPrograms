class Factorial{
	public static void main(String[] args){
		int a;
		a = Integer.parseInt(args[0]);
		int b=1;
		for(int i=1;i<=a;i++){
			b=b*i;
		}
		System.out.println("Factorial of"+ a +"is" + b);
	}
}