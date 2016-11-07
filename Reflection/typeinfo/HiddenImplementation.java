/*
 * 这里探讨的主题是，Reflection 对 访问控制的穿透性
 *  - 只要能获取这个对象的引用 ，那么就可以通过，<ref>.getClass().getDeclareMethod(mehodName);
 *    来获得 Method对象，进而通过 setAccessible() 和 invoke(<ref>)，来改变<ref>对这个函数的访问权限。
 */
package typeinfo;
import typeinfo.interfacea.*;
import typeinfo.packageaccess.*;
import java.lang.reflect.*;

public class HiddenImplementation {
	
	static void callHiddenMethod(Object a, String methodName)throws Exception {
		Method g = a.getClass().getDeclaredMethod(methodName);
		a.getClass();
		g.setAccessible(true); // 这个有点牛逼，改变函数的访问权限？
		g.invoke(a);
	}
	public static void main(String[] args) throws Exception{
		A a = HiddenC.makeA();
		a.f();
		System.out.println(a.getClass().getName());
		// 编译错误：C 不可见
		/*
		 * if(a instanceof C){
		 * 	C c = (C)a;
		 * 	c.g()
		 * }
		 */
		// 但是利用 Refelection 却可以访问 g()
		callHiddenMethod(a, "g");
		// 甚至比包访问，更严格的访问控制符声明的方法都可以访问： protected/private
		callHiddenMethod(a, "u");
		callHiddenMethod(a, "v");
		callHiddenMethod(a, "w");
	}
}
