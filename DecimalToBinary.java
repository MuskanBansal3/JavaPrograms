class DecimalToBinary{
	public static void main(String[] args){
		int decimal = Integer.parseInt(args[0]);
		int binary;
		System.out.println("the binary equivalent is");
		for(int i=decimal;i>0;){
			binary=i%2;
			i=i/2;
			System.out.println(binary+ " ");
		}
	}
}