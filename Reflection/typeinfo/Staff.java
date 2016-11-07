package typeinfo;
import java.util.*;

public class Staff extends ArrayList<Position>{
	public void add(String title, Person person) {
		add(new Position(title, person)); // 这个是父类ArrayList<Position>的add方法
	}
	
	public void add(String... titles) { // 这种格式的参数表示 0~n 用在这里表示参数可以是“任意数量”的字符串
		for (String title : titles) {
			add(new Position(title)); // 这个是父类ArrayList<Position>的add方法
		}
	}
	
	public Staff(String... titles) { add(titles); }
	public boolean positionAvailable(String title) {
		for (Position position : this) { // 第一次见到这样用的，神奇
			// equals一般表示内容一致，比如字符串， == 表示refer to the same object
			// 但是 equals方法是可以 Override的，实现自己希望的equals方法，是在调用
			// Junit测试时常用的方式，因为 JUnit 测试里的方法会调用这个类的 equals方法
			if (position.getTitle().equals(title) && 
				position.getPerson() == Person.NULL) {
				return true;
			}
		}
		return false;
	}
	public void fillPosition(String title, Person hire) {
		for (Position position : this) {
			if (position.getTitle().equals(title) &&
				position.getPerson() == Person.NULL) {
				position.setPerson(hire);
				return;
			}
		}
		throw new RuntimeException(
				"Position " + title + " not available");
	}
	public static void main(String[] args) {
		Staff staff = new Staff("President", "CTO", 
				"Marketing Manager", "Product Manager",
				"Project Lead", "Software Engineer",
				"Software Engineer", "Software Engineer",
				"Software Engineer", "Test Engineer",
				"Technical Writer");
		staff.fillPosition("President", 
				new Person("Me", "Last", "The Top, Lonely At"));
		staff.fillPosition("Project Lead", 
				new Person("Janet", "Planner", "The Burbs"));
		if (staff.positionAvailable("Software Engineer")) {
			staff.fillPosition("Software Engineer", 
					new Person("Bob", "Coder", "Bright Light City"));
		}
		System.out.println(staff);
	}
}
