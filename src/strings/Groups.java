package strings;
import java.util.regex.*;

/**
 * @author yiddi
 * <p>程序意义：演示Matcher对象基于样本号的操作</p>
 * <p>- m.groupCount() 查询regex中的样本数</p>
 * <p>- m.group() 不带参数的group()返回的是目标文本中下一个被regex匹配的一截字符串</p>
 * <p>- m.group(i) 带参数的group(i)返回的是目标文本中被regex【样本i】匹配的一截字符串</p>
 */
public class Groups {
	static public final String POEM = 
			"Twas brillig, and the slithy toves\n" +
			"Did gyre and gimble in the wabe.\n" +
			"All mimsy were the borogoves,\n" +
			"Beware the Jabberwock, my son,\n" +
			"The jaws that bite, the claws that catch.\n" +
			"Beware the jubjub bird, and shun\n" +
			"The frumious Bandersnatch.";
	public static void main(String[] args) {
		Matcher m = Pattern.compile("(?m)(\\S+)\\s+((\\S+)\\s+(\\S+))$").matcher(POEM);
		while (m.find()) {
			m.group();
			for (int j = 0; j <= m.groupCount(); j++) {
				System.out.println("groupCount: " + j +"[" + m.group(j) + "]");
			}
			System.out.println();
		}
	}
}
