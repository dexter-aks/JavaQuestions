package coding.questions;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class CloneableDemo {

	public static void main(String[] args) throws CloneNotSupportedException {
		EmployeeTest e1=new EmployeeTest();
		e1.setEmpId(1);
		e1.setName("Amit");
		Map<String,String> props=new HashMap<>();
		props.put("DepID", "A1");
		props.put("DepName", "CSC");
		e1.setProps(props);
		
		EmployeeTest refCopye1=e1;
		System.out.println(refCopye1+"="+e1+":"+(refCopye1==e1));
		
		EmployeeTest cloneCopye1=(EmployeeTest) e1.clone();
		System.out.println(cloneCopye1+"="+e1+":"+(cloneCopye1==e1));
		
		System.out.println(e1.getProps()+"="+cloneCopye1.getProps()+":"+(e1.getProps()==cloneCopye1.getProps()));
		
		e1.getProps().put("DepID", "B1");
		e1.getProps().put("DepName", "Mech");
		
		System.out.println("cloneCopy1.getProps():"+cloneCopye1.getProps());
		
		e1.setName("Raj");
		System.out.println("cloneCopye1.getName():"+cloneCopye1.getName());
		
		

	}

}

class EmployeeTest implements Cloneable{
	private int empId;
	private String name;
	private Map<String,String> props;
	
	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Map<String, String> getProps() {
		return props;
	}

	public void setProps(Map<String, String> props) {
		this.props = props;
	}

	/*protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}*/
	
	protected Object clone() throws CloneNotSupportedException {
		Object obj=super.clone();
		
		EmployeeTest emp=(EmployeeTest) obj;
		
		emp.setProps(null);
		Map<String,String> hm=new HashMap<>();
		String key;
		Iterator<String> it=this.getProps().keySet().iterator();
		while(it.hasNext()) {
			key=it.next();
			hm.put(key, this.getProps().get(key));
		}
		emp.setProps(hm);
		
		return emp;
	}
}
