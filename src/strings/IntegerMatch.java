package strings;

/**
 * @author yiddi
 * �������壺String���ڽ�����֮һ(1/3):  matches(regex)
 * String �ַ����Դ��� mathces(<regex>)
 * ����ȷ�����ø÷������ַ����Ƿ�ɱ� regex ƥ��
 */
public class IntegerMatch {
	public static void main(String[] args) {
		System.out.println("-1234".matches("-?\\d+"));
		System.out.println("5678".matches("-?\\d+"));
		System.out.println("+911".matches("-?\\d+"));
		System.out.println("+911".matches("(-|\\+)?\\d+"));
	}
}
