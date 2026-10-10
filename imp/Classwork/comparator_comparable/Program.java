import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Program {
	public static Employee[] getInstances() {
		Employee[] arr = new Employee[4];
		arr[0] = new Employee(1, "Vis", 200 );
		arr[1] = new Employee(1, "Sagar", 1000.00);
		arr[2] = new Employee(2, "Nilesh", 4000.00);
		arr[3] = new Employee(3, "Aditya", 2000.00);
		return arr;
		
		
	}
	public static void prtEmp(Employee[] arr) {
		for(int i =0; i<arr.length; i++)
			System.out.println(arr[i]);		
	}
	public static int menuList() {
		Scanner scanner = new Scanner(System.in);
		int choice;
		System.out.println("0.Exit");
		System.out.println("1.SortById");
		System.out.println("2.SortByName");
		System.out.println("3.SortBySalary");
		System.out.println("Enter the choice : ");
		choice = scanner.nextInt();	
		return choice;
	}
	public static void main(String[] args) {
//		int choice;
		Employee[] arr = getInstances();
		//A null value indicates that the elements' 
		//natural ordering should be used.
		//we can create reference of the interface and assign subclass object to it
		Comparator<Employee> comparator = null;
		comparator = new SortByid();	
		Arrays.sort(arr, comparator);
		Program.prtEmp(arr);
	}
}
