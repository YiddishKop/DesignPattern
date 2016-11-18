package strings;

/**
 * @author yiddi
 * 程序意义： String类内建功能之三(3/3): replaceXXX(regex)
 */
public class Replacing {
	static String s = Splitting.knights;
	public static void main(String[] args) {
		System.out.println(s);
		System.out.println(s.replaceFirst("f\\w+", "*located*"));
		System.out.println(s.replaceAll("shrubbery|tree|herring", "*banana*"));
	}
}
