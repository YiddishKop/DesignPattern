package holding;
import typeinfo.pets.*;
import java.util.*;
import static net.mindview.util.Print.*;

/**
 * @author yiddi
 * 程序意义：Map中如何“搭建”对象间的关系
 * 本程序的“关系”是：用String来描述Pet
 *  - HashMap 不按插入顺序存储，但是适合快速查找
 *  - TreeMap 不按插入顺序存储，会自动排序
 *  - LinkedHashMap 按照插入顺序存储
 */
public class PetMap {
	public static void main(String[] args) {
		Map<String,Pet> petMap = new HashMap<String,Pet>();
		petMap.put("My Cat", new Cat("Molly"));
		petMap.put("My Dog", new Dog("Ginger"));
		petMap.put("My Hamster", new Hamster("Bosco"));
		System.out.println(petMap);
		Pet dog = petMap.get("My Dog");
		System.out.println(dog);
		System.out.println(petMap.containsKey("My Dog"));
		System.out.println(petMap.containsValue(dog));
	}
}
