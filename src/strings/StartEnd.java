package strings;
import java.util.regex.*;
import static net.mindview.util.Print.*;

/**
 * @author yiddi
 * <p>程序意义： 通过对同一段目标文字，用 find/lookingAt/matches 三种方法去标定，来说明三种标定方法的不同：</p>
 * <p>- find() 可以从任意位置开始只要匹配regex就标定（选中）</p>
 * <p>- lookingAt() 只从目标文字开头匹配，匹配的上就标定</p>
 * <p>- matches() 只有整个目标文字完全匹配regex才成功标定</p>
 */
public class StartEnd {
	public static String input =  
			"As long as there is injustice, whenever a\n" +
		    "Targathian baby cries out, wherever a distress\n" +
		    "signal sounds among the stars ... We'll be there.\n" +
		    "This fine ship, and this fine crew ...\n" +
		    "Never give up! Never surrender!";
	private static class Display{
		private boolean regexPrinted = false;
		private String regex;
		Display(String regex){this.regex = regex;}
		void display(String message) {
			if (!regexPrinted) {
				System.out.println(regex);
				regexPrinted = true;
			}
			System.out.println(message);
		}
	}
	static void examine(String s, String regex) {
		Display d = new Display(regex);
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(s);
		while(m.find()) {
			d.display("find()'" + m.group() + "' start = " + m.start() + " end = " + m.end());
		}
		if (m.lookingAt()) {
			d.display("lookingAt() start = " + m.start() + " end = " + m.end());
		}
		if (m.matches()) {
			d.display("matches() start = " + m.start() + " end = " + m.end());
		}
	}
	public static void main(String[] args) {
		for (String in : input.split("\n")) {
			System.out.println("input: " + in);
			for (String regex : new String[] {"\\w*ere\\w*", "\\w*ever", "T\\w+", "Never.*?!"}) {
				examine(in, regex);
			}
		}
	}
}
