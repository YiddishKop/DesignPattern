package strings;
import java.util.regex.*;

/**
 * @author yiddi
 * <p>程序意义：展示修改编译regex的默认参数</p>
 * <p>最常用的参数有如下两个：</p>
 * <p>- CASE_INSENSITIVE 大小写不敏感，就是不区分大小写</p>
 * <p>- MULTILINE 不声明这个会直接忽略\n，^$表示整个字符串的首尾，而不会管这个字符串到底有几行，
 * 也就是直接忽略\n; 开了之后，^$表示行首行尾，这个简直是必须用，<b>尤其是对外部文件匹配regex时</b></p>
 */
public class ReFlags {
	public static void main(String[] args) {
		Pattern p = Pattern.compile("^java", Pattern.CASE_INSENSITIVE|Pattern.MULTILINE);
		Matcher m = p.matcher("java has regex\nJava has regex\n" +
				              "JAVA has pretty good regular expressions\n" +
				              "Regular expressions are in java");
		while (m.find()) {
			System.out.println(m.group());
		}
	}
}
