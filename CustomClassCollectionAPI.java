import java.util.*;
class CustomClassCollectionAPI{
	public static void main(String[] args) throws InputMismatchException{
		Scanner scan = new Scanner(System.in);
		int hddSize, ramSize;
		String brand, color,id;
		Computer First = new Computer("HP","Black",500,8,"A1");
		List list = new ArrayList();
		list.add(First);
		list.add(new Computer("HP","Black",256,4,"A2"));
		list.add(new Computer("Sony","Grey",1024,16,"A3"));
		System.out.println("the list is:"+list);	
		System.out.println("do you want to add another record?(Y/N)");
		char ques = scan.next().charAt(0);
		while(ques== 'Y'){
			System.out.println("\n brand:");
			brand = scan.next();
			System.out.println("\n color");
			color = scan.next();
			System.out.println("\n hddSize:");
			hddSize= scan.nextInt();
			System.out.println("\n ramSize:");
			ramSize = scan.nextInt();
			System.out.println("\n id");
			id = scan.next();
			list.add(new Computer(brand,color,hddSize,ramSize,id));
			break;

		}
		System.out.println("enter the parameter that you want to search:");
		System.out.println("1 for brand");
		System.out.println("2 for color");
		System.out.println("3 for hddSize");
		System.out.println("4 for ramSize");
		System.out.println("5 for id");
		int input = scan.nextInt();
		switch(input){
			case 1:
				System.out.println("enter the brand to be searched:");
				brand = scan.next();
				for(Object obj:list){
					if(obj instanceof Computer){
						if(brand==((Computer)obj).getBrand())
							System.out.println(obj);
					}
				}break;
			case 2:
				System.out.println("enter the color to be searched:");
				 color = scan.next();
				for(Object obj:list){
					if(obj instanceof Computer){
						if(color==((Computer)obj).getColor())
							System.out.println(obj);
					}
				}break;
			case 3:
				System.out.println("enter the hddSize to be searched:");
				hddSize = scan.nextInt();
				for(Object obj:list){
					if(obj instanceof Computer){
						if(hddSize==((Computer)obj).getHddSize())
							System.out.println(obj);
					}
				}break;
			case 4:
				System.out.println("enter the ramSize to be searched:");
				ramSize = scan.nextInt();
				for(Object obj:list){
					if(obj instanceof Computer){
						if(ramSize==((Computer)obj).getRamSize())
							System.out.println(obj);
					}
				}break;
			case 5:
				System.out.println("enter the id to be searched:");
				id = scan.next();
				for(Object obj:list){
					if(obj instanceof Computer){
						if(id==((Computer)obj).getID())
							System.out.println(obj);
					}
				}break;
			default:
				System.out.println("not present in list");
				break;
		}
		

		System.out.println("the list is:"+list);
		//System.out.println("enter the value to be searched");
		//String propertyToSearch = scan.next();
		//for(int i=0;i<list.size();i++){
		//	if(list.contains(propertyToSearch)){
		//		System.out.println(list);
		//	}
		//}
		System.out.println("enter the index where u want to delete");
		int index=scan.nextInt();
		list.remove(index);
		System.out.println("the list is:"+list);

	}
}

class Computer{
	String brand,color,id;
	int hddSize, ramSize;

	Computer(String brand,String color, int hddSize, int ramSize, String id){
		this.brand = brand;
		this.color = color;
		this.hddSize = hddSize;
		this.ramSize = ramSize;
		this.id = id;
	}

	public String getColor(){
		return this.color;
	}
	public String getBrand(){
		return this.brand;
	}
	public Integer getRamSize(){
		return this.ramSize;
	}
	public Integer getHddSize(){
		return this.hddSize;
	}
	public String getID(){
		return this.id;
	}
	public String getID(String id){
		return this.id;
	}
	@Override
	public String toString(){
		return "(Computer:"+this.getBrand()
		+" color: "+this.getColor()
		+" hddSize "+this.getHddSize()
		+" ramSize "+this.getRamSize()
		+" id "+this.getID()+")";
	} 


}