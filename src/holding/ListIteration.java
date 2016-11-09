package holding;
import typeinfo.pets.*;
import java.util.*;

/**
 * @author yiddi
 * 程序意义：介绍了更加强大的迭代器---ListIterator,及其操作函数
 *  - 特色： 双向移动、可增删改、可获得索引
 *  - hasNext() / hasPrevious()
 *  - next() / previous()
 *  - nextIndex() itor移动到下一个位置时的index
 *  - previousIndex() 【特殊】当前itor的index，初始为-1
 *  - remove()
 *  - add()
 *  - set() 
 *  - <Collection>.listIterator(n) 
 */
public class ListIteration {
	public static void main(String[] args) {
		List<Pet> pets = Pets.arrayList(8);
		System.out.println(pets);
		ListIterator<Pet> it = pets.listIterator();
		System.out.println(it.nextIndex());
		System.out.println(it.previousIndex());
		while (it.hasNext()) {
			System.out.println(it.next() + ", " + it.nextIndex() + ", " + it.previousIndex() + "; ");
		}
		System.out.println(it);
		System.out.println();
		// 逆向操作
		while (it.hasPrevious()) { 
			System.out.println(it.previous() + " ");//TODO 这里不理解为什么还能访问到末尾元素
			                                        // 难道是因为一旦检测到tail or head iterator就被重置到 next/previous位置？
			                                        // 不管怎么说，虽然费解，但总体来说还算能用的遍历工具
		}
		System.out.println();
		System.out.println(pets);
		it = pets.listIterator(3);  // 这里注释给出的 position in the list
		                            // 而不是 index in the list
		/*
		 * 由下面两句代码可见：
		 * <Collection>.listIterator(n)中的 n 取值范围是[1, length]
		 * 所以参数是位置，不是索引，这里极容易出错，一定注意
		 * iterator索引计数还是从 0 开始
		 */
//		it = pets.listIterator(8); // OK
//		it = pets.listIterator(9); // java.lang.IndexOutOfBoundsException
		while (it.hasNext()) {
			System.out.print(it.next() + " ");
			it.set(Pets.randomPet());
		}
		System.out.println(pets);
	}

}
