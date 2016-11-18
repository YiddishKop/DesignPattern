package strings;

/**
 * @author yiddi
 * �������壺ͨ��javap -c <.class> �������۲�ײ������δ��� string + string ��
 * - ������ string + string ��Ȼ��ʹ�� StringBuilder.append()����
 * - ����ÿ�� + �����½�һ�� StringBuilder ����(�е���̬���飬һ�����������������µģ�)��������Ч�ʼ���
 * - ��ֱ��ʹ�� StringBuilder �����Ԥ��ָ��������С���Դ˱����ظ��½�StringBuilder����
 * - �����ǣ������Լ����е�toString()���������Ҫ�õ�ѭ������ô�����Լ���StringBuilder��ʵ�ְ�
 */
public class WhitherStringBuilder {
	public String implicit(String[] fields) {
		String result = "";
		for (int i = 0; i < fields.length; i++) {
			result += fields[i];
		}
		return result;
	}
	public String explicit(String[] fields) {
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < fields.length; i++) {
			result.append(fields[i]);
		}
		return result.toString();
	}
	public WhitherStringBuilder() {
		// TODO Auto-generated constructor stub
	}

}
