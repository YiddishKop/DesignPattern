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
	public String getMessage() { // ���getMessage����������ʲôʱ����õģ�
		return "wwwwwwwwwwwwwwww: " + x + " " + super.getMessage();
	}
}

/**
 * @author yiddi
 * �������壺չʾ����ζ�Exception���и���ϸ����չ��
 * ���� ���� getMessage()������CTOR�����������˽���򣬶Ը��������쳣���м����ȵ�
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
		// ����� Exception �� getMessage()�����ĵ��õأ��༴���캯�����ܵ��ַ���
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
