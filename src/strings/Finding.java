package strings;
import java.util.regex.*;

/**
 * @author yiddi
 * <p>�������壺 ����Matcher�������find����</p>
 * <p>- һ���ǲ�������find�����Ƶ�������ÿһ��Ϊtrueʱ����ʹ��group/start/end����</p>
 * <p>- һ���Ǵ�������find������ָ����Ŀ���ı���ʲôλ�ÿ�ʼƥ��regex</p>
 * <p>- m.group() ����������group()�������ص���Ŀ���ı�����һ����regexƥ���һ���ַ���</p>
 */
public class Finding {
	public static void main(String[] args) {
//		String s = "Evening is full of the linnet's wings";
		String s = "abcabcabcd";
		System.out.println("String length: " + s.length());
		Matcher m = Pattern.compile("(abc){1}").matcher(s);
		while (m.find()) {
			System.out.println(m.group() + " ");
		}
		System.out.println("-----------------------");
		int i = 0;
		while (m.find(i)) {
			System.out.println(m.group() + " ");
			i++;
		}
		System.out.println(i);
	}
}
