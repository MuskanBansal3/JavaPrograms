class Tables{
	public static void main(String[] args){
		int n = Integer.parseInt(args[0]);
		int m = Integer.parseInt(args[1]);
		for(int i=1;i<=m;i++){
			int product=n*i;
			System.out.println(n + "*"+ i + "=" + product);
		}
	}
}