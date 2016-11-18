package strings;

/**
 * @author yiddi
 * 程序意义： 展示如何把regex用作参数，因为java中的regex本身就是字符串。
 */
public class Rudolph {
	public static void main(String[] args) {
		for (String pattern : new String[] {"Rudolph",
				"[rR]udolph","[rR][aeiou][a-z]ol.*","R.*"}) { // 还能这么用，神奇
			                                                  // 因为regex在java中以字符串的形式出现
			                                                  // 所以当然可以将其用作参数传递。
			System.out.println("Rudolph".matches(pattern));
		}
	}
}
