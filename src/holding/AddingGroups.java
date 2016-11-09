package holding;
import java.util.*;

public class AddingGroups {
	public static void main(String[] args) {
		// Arrays.asList接受一个逗号分隔的列表，将其转为List,并用这个List初始化一个ArrayList对象
		// 但有一点一定一定要注意，Arrays.asList返回的是一个固定容量的list，fixed-size list.
		// 你可以把它(Arrays.asList)作为其他容器的CTOR进行扩容，但是想直接在它(Arrays.asList)上
		// 添加元素是不可以的，一旦函数执行就固定容量了，容量不可改,奇怪的是add不行，连remove也不允许
		// 所以被Arrays.asList()转换后的list，只能执行list.set()方法，换言之，TODO“不可加不可减，只能改”
		// 他和Collection.toArray()一起，充当Array和Collection之间相互转换的桥梁
		Collection<Integer> collection = 
				new ArrayList<Integer>(Arrays.asList(1,2,3,4,5)); 
		Integer[] moreInts = {6, 7, 8, 9, 10};
		// 所有Collection对象都可以把别人的容器元素，全部拷贝到自己的容器中来，
		// 利用<collection引用>.addAll();
		collection.addAll(Arrays.asList(moreInts));
		// 虽然addAll也是[Collections](与Collection不同)这个类的静态方法，但是你不能这么用
		Collections.addAll(collection, 11,12,13,14,15);
		Collections.addAll(collection, moreInts);
		System.out.println(collection);
		
		// 报错： java.lang.UnsupportedOperationException, 经过Array.asList转换后容量不可变
		// System.out.println(Arrays.asList(1,2,3,4).add(3));
		
		// Produces a list "backed by" an array:
		List<Integer> list = Arrays.asList(16,17,18,19,20);
		list.set(1, 99); // OK -- modify an element
		// 报错： java.lang.UnsupportedOperationException，经过Array.asList转换后容量不可变
		// list.remove(0);
		// 报错： java.lang.UnsupportedOperationException，经过Array.asList转换后容量不可变
		// list.add(21); 
	}
}
