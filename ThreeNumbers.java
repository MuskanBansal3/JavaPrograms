class ThreeNumbers{
	public static void main(String[] args){
		int firstNum = Integer.parseInt(args[0]);
		int secondNum = Integer.parseInt(args[1]);
		int thirdNum = Integer.parseInt(args[2]);
		int sum = firstNum + secondNum + thirdNum;
		if(firstNum>=40){
			if(secondNum>=40){
				if(thirdNum>=40){
					if(sum>=125){
						System.out.println("PASSING");
					}
				}
			}
		}
		else
			System.out.println("FAILING");
	//	if(firstNum>=40 && secondNum>=40 && thirdNum>=40 && sum>=125){
	//		System.out.println("PASSING");
	//	}
	//	else
	//		System.out.println("FAILING");
	}
}