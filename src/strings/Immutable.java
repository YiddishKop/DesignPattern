package strings;
import static net.mindview.util.Print.*;


/**
 * @author yiddi
 * �������壺 չ��String�Ĳ����ԣ����ж�String�����ı�
 * �Ĳ���ʵ�ʶ��ǡ��½�String���󡿡����ݿ�����,ͬʱ����
 * �µ��ַ�������������<String>.toUpperCase();
 */
public class Immutable {
	public static String upcase(String s) {
		return s.toUpperCase();
	}
	public static void main(String[] args) {
		String q = "howdy";
		print(q);
		String qq = upcase(q);
		print(qq);
		print(q);   
	}
}
