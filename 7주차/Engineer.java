package lab7;

public class Engineer extends Employee{
	private String workZone;
	private String project;
	
	public Engineer(String name, int employeeNum, String workZone, String project) {
		super(name, employeeNum, "Engineering");
		this.workZone = workZone;
		this.project = project;
	}
	
	public String toString() {
		return "Name : " + this.getName() + "\nEmp# : " + this.getEmployeeNum() + "\nlocation : " + this.getDepartment() + ", zone : " + this.workZone;
	}
	
	public boolean equals(Object obj) {
		if(obj == null)
			return false;
		else if(getClass() != obj.getClass())
			return false;
		else {
			Engineer otherEmployee = (Engineer)obj;
			return this.getName().equals(otherEmployee.getName()) && this.getEmployeeNum() == otherEmployee.getEmployeeNum() && this.workZone == otherEmployee.workZone;
		}
	}
}
