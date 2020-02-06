/*@Override
public int compareTo(Object obj){
	return this.getName().compareTo(((Student)obj).getName());
}

@Override
public String toString(){
	return this.getName();
}

-------------------------------------------------------------------------------------------

@Override
public int */
import java.util.*;
import java.lang.*;

class Employee{
	String name;
	int age;
	Employee(String name, int age){
		this.name = name;
		this.age = age;
	}

	public String getName(){
		return this.name;
	}
	public Integer getAge(){
		return this.age;
	}

	@Override
	public String toString(){
		return " (employee: "+ this.getName()
		+ "age: "+ this.getAge()+" )";
	}

}
class SortByFirstName implements java.util.Comparator{
	@Override
	public int compare(Object firstObj, Object secondObj){
		return ((Employee)firstObj).getName().compareTo(((Employee)secondObj).getName());
	}
}
class SortByAge implements Comparator{
	@Override
	public int compare(Object firstObj, Object secondObj){
		return ((Employee)firstObj).getAge().compareTo(((Employee)secondObj).getAge());
	}
}
class SortByLastName implements Comparator{
	@Override
	public int compare(Object firstObj, Object secondObj){
		return ((Employee)firstObj).getName().compareTo(((Employee)secondObj).getName());
	}
}
class EmployeeSort{
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Employee one = new Employee("Muskan Bansal", 21);
		Employee two = new Employee("Yukti Sharma",22);
		Employee three = new Employee("Sakshi Sharma",23);
		List list = new ArrayList();
		list.add(one);
		list.add(two);
		list.add(three);

		System.out.println("enter the name of the employee");
		String name = scan.nextLine();
		String []nameSplit = name.split(" ");
		String firstName = nameSplit[0];
		String lastName = nameSplit[1];
		System.out.println("enter the age of the employee");
		int age = scan.nextInt();
		scan.nextLine();
		list.add(new Employee(name,age));
		System.out.println("Do you want to add more employees?(Y/N)");
		char query = scan.nextLine().charAt(0);
		while(query == 'Y'){
			System.out.println("\n name");
			name = scan.nextLine();
			System.out.println("\n age");
			age = scan.nextInt();
			scan.nextLine();
			System.out.println("Do you want to add more employees?(Y/N)");
			query = scan.nextLine().charAt(0);
		}
		System.out.println("list before sorting"+ list);
		java.util.Collections.sort(list, new SortByAge());
		System.out.println("list after sorting"+list);
		java.util.Collections.sort(list, new SortByFirstName());
		System.out.println("list after name sorting"+list);
	}
}