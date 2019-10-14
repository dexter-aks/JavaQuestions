package coding.questions;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeSet;

public class ComparableComparator implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		TreeSet<String> t=new TreeSet<>();
		
		
		Employee[] empArr = new Employee[4];
		empArr[0] = new Employee(10, "Mikey", 25, 10000);
		empArr[1] = new Employee(20, "Arun", 29, 20000);
		empArr[2] = new Employee(5, "Lisa", 35, 5000);
		empArr[3] = new Employee(1, "Pankaj", 32, 50000);
		
		Arrays.sort(empArr);
		System.out.println(Arrays.toString(empArr));
		
		Arrays.sort(empArr, Employee.IdCompare);
		System.out.println(Arrays.toString(empArr));
		
		Arrays.sort(empArr, Employee.NameCompare);
		System.out.println(Arrays.toString(empArr));

	}


}

class Employee implements Comparable<Employee>{
	private int id;
	private String name;
	private int age;
	private long salary;
	
	public Employee(int id, String name,int age, long salary) {
		this.id = id;
		this.age = age;
		this.salary = salary;
		this.name = name;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public long getSalary() {
		return salary;
	}

	public void setSalary(long salary) {
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", age=" + age + ", salary=" + salary + "]\n";
	}

	@Override
	public int compareTo(Employee o) {
		// TODO Auto-generated method stub
		return (this.age-o.age);
	}

	public static Comparator<Employee> IdCompare=new Comparator<Employee>(){

		@Override
		public int compare(Employee o1, Employee o2) {
			return o1.id-o2.id;
		}
		
	};
	
	public static Comparator<Employee> NameCompare=new Comparator<Employee>(){

		@Override
		public int compare(Employee o1, Employee o2) {
			return o1.name.compareTo(o2.name);
		}
		
		
		
		
	};

		
}
