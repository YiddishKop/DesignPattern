package strings;
import java.util.*;
import java.util.regex.Pattern;

/**
 * @author yiddi
 * <p>程序意义：展示 Scanner 对于处理外部文件输入并解析出关键数据的巨大作用</p>
 * <p>- scanner.nextLine()/nextInt()/nextDouble()不需要用特定类型去parse这么麻烦</p>
 */
public class BetterRead {
	public static void main(String[] args) {
		Scanner stdin = new Scanner(SimpleRead.input);
		System.out.println("what is your name?");
		String name = stdin.nextLine();
		System.out.println(name);
		System.out.println(
				"How old are you? what is your favorite double?");
		System.out.println("(input: <age><double>)");
		int age = stdin.nextInt();
		double favorite = stdin.nextDouble();
		System.out.println(age);
		System.out.println(favorite);
		System.out.format("Hi %s.\n", name);
		System.out.format("In 5 years you will be %d.\n", age + 5);
		System.out.format("My favorite double is %f.", favorite / 2);
	}
}
