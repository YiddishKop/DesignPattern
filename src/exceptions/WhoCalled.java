package exceptions;

/**
 * @author yiddi
 * ��������: ����̽����StackTraceElement����ļ��ֳ��÷���
 * StackTraceElement��ʲô�����������ջ�켣�ĵ�λ��Ҳ�������
 * ����һ����װ�˵����������õ���ôһ������
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
