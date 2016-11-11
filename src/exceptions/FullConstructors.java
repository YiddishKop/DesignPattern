package exceptions;

class MyException extends Exception {
	public MyException() {}
	public MyException(String msg) {
		super(msg);
	}
}

public class FullConstructors {
	public static void f() throws MyException {
		System.out.println("throwing myexception from f()");
		throw new MyException();
	}

	public static void g() throws MyException{
		System.out.println("throwing myexception from g()");
		throw new MyException("Originated in g()");
	}
	public static void h() throws MyException{
		f();
	}
	public static void main(String[] args) {
		try {h();} catch (MyException e1) {e1.printStackTrace();}
		try {f();}catch(MyException e) {e.printStackTrace();}
		try {g();}catch(MyException e) {e.printStackTrace(System.out);}
	}
}

