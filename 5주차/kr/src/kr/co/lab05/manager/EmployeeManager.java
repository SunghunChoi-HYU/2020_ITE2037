package kr.co.lab05.manager;

import java.time.LocalDate;

import kr.co.lab05.employee.Employee;

public class EmployeeManager {
	public static void main(String[] args) {
		Employee employee1 = new Employee("Choi", 4500);
		LocalDate date = LocalDate.of(2020, 4, 16);
		System.out.println("����� : " + date);
		System.out.println(employee1.toString());
		
		int randomMonth = (int)(Math.random()*12) + 1;
		int cntMonth = 0;
		int cntYear = 1;
		
		while(employee1.getBalance() <= 20000) {
			employee1.receiveSalary();
			cntMonth++;
			date = date.plusMonths(1);
			if(date.getMonthValue() == randomMonth) {
				employee1.receiveSalary();
				System.out.println(cntYear + "���� " + date.getMonthValue()+ "���� �μ�Ƽ�긦 �޾ҽ��ϴ�.");
			}
			if(cntMonth == 12) {
				cntYear++;
				int randomSalaryIncrease = (int)(Math.random() * 10);
				employee1.increaseYearlySalary(randomSalaryIncrease);
				System.out.println(cntYear + "���� ������ " + randomSalaryIncrease + "% �λ�Ǿ����ϴ�.");
				randomMonth = (int)(Math.random()*12) + 1;
				cntMonth = 0;
			}
		}
		System.out.println(date);
		System.out.println(employee1.toString());
	}
}
