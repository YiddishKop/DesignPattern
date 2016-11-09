package holding;
import java.util.*;
import typeinfo.pets.*;
import static net.mindview.util.Print.*;

/**
 * @author yiddi
 * �������壺 չ��Map��ǿ�󣬶��󵽶��󼶱�Ĺ���
 * - ������ָ�� key ΪPerson���ͣ�value Ϊ List���ͣ���List�����Ѿ������ٴ�ָ�������Ͳ�����
 * - ����������º�����
 * 	- <map>.keySet()    //���ؼ���Set
 * 	- <map>.entrySet()  //���ؼ�ֵ�Ե�Set
 * 	- <map>.values()    //����ֵ��Collection
 *  - <map>.remove()    //ɾ����ֵ��
 *  - <map>.replace()   //���ļ���ֵ
 */
public class MapOfList {
	public static Map<Person, List<? extends Pet>> // ���棬��Ȼ������������
		petPeople = new HashMap<Person, List<? extends Pet>>();
	static {
		petPeople.put(new Person("Dawn"), Arrays.asList(
				new Cymric("Molly"),
				new Mutt("Spot")));
		petPeople.put(new Person("Kate"), Arrays.asList(
				new Cat("Shackleton"),
				new Cat("Elsie May"),
				new Dog("Margrett")));
		petPeople.put(new Person("Marilyn"), Arrays.asList(
				new Pug("Louie aka Louis Snorkelstein Dupree"),
				new Cat("Stanford aka Stinky el Negro"),
				new Cat("Pinkola")));
		petPeople.put(new Person("Luke"), Arrays.asList(
				new Rat("Fuzzy"),
				new Rat("Fizzy")));
		petPeople.put(new Person("Isaac"), Arrays.asList(
				new Rat("Freckly")));
	}
	public static void main(String[] args) {
		System.out.println(petPeople.entrySet());
		System.out.println("People: " + petPeople.keySet());
		System.out.println("pets: " + petPeople.values());
		for (Person person : petPeople.keySet()) {
			System.out.println(person + " has: ");
			for (Pet pet : petPeople.get(person)) {
				System.out.print("   " + pet);
			}
		}
	}
}