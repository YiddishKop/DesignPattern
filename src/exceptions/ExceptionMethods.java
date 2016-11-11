package exceptions;
import static net.mindview.util.Print.*;

/**
 * @author yiddi
 * 程序意义： 展示了可以打印异 msg 的几种方法
 * 
 */
public class ExceptionMethods {
	public static void main(String[] args) {
		try {
			throw new Exception("My Exception");
		} catch (Exception e) {
			print("Caught Exception");
			print("getMessage(): " + e.getMessage());
			print("getLocalizedMessage(): " + e.getLocalizedMessage());
			print("toString(): " + e);
			print("printStackTrace(): ");
			e.printStackTrace(System.out);
		}
	}
}
