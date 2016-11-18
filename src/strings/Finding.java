package strings;
import java.util.regex.*;

/**
 * @author yiddi
 * <p>程序意义： 解释Matcher类的两种find方法</p>
 * <p>- 一种是不带参数find，类似迭代器，每一次为true时，可使用group/start/end方法</p>
 * <p>- 一种是带参数的find，可以指定从目标文本的什么位置开始匹配regex</p>
 * <p>- m.group() 不带参数的group()函数返回的是目标文本中下一个被regex匹配的一截字符串</p>
 */
public class Finding {
	public static void main(String[] args) {
//		String s = "Evening is full of the linnet's wings";
		String s = "abcabcabcd";
		System.out.println("String length: " + s.length());
		Matcher m = Pattern.compile("(abc){1}").matcher(s);
		while (m.find()) {
			System.out.println(m.group() + " ");
		}
		System.out.println("-----------------------");
		int i = 0;
		while (m.find(i)) {
			System.out.println(m.group() + " ");
			i++;
		}
		System.out.println(i);
	}
}
