// ���������ļ����ӣ�������쳣
//{ThrowsException}
package holding;
import java.util.*;

class Apple{
	private static long counter;
	private final long id = counter++;  // һ��static����ʾΪ���������ʾ����������
	                                    // һ��final ����ʶ����id��һ����ʼ�����ɸ��ġ�
	public long id() {return id;}
}

class Orange{}

public class ApplesAndOrangesWithGenerics {
//	@SuppressWarnings("unchecked")    // ���ע����˵��unchecked�쳣���Բ�����
	public static void main(String[] args) {
		ArrayList apples = new ArrayList();
		for (int i = 0; i < 3; i++) {
			apples.add(new Apple());
		}
		// ArrayList������ֹ�����м��� Orange ����
		apples.add(new Orange());
		for (int i = 0; i < 3; i++) {
			/*
			 * ����û��ʹ�÷��ͣ�ָ��������Ԫ�ص����ͣ���
			 * ����ͨ��get��ȡ�Ķ�������������ת��������ʹ���亯��
			 */
			System.out.println(((Apple)apples.get(i)).id()); 
			// Orange ֻ��������ʱ��������
		}
		System.out.println(apples);
	}

}
