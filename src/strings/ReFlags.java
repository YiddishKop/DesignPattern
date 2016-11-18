package strings;
import java.util.regex.*;

/**
 * @author yiddi
 * <p>�������壺չʾ�޸ı���regex��Ĭ�ϲ���</p>
 * <p>��õĲ���������������</p>
 * <p>- CASE_INSENSITIVE ��Сд�����У����ǲ����ִ�Сд</p>
 * <p>- MULTILINE �����������ֱ�Ӻ���\n��^$��ʾ�����ַ�������β�������������ַ��������м��У�
 * Ҳ����ֱ�Ӻ���\n; ����֮��^$��ʾ������β�������ֱ�Ǳ����ã�<b>�����Ƕ��ⲿ�ļ�ƥ��regexʱ</b></p>
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
