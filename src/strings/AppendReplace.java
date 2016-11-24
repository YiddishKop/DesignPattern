package strings;
import java.util.regex.*;


/**
 * @author yiddi
 * <p>�������壺 չʾ��δ���appendReplacement����������ǩ������</p>
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
		String sBack = Matcher.quoteReplacement(s);// ���ȷ��Ҫʹ�� appendReplacement ��ö�Ŀ���ı�����һ���������
		                                           // ����ʹ������������ص��ַ�����Ϊ�µ�Ŀ���ı�����Ϊ�������Ա���
		                                           // appendReplacement�е���$1 $2 ... $i ����Ӧ��ʾgroup(i)������
		                                           // ��Ϊ $ ���ų�ͻ������
		Matcher m = p.matcher(sBack);
		StringBuffer sb = new StringBuffer();
		while (m.find()) {
			m.appendReplacement(sb, "$1 xxxxx" + m.group(2).toUpperCase() + " $3");
			
		}
		m.appendTail(sb);
		System.out.println(sb);
	}
}
