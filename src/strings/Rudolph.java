package strings;

/**
 * @author yiddi
 * �������壺 չʾ��ΰ�regex������������Ϊjava�е�regex��������ַ�����
 */
public class Rudolph {
	public static void main(String[] args) {
		for (String pattern : new String[] {"Rudolph",
				"[rR]udolph","[rR][aeiou][a-z]ol.*","R.*"}) { // ������ô�ã�����
			                                                  // ��Ϊregex��java�����ַ�������ʽ����
			                                                  // ���Ե�Ȼ���Խ��������������ݡ�
			System.out.println("Rudolph".matches(pattern));
		}
	}
}
