package exceptions;

/**
 * @author yiddi
 * 程序意义： 探讨捕获异常后再抛出，会发生什么
 */
public class Rethrowing {
	public static void f() throws Exception {
		System.out.println("originating the exception in f()");
		throw new Exception("thrown from f()");
	}
	public static void g() throws Exception {
		try {
			f();
		} catch (Exception e) {
			System.out.println("Inside g(), e.printStackTrace()");
			e.printStackTrace(System.out);
			throw e;
		}
	}
	public static void h() throws Exception{
		try {
			f();
		} catch (Exception e) {
			System.out.println("Inside h(), e.printStackTrace()");
			e.printStackTrace(System.out);
			throw (Exception)e.fillInStackTrace();
		}
	}
	public static void main(String[] args) {
		try {
			g();
		} catch (Exception e) {
			System.out.println("main: printStackTrace()");
			e.printStackTrace(System.out);
		}
		try {
			h();
		} catch (Exception e) {
			System.out.println("main: printStackTrace()");
			e.printStackTrace(System.out);
		}
	}
}
