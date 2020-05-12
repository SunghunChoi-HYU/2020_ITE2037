package lab8;

public abstract class Employee {
	protected String name;
	protected int employeeNum;
	private String department;
	protected int workHrs;
	public double salary;
	
	public Employee(String name, int employeeNum) {
		this.name = name;
		this.employeeNum = employeeNum;
		this.workHrs = 0;
		this.salary = 0;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
	
	public int getWorkHrs() {
		return workHrs;
	}

	public boolean equals(Object obj) {
		if(obj == null)
			return false;
		else if(getClass() != obj.getClass())
			return false;
		else {
			Employee otherEmployee = (Employee)obj;
			return this.name.equals(otherEmployee.name) && this.employeeNum == otherEmployee.employeeNum;
		}
	}
	
	public String toString() {
		return "Name : " + this.name + "\nEmp# : " + this.employeeNum + "\n";
	}
	
	public void doWork(int hrs) {
		this.workHrs += hrs;
		getPaid();
	}
	
	public abstract double getPaid();
	
	public boolean equalPay(Employee emp) {
		return this.salary == emp.salary;
	}
}
