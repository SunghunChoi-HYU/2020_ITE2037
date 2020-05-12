package lab8;

public class Engineer extends Employee {
	private double rate;
	
	public Engineer(String name, int employeeNum) {
		super(name, employeeNum);
		this.rate = 4.0;
		this.setDepartment("Engineering");
	}
	
	public boolean equals(Object obj) {
		if(obj == null)
			return false;
		else if(getClass() != obj.getClass())
			return false;
		else {
			Engineer otherEngineer = (Engineer)obj;
			return this.name.equals(otherEngineer.name) && this.employeeNum == otherEngineer.employeeNum;
		}
	}
	
	public String toString() {
		return "Name : " + this.name + "\nEmp# : " + this.employeeNum + "\nDept : " + this.getDepartment() + "\n";
	}
	
	public double getPaid() {
		this.salary = this.getWorkHrs() * this.rate;
		return this.salary;
	}
}
