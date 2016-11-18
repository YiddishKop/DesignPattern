package strings;
import java.util.regex.*;
import static net.mindview.util.Print.*;

/**
 * @author yiddi
 * <p>程序意义： 利用 java.util.regex包的Pattern和Matcher类实现regex功能</p>
 * <p>{args: abcabcabcdefabc "abc+" "(abc)+" "(abc){2,}"}</p>
 * <p>m.find()  --- 尝试匹配，成功返回true，失败返回false</p>
 * <p>m.group() --- 目标文本中被匹配的一段字符串</p>
 * <p>m.start() --- 该次成功匹配的目标文本的起始index</p>
 * <p>m.end()   --- 该次成功匹配的目标文本的中止位置（如果中止index，需要在此基础上 - 1）</p>
 */
public class TestRegularExpression {
	public static void main(String[] args) {
		if (args.length < 2) {
			System.out.println("usage: \njava TestRegularExpression " + "characterSequence regularExpression+");
			System.exit(0);
		}
		System.out.println("Input: \"" + args[0] + "\"");
		for (String arg : args) {
			System.out.println("Regular expression: \"" + arg + "\"");
			Pattern p = Pattern.compile(arg);
			Matcher m = p.matcher(args[0]);
			System.out.println("m.matcher(): " + m.matches());
			m.lookingAt();
			m.reset();
			while (m.find()) {
				System.out.println("Match \"" + m.group() + "\" at positions " + m.start() + "-" + (m.end() -1));
			}
		}
	}

}
