package strings;
import java.util.*;

/**
 * @author yiddi
 * 程序意义： 展示如何通过append() 一点一点拼接一个StringBuilder
 */
public class UsingStringBuilder {
	public static Random rand = new Random(47);
	public String toString() {
		StringBuilder result = new StringBuilder("[");
		for (int i = 0; i < 25; i++) {
			result.append(rand.nextInt(100));
			result.append(", ");
		}
		result.delete(result.length() - 2, result.length());// 这一句的目的是删除最后的 ", "
		result.append("]");
		return result.toString();
	}
	public static void main(String[] args) {
		UsingStringBuilder usb = new UsingStringBuilder();
		System.out.println(usb);
	}
}
