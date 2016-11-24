package strings;
import java.io.*;

/**
 * @author yiddi
 * <p>�������壺���ļ����׼�����ȡ���ݲ�����</p>
 * <p>- ������취���ļ�����or��׼����Ū��BufferReader</p>
 * <p>- ֮������readLine()�����ݶ����ַ������������������ִ���</p>
 * <p>- ���ȡ�ؼ����ݣ�����ʹ��������͵� Integer.parseInt()/Double.parseDouble()�����Ƿǳ��鷳�ġ�</p>
 */
public class SimpleRead {
	public static BufferedReader input = new BufferedReader(
			new StringReader("Sir Robin of Camelot\n22 1.61803"));
	public static void main(String[] args) {
		try {
			System.out.println("what is your name?");
			String name = input.readLine(); // readLine���ַ������� \n �ս��
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
