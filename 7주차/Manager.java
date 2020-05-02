package lab7;

public class Manager extends Employee {
	private int officeNum;
	private String team;
	
	public Manager(String name, int employeeNum, int officeNum, String team) {
		super(name, employeeNum, "Management");
		this.officeNum = officeNum;
		this.team = team;
	}
	
	public String toString() {
		return "Name : " + this.getName() + "\nEmp# : " + this.getEmployeeNum() + "\nlocation : " + this.getDepartment() + ", office : " + this.officeNum;
	}
	
	public boolean equals(Object obj) {
		if(obj == null)
			return false;
		else if(getClass() != obj.getClass())
			return false;
		else {
			Manager otherEmployee = (Manager)obj;
			return this.getName().equals(otherEmployee.getName()) && this.getEmployeeNum() == otherEmployee.getEmployeeNum() && this.officeNum == otherEmployee.officeNum;
		}
	}
}
