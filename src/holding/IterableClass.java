package holding;
import java.util.*;

/**
 * @author yiddi
 * 程序意义：通过这个程序了解到如何给自己的类配置迭代器
 * 以及迭代器的好处，可以直接调用 foreach 代码块实现
 * 遍历，而且这个遍历也是自己控制的，比如步进，方向等。
 * 都是在自己类的 itertor()方法中通过对 接口 Iterator
 * 实现一个匿名内部类，在这个类中实现：
 * 1. hasNext()
 * 2. next()
 * 3. remove()
 */
public class IterableClass implements Iterable<String>{
	protected String[] words =("And that is how " 
			+ "we know the Earch to be banana-shaped.").split(" ");
	@Override
	public Iterator<String> iterator() {
		return new Iterator<String>() {
			private int index = 0;
			public boolean hasNext() {
				return index < words.length;
			}
			public String next() {return words[index++];}
			public void remove() {
				throw new UnsupportedOperationException();
			}
		};
	}
	public static void main(String[] args) {
		for (String s : new IterableClass()) {
			System.out.println(s+" ");
		}
	}
	
}
