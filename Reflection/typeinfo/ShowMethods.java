package typeinfo;
import java.lang.reflect.*;
import java.util.regex.*;
import static net.mindview.util.Print.*;

//{args : ShowMethods}
public class ShowMethods {
	private static String usage = 
			"usage: \n" +
			"ShowMethods qualified.class.name\n" +
			"To show all methods in class or:\n" +
			"ShowMethods qualified.class.name\n" +
			"To search for methods involving 'word'";
	private static Pattern p = Pattern.compile("\\w+\\.");
	
	public static void main(String[] args) {
		if (args.length < 1) {
			print(usage);
			System.exit(0);
		}
		int lines = 0;
		try {
			Class<?> c = Class.forName(args[0]);   // 从命令行参数的字符串获取对应的Class信息
			Method[] methods = c.getMethods();     // 竟然还有 Method 类 和 Constructor 类
			Constructor[] ctors = c.getConstructors();
			if (args.length == 1) {
				for (Method method : methods) {
					System.out.println(p.matcher(method.toString()).replaceAll(""));
				}
				for (Constructor ctor : ctors) {
					System.out.println(p.matcher(ctor.toString()).replaceAll(""));
				}
				lines = methods.length + ctors.length;
			}else {
				for (Method method : methods) {
					if (method.toString().indexOf(args[1]) != -1) {
						System.out.println(p.matcher(method.toString()).replaceAll(""));
						lines++;
					}
				}
				for (Constructor ctor : ctors) {
					if (ctor.toString().indexOf(args[1]) != -1) {
						System.out.println(p.matcher(ctor.toString()).replaceAll(""));
						lines++;
					}
				}
			}
		}catch(ClassNotFoundException e) {
			System.out.println("No such class: " + e);
		}
	}
}
