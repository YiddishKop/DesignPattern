package holding;
import java.util.*;

/**
 * @author yiddi
 * �������壺ͨ����������˽⵽��θ��Լ��������õ�����
 * �Լ��������ĺô�������ֱ�ӵ��� foreach �����ʵ��
 * �����������������Ҳ���Լ����Ƶģ����粽��������ȡ�
 * �������Լ���� itertor()������ͨ���� �ӿ� Iterator
 * ʵ��һ�������ڲ��࣬���������ʵ�֣�
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
