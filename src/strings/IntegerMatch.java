package strings;

/**
 * @author yiddi
 * 程序意义：String类内建功能之一(1/3):  matches(regex)
 * String 字符串自带的 mathces(<regex>)
 * 用来确定调用该方法的字符串是否可被 regex 匹配
 */
public class IntegerMatch {
	public static void main(String[] args) {
		System.out.println("-1234".matches("-?\\d+"));
		System.out.println("5678".matches("-?\\d+"));
		System.out.println("+911".matches("-?\\d+"));
		System.out.println("+911".matches("(-|\\+)?\\d+"));
	}
}
