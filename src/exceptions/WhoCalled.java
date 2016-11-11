package exceptions;

/**
 * @author yiddi
 * 程序意义: 这里探讨了StackTraceElement对象的几种常用方法
 * StackTraceElement是什么，他就是组成栈轨迹的单位，也可以理解
 * 他是一个包装了单个函数调用的这么一个对象。
 */
public class WhoCalled {
	static void f() {
		try {
			throw new Exception();
		} catch (Exception e) {
			for (StackTraceElement ste : e.getStackTrace()) {
				System.out.println("method: " + ste.getMethodName());
				System.out.println("class: " + ste.getClassName());
				System.out.println("file: " + ste.getFileName());
			}
		}
	}
	static void g() {f();}
	static void h() {g();}
	public static void main(String[] args) {
		f();
		System.out.println("-----------------------");
		g();
		System.out.println("-----------------------");
		h();
	}
}
