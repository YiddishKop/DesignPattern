package strings;
import java.util.regex.*;
import static net.mindview.util.Print.*;

/**
 * @author yiddi
 * <p>�������壺 ���� java.util.regex����Pattern��Matcher��ʵ��regex����</p>
 * <p>{args: abcabcabcdefabc "abc+" "(abc)+" "(abc){2,}"}</p>
 * <p>m.find()  --- ����ƥ�䣬�ɹ�����true��ʧ�ܷ���false</p>
 * <p>m.group() --- Ŀ���ı��б�ƥ���һ���ַ���</p>
 * <p>m.start() --- �ôγɹ�ƥ���Ŀ���ı�����ʼindex</p>
 * <p>m.end()   --- �ôγɹ�ƥ���Ŀ���ı�����ֹλ�ã������ֹindex����Ҫ�ڴ˻����� - 1��</p>
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
