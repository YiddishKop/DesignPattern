package holding;
import typeinfo.pets.*;
import java.util.*;

/**
 * @author yiddi
 * 在编写与容器相关的函数时，有两种参数可选：
 * 1. 传入迭代器的引用
 * 2. 传入容器的引用
 * 这两种参数（尤其指Iterator），都可以跟<类型参数>
 * 这两种方式都可以实现一种通用编程的思想
 */
public class InterfaceVsIterator {
	public static void display(Iterator<Pet> it) {  // 迭代器作为参数
		while (it.hasNext()) {
			Pet p = it.next();
			System.out.println(p.id() + ":" + p + " ");
		}
		System.out.println();
	}
	public static void display(Collection<Pet> pets) { // 容器作为参数
		for (Pet p : pets) {
			System.out.println(p.id() + ":" + p + " ");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		List<Pet> petList = Pets.arrayList(8);
		Set<Pet> petSet = new HashSet<Pet>(petList);
		Map<String,Pet> petMap = new LinkedHashMap<String,Pet>();
		String[] names = ("Ralph, Eric, Robin, Lacey, " + "Britney, Sam, Spot, Fluffy").split(", ");
		for (int i = 0; i < names.length; i++) {
			petMap.put(names[i], petList.get(i));
		}
		display(petList);
		display(petSet);
		display(petList.iterator());
		display(petSet.iterator());
		System.out.println(petMap);
		System.out.println(petMap.keySet());
		display(petMap.values());
		display(petMap.values().iterator());
	}

}
