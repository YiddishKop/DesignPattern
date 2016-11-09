package holding;
import java.util.*;
import typeinfo.pets.*;
import static net.mindview.util.Print.*;

/**
 * @author yiddi
 * 程序意义： 展现Map的强大，对象到对象级别的关联
 * - 本程序指明 key 为Person类型；value 为 List类型，且List类型已经可以再次指明“类型参数”
 * - 本程序介绍新函数：
 * 	- <map>.keySet()    //返回键的Set
 * 	- <map>.entrySet()  //返回键值对的Set
 * 	- <map>.values()    //返回值的Collection
 *  - <map>.remove()    //删除键值对
 *  - <map>.replace()   //更改键的值
 */
public class MapOfList {
	public static Map<Person, List<? extends Pet>> // 神奇，竟然可以这样定义
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
