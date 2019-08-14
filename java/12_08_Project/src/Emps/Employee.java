package Emps;

public class Employee {
	private String fname;
	private String lname;
	private String department;
	
	public Employee() {
		
	}
	
	public Employee(String fn, String ln, String dp) {
		this.fname=fn;
		this.lname=ln;
		this.department = dp;
	}
	
	protected String getDetails() {
		return "First name = "+this.fname+" Last name = "+this.lname+" Department = "+this.department;
	}

}
