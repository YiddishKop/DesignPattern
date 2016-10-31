public class StaticBlock {
	public static void main(String args[]) {
		for (int i = 0; i < 5; i++) {
			new Duck();
		}
		
		for (int i = 0; i < 5; i++) {
			Goose.myInt++;    // static initialization block
			Goose.myMethod(); // static initialization block
			new Goose();      
			// ��������䶼��ִ��,���� static initialization block ����ִ��һ��
			// ԭ����static initialization �������౻����ʱִ�С�������ʱ�౻�����أ�
			// ���� JVM ���������ڣ�ÿ��������ᱻ����һ�Σ������ڸ�����ʾ�̬����or����ʱ
			// CTORҲ�Ǿ�̬������
		}
	}
}

class Duck{
	{ System.out.println("Duck");}
}

class Goose{
	static int myInt = 0;
	static { System.out.println("Goose");} // only invoked once
	static void myMethod() {myInt++;}
}