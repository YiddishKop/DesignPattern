/*
 * ����̽�ֵ������ǣ�Reflection �� ���ʿ��ƵĴ�͸��
 *  - ֻҪ�ܻ�ȡ������������ ����ô�Ϳ���ͨ����<ref>.getClass().getDeclareMethod(mehodName);
 *    ����� Method���󣬽���ͨ�� setAccessible() �� invoke(<ref>)�����ı�<ref>����������ķ���Ȩ�ޡ�
 */
package typeinfo;
import typeinfo.interfacea.*;
import typeinfo.packageaccess.*;
import java.lang.reflect.*;

public class HiddenImplementation {
	
	static void callHiddenMethod(Object a, String methodName)throws Exception {
		Method g = a.getClass().getDeclaredMethod(methodName);
		a.getClass();
		g.setAccessible(true); // ����е�ţ�ƣ��ı亯���ķ���Ȩ�ޣ�
		g.invoke(a);
	}
	public static void main(String[] args) throws Exception{
		A a = HiddenC.makeA();
		a.f();
		System.out.println(a.getClass().getName());
		// �������C ���ɼ�
		/*
		 * if(a instanceof C){
		 * 	C c = (C)a;
		 * 	c.g()
		 * }
		 */
		// �������� Refelection ȴ���Է��� g()
		callHiddenMethod(a, "g");
		// �����Ȱ����ʣ����ϸ�ķ��ʿ��Ʒ������ķ��������Է��ʣ� protected/private
		callHiddenMethod(a, "u");
		callHiddenMethod(a, "v");
		callHiddenMethod(a, "w");
	}
}
