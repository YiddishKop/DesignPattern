package strings;
import java.util.regex.*;

/**
 * @author yiddi
 * <p>�������壺��ʾMatcher������������ŵĲ���</p>
 * <p>- m.groupCount() ��ѯregex�е�������</p>
 * <p>- m.group() ����������group()���ص���Ŀ���ı�����һ����regexƥ���һ���ַ���</p>
 * <p>- m.group(i) ��������group(i)���ص���Ŀ���ı��б�regex������i��ƥ���һ���ַ���</p>
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
