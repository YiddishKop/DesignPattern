package strings;
import java.util.*;

/**
 * @author yiddi
 * 程序意义：String类内建功能之二(2/3): split(regex)
 * String.split(regex) 的功能  把字符串【从正则表达式匹配的地方】切开，形成一个字符串数组
 * "切开"的意思: 就像一条纸带，把匹配的部分全部切掉扔了，剩下的部分各自断开的纸带，重新组成数组。匹配的部分都不要了。
 */
public class Splitting {
	public static String knights = 
			"Then, when you have found the shrubbery, you must "+
			"cut down the mightiest tree in the forest... "+
			"with... a herring!";
	public static void split(String regex) {
		System.out.println(Arrays.toString(knights.split(regex))); // 卧槽，Arrays工具类还有这个方法
		                                                           // 可以打印数组，这个之前自己一直用循环的卧槽
	}
	public static void main(String[] args) {
		split("n");
		split("\\W+");
		split("n\\W+");
	}
}
