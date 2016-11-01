class Candy{
	static { System.out.println("Loading Candy");}
	// ��̬��ʼ������ �������౻���ص�ʱ�����һ�Ρ�
}

class Gum{
	static { System.out.println("Loading Gum");}
}

class Cookie{
	static { System.out.println("Loading Cookie");}
}

public class SweetShop {
	/*
	 * HW7: �޸�SweetShop.java, ʹ��ÿ�����Ͷ���Ĵ����������в������ơ��������������
	 * ��  'java Sweetshop Candy' ����ôֻ��Candy���󱻴�����ע���������ͨ�������в���
	 * �����Ƽ����ĸ� Class ����ġ�
	 */
	public static Object createObject(String c) {
		try { // ע�� return �����������ÿ�� try �� catch ���У����� if else ���return
			return Class.forName(c).newInstance();
		} catch (InstantiationException e) {
			System.out.println("Instantiation Failed");
			return null;
		} catch (IllegalAccessException e) {
			System.out.println("Can not access");
			return null;
		} catch (ClassNotFoundException e) {
			System.out.println("Can not find class");
			return null;
		}

	}
	public static void main(String[] args) {		
		Candy c = (Candy)createObject(args[0]);
		// ע�� ��ִ�������е�ʱ�� �����ǲ�����args�ڵ�
		// ���� java SweetShop xxx yyy zzz
		// ���� xxx = args[0]; yyy = args[1]; zzz = args[2];
//		new Candy();
		System.out.println("After creating Candy");
		try {
			Class.forName("Gum");
			// ������䷵��һ�� Class ������
			// �������ĸ������ǣ����Gum��û�м��أ�����ظ��ൽJVM
		}catch(ClassNotFoundException e) {
			System.out.println("Couldn't find Gum");
		}
	
		System.out.println("After Class.forName(\"Gum\")");
		new Cookie();
		System.out.println("After creating Cookie");
	}
}
