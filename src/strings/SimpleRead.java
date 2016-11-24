package strings;
import java.io.*;

/**
 * @author yiddi
 * <p>程序意义：从文件或标准输入读取数据并解析</p>
 * <p>- 首先想办法把文件内容or标准输入弄进BufferReader</p>
 * <p>- 之后，利用readLine()将内容读入字符串变量中用于做各种处理</p>
 * <p>- 想获取关键数据，必须使用相对类型的 Integer.parseInt()/Double.parseDouble()。这是非常麻烦的。</p>
 */
public class SimpleRead {
	public static BufferedReader input = new BufferedReader(
			new StringReader("Sir Robin of Camelot\n22 1.61803"));
	public static void main(String[] args) {
		try {
			System.out.println("what is your name?");
			String name = input.readLine(); // readLine的字符串是以 \n 终结的
			System.out.println("name: " + name);
			System.out.println("how old are you? what is your favorite double?");
			System.out.println("(input: <age> <double>)");
			String numbers = input.readLine();
			System.out.println(numbers);
			String[] numArray = numbers.split(" ");
			int age = Integer.parseInt(numArray[0]);
			double favorite = Double.parseDouble(numArray[1]);
			System.out.format("Hi %s.\n", name);
			System.out.format("In 5 years you will be %d.\n", age+5);
			System.out.format("My favorite double is %f.", favorite / 2);
		} catch (Exception e) {
			System.err.println("I/O exception");
		}
	}
}
