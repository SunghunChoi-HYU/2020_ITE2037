package lab9;

import java.util.Scanner;

public class ExceptionDemo{

	public static void main(String[] args) {
		Employee employee1 = new Employee("Lee");
		Scanner scan = new Scanner(System.in);
		while(true) {
			System.out.print(employee1.getWorkDay() + "���� �ٹ� �ð��� �Է��ϼ��� : ");
			try{
				int workHours = scan.nextInt();
				if(workHours < 0)
					throw new NegativeException();
				else if(workHours == 0)
					throw new Exception("Program Exit");
				else if(workHours > 24)
					throw new TooMuchStuffException(workHours);
				employee1.addWorkHours(workHours);
				employee1.addWorkDay();
				System.out.println("�̸� : " + employee1.getName());
				System.out.println("���� �ٹ� �ð� : " + employee1.getWorkHours());
				System.out.println("No Excpetion has been occurred");
			}
			catch(NegativeException e) {
				System.out.println(e.getMessage());
			}
			catch(TooMuchStuffException e) {
				System.out.println(e.getInputNum() + ", " + e.getMessage());
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
				System.exit(0);
			}
			finally {
				System.out.println("End of try-catch statment");
			}
		}
	}

}
