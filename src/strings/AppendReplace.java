package strings;
import java.util.regex.*;


/**
 * @author yiddi
 * <p>程序意义： 展示如何处理appendReplacement带有样本标签的问题</p>
 */
public class AppendReplace {
	public static String s = 
			"Note that backslashes ( \\ ) \n" + 
			"andxx do$ signs ($) in the replacement string may\n" + 
			"cause the results to be different than if it were\n" + 
			"being treated as a literal replacement string. Dollar\n" + 
			"signs may be treated as references to captured subsequences\n" +
			"as described above, and backslashes are used to escape\n" + 
			"literal characters in the replacement string.";
	public static void main(String[] args) {
		Pattern p = Pattern.compile("^(.{5})\\s(.{3})\\s(\\w+)", Pattern.MULTILINE);
		String sBack = Matcher.quoteReplacement(s);// 如果确定要使用 appendReplacement 最好对目标文本进行一次这个处理
		                                           // 并且使用这个函数返回的字符串作为新的目标文本，因为这样可以避免
		                                           // appendReplacement中的用$1 $2 ... $i 来对应表示group(i)的问题
		                                           // 因为 $ 符号冲突的问题
		Matcher m = p.matcher(sBack);
		StringBuffer sb = new StringBuffer();
		while (m.find()) {
			m.appendReplacement(sb, "$1 xxxxx" + m.group(2).toUpperCase() + " $3");
			
		}
		m.appendTail(sb);
		System.out.println(sb);
	}
}
