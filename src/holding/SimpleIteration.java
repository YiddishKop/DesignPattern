package holding;
import typeinfo.pets.*;
import java.util.*;

public class SimpleIteration {
	/*
	 * 使用 Iterator的三个步骤：
	 *  1. 声明 Iterator
	 *  2. 用 <Collection>.iterator() 进行初始化
	 *  3. 调用 Iterator.hasNext()/.next()/.remove()
	 */
	// 通过下面的例子可以看来，Iterator有点像是Collection的指针，初始位置在-1.
	// 当确定 hasNext的时候，it.next()虽然返回一个元素，但更像是指针指向下一个位置
	// 同时，remove也只能remove当前的iterator指向的位置的元素。而且只能执行一次。
	public static void main(String[] args) {
		List<Pet> pets = Pets.arrayList(12);
		Iterator<Pet> it = pets.iterator();
		while (it.hasNext()) {
			Pet p = it.next();
			System.out.println(p.id() + ":" + p + " ");
		}
		System.out.println();
		// A simpler apporach, when possible:
		for (Pet p : pets) {
			System.out.println(p.id() + ":" + p + " ");
		}
		System.out.println();
		it = pets.iterator();
		for (int i = 0; i < 6; i++) {
			it.next();
			it.remove();
		}
		System.out.println(it.next());
		System.out.println(pets);
	}
}
