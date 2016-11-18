package strings;
import java.util.*;

/**
 * @author yiddi
 * �������壺String���ڽ�����֮��(2/3): split(regex)
 * String.split(regex) �Ĺ���  ���ַ�������������ʽƥ��ĵط����п����γ�һ���ַ�������
 * "�п�"����˼: ����һ��ֽ������ƥ��Ĳ���ȫ���е����ˣ�ʣ�µĲ��ָ��ԶϿ���ֽ��������������顣ƥ��Ĳ��ֶ���Ҫ�ˡ�
 */
public class Splitting {
	public static String knights = 
			"Then, when you have found the shrubbery, you must "+
			"cut down the mightiest tree in the forest... "+
			"with... a herring!";
	public static void split(String regex) {
		System.out.println(Arrays.toString(knights.split(regex))); // �Բۣ�Arrays�����໹���������
		                                                           // ���Դ�ӡ���飬���֮ǰ�Լ�һֱ��ѭ�����Բ�
	}
	public static void main(String[] args) {
		split("n");
		split("\\W+");
		split("n\\W+");
	}
}
