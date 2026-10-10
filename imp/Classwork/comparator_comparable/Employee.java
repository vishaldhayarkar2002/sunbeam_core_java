import java.util.Comparator;

public class Employee implements Comparable<Employee> {
	private int empid; 
	private String name; 
	private double salary; 
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	public Employee(int empid, String name, double salary) {
		this.empid = empid;
		this.name = name;
		this.salary = salary;
	}
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	@Override
	public String toString() {
		return String.format("%-20d%-15s%-10.2f",empid,name,salary); 
	}
	
	@Override
	public int compareTo(Employee o) {
		return this.empid - o.empid; 
	}
		
}

class SortByid implements Comparator<Employee>{
	@Override
	public int compare(Employee o1, Employee o2) {
		//		return Integer.compare(o1.getEmpid(), o2.getEmpid()); or return o1.getEmpid() - o2.getEmpid();
		return o1.getEmpid() - o2.getEmpid();
	}
}
