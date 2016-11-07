package typeinfo;
import net.mindview.util.*;

public class Person {
	// final�������ǣ�һ������ʼ��֮�󡻾Ͳ��ɸı�
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
	
	// �����Person�ڲ�������һ����̬�ڲ����ࣺNullPerson
	public static class NullPerson extends Person implements Null {
		private NullPerson() { super("None", "None", "None"); }
		public String toString() { return "NullPerson"; }
	}
	
	/*
	 * �����ṩ��һ��public��ָ��þ�̬�ڲ�����Ķ���
	 * ����������ǡ���������ģ���Ϊ�þ�̬�ڲ������CTOR��private�ģ�ֻ����
	 * �����Լ��ⲿ���в���ʹ�ã�����֮���У���ֻ����һ��
	 * ��ͺ������NULL��Ϊ�����һ�����������ԡ�һ�� 
	 */
	public static final Person NULL = new NullPerson();
	
	public static void main(String[] args) {
		Person p = Person.NULL;
		System.out.println(p);
	}
}
