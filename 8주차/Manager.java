package lab8;

public class Manager extends Employee{
	private double overtimeRate;
	private double rate;
	private int regularHrs;
	
	public Manager(String name, int employeeNum) {
		super(name, employeeNum);
		this.rate = 5.0;
		this.overtimeRate = 8.0;
		this.regularHrs = 40;
		this.setDepartment("Management");
	}
	
	public boolean equals(Object obj) {
		if(obj == null)
			return false;
		else if(getClass() != obj.getClass())
			return false;
		else {
			Manager otherManager = (Manager)obj;
			return this.name.equals(otherManager.name) && this.employeeNum == otherManager.employeeNum;
		}
	}
	
	public String toString() {
		return "Name : " + this.name + "\nEmp# : " + this.employeeNum + "\nDept : " + this.getDepartment() + "\n";
	}
	
	public double getPaid() {
		int overtimeHrs = this.workHrs - this.regularHrs;
		if(this.workHrs >= 40)
			this.salary = (this.regularHrs * this.rate) + (overtimeHrs * this.overtimeRate);
		else
			this.salary = this.workHrs * this.rate;
		return this.salary;
	}
}
