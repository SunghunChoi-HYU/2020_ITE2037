package lab10;

public class Program {
	public static void main(String[] args) {
		Dog dog = new Dog();
		Tiger tiger = new Tiger();
		Turtle turtle = new Turtle();
		
		Animal[] animal = new Animal[3];
		animal[0] = dog;
		animal[1] = tiger;
		animal[2] = turtle;
		
		Person person = new Person() {
			private int hp = 100;

			public int getHp() {
				return hp;
			}
			public void setHp(int hp) {
				this.hp = hp;
			}
			public void control(Barkable b) {
				if(b.getClass() == tiger.getClass()) {
					this.hp -= 80;
					System.out.println("ȣ���̸� �����߽��ϴ�.");
				}
				else if(b.getClass() == dog.getClass()) {
					this.hp -= 10;
					System.out.println("���� �����߽��ϴ�.");
				}
			}
			public void showInfo() {
				System.out.println("��� HP : " + this.getHp());
			}
			
		};
		
		showResult(animal, person);
	}
	
	private static void showResult(Animal[] animals, Person p) {
		for(int i = 0; i < animals.length; i++) {
			if(animals[i] instanceof Barkable) {
				System.out.println(i+1 +"��° ���� : " + animals[i].getName());
				if(animals[i].getName().equals("��")) {
					Dog newdog = new Dog();
					System.out.println(i+1 + "��° ���� �����Ҹ� : " + newdog.bark());
					p.control(newdog);
				}
				else if(animals[i].getName().equals("ȣ����")) {
					Tiger newtiger = new Tiger();
					System.out.println(i+1 + "��° ���� �����Ҹ� : " + newtiger.bark());
					p.control(newtiger);
				}
				
				p.showInfo();
			}
		}
	}
}
