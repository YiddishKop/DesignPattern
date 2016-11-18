package strings;
import static net.mindview.util.Print.*;


/**
 * @author yiddi
 * 程序意义： 展现String的不变性，所有对String做出改变
 * 的操作实际都是【新建String对象】【内容拷贝】,同时介绍
 * 新的字符串操作方法：<String>.toUpperCase();
 */
public class Immutable {
	public static String upcase(String s) {
		return s.toUpperCase();
	}
	public static void main(String[] args) {
		String q = "howdy";
		print(q);
		String qq = upcase(q);
		print(qq);
		print(q);   
	}
}
