package exceptions;
import static net.mindview.util.Print.*;

class MyException2 extends Exception{
	private int x;
	public MyException2() {}
	public MyException2(String msg) {
		super(msg);
	}
	public MyException2(String msg, int x) {
		super(msg);
		this.x = x;
	}
	public int val() {
		return x;
	}
	public String getMessage() { // 这个getMessage方法到底是什么时候调用的？
		return "wwwwwwwwwwwwwwww: " + x + " " + super.getMessage();
	}
}

/**
 * @author yiddi
 * 程序意义：展示了如何对Exception进行更详细的扩展，
 * 比如 更改 getMessage()，更改CTOR，加入计数的私有域，对该种类型异常进行计数等等
 */
public class ExtraFeatures {
	public static void f() throws MyException2 {
		System.out.println("Throw exception from f()");
		throw new MyException2();
	}
	public static void g() throws MyException2 {
		System.out.println("Throw exception from g()");
		throw new MyException2("Originated in g()");
	}
	public static void h() throws MyException2 {
		System.out.println("Throw exception from h()");
		throw new MyException2("Originated in h()", 47); 
		// 这就是 Exception 的 getMessage()方法的调用地，亦即构造函数接受的字符串
	}
	public static void main(String[] args) {
		try {
			f();
		} catch (MyException2 e) {
			e.printStackTrace(System.out);
		}
		try {
			g();
		} catch (MyException2 e) {
			e.printStackTrace(System.out);
		}
		try {
			h();
		} catch (MyException2 e) {
			e.printStackTrace(System.out);
			System.out.println("e.val() " + e.val());
		}
	}
}
