package strings;
import java.io.File;
// {Args: JGrep.java "\\b[Ssct]\\w+"}
import java.util.regex.*;
import net.mindview.util.*;

/**
 * @author yiddi
 * <p>程序意义：展示了如何通过命令行参数的输入实现 grep 命令的模拟。<b>主要的实现是把
 * 外部文件分行存入ArrayList，而后 m.reset(每一行)</b>，以此实现对整个文本的regex匹配</p>
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
		
		System.out.println("-----------------------下面的程序展示了File类的作用");
		
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
