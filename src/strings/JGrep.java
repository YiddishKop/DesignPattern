package strings;
import java.io.File;
// {Args: JGrep.java "\\b[Ssct]\\w+"}
import java.util.regex.*;
import net.mindview.util.*;

/**
 * @author yiddi
 * <p>�������壺չʾ�����ͨ�������в���������ʵ�� grep �����ģ�⡣<b>��Ҫ��ʵ���ǰ�
 * �ⲿ�ļ����д���ArrayList������ m.reset(ÿһ��)</b>���Դ�ʵ�ֶ������ı���regexƥ��</p>
 */
public class JGrep {
	public static void main(String[] args) throws Exception{
		if (args.length < 2) {
			System.out.println("Usage: java JGrep file regex");
			System.exit(0);
		}
		Pattern p = Pattern.compile(args[1]);
		int index = 0;
		Matcher m = p.matcher("");
		for (String line : new TextFile(args[0])) {
			m.reset(line);
			while (m.find()) {
				System.out.println(index++ + ": " +
						m.group() + ": " +m.start());
			}
		}
		
		System.out.println("-----------------------����ĳ���չʾ��File�������");
		
		File[] files = new File("e:/txtFileForTesting").listFiles();
		String absPath = new File("e:/txtFileForTesting").getCanonicalPath();
		new File("e:/YUANLONG/IS/SO/SMART").mkdirs();
		new File("e:/txtFileForTesting/YUANLONGIS.txt").createNewFile();
		System.out.println(absPath);
		for (File file : files) {
			System.out.println(file);
		}
	}
}
