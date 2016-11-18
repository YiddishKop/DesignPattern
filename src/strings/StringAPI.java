package strings;
import java.util.*;
/**
 * @author yiddi
 *
 */
public class StringAPI {
	public static void tryCtors() {
		// 尝试String的几种构造方法
		// 通过 StringBuilder StringBuffer char[] byte[] 创建String对象
		ArrayList<String> als = new ArrayList<String>();
		als.add(new String());
		als.add(new String("111"));
		als.add(new String(new StringBuilder()));
		als.add(new String(new StringBuffer()));
		als.add(new String(new char[] {'a','b','c'}));
		als.add(new String(new byte[] {1,2,3,4}));
		System.out.println(als);
	}
	public static void main(String[] args) {
		tryCtors();
		String s = new String("this is a test String");
		System.out.println("index 3 should be s, now is : " + s.charAt(3)); // 应该是s
		char[] dst = new char[10];
		s.getChars(0, 6, dst, 2); // from 0 to 6, but not include 6
		System.out.println(dst);
		System.out.println(s.toCharArray());
		String s_up = new String(s.toUpperCase());
		System.out.println(s.equalsIgnoreCase(s_up));
		System.out.println(s.compareTo(s_up));
		System.out.println((int)'a');
		System.out.println((int)'A');
		System.out.println(String.valueOf(s));
		System.out.println(s.replace('i', 'I'));
	}
	public StringAPI() {
		// TODO Auto-generated constructor stub
	}

}
