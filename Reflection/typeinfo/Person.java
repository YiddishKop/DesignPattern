package typeinfo;
import net.mindview.util.*;

public class Person {
	// final的意义是，一旦『初始化之后』就不可改变
	public final String first;
	public final String last;
	public final String address;
	// etc.
	
	
	public Person(String first, String last, String address) {
		this.first = first;
		this.last = last;
		this.address = address;
	}
	
	public String toString() {
		return "Person: " + first + " " + last + " " + address;
	}
	
	// 在这个Person内部定义了一个静态内部子类：NullPerson
	public static class NullPerson extends Person implements Null {
		private NullPerson() { super("None", "None", "None"); }
		public String toString() { return "NullPerson"; }
	}
	
	/*
	 * 并且提供了一个public域指向该静态内部子类的对象
	 * 这毫无疑问是“结过扎”的，因为该静态内部子类的CTOR是private的，只能在
	 * 该类以及外部类中才能使用，换言之，有，且只有这一个
	 * 这就好像这个NULL称为该类的一个“固有属性”一样 
	 */
	public static final Person NULL = new NullPerson();
	
	public static void main(String[] args) {
		Person p = Person.NULL;
		System.out.println(p);
	}
}
