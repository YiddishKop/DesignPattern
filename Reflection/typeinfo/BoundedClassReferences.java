package typeinfo;

public class BoundedClassReferences {
	public static void main(String[] args) {
		Class<? extends Number> bounded = int.class;
		bounded = double.class;
		bounded = Number.class;
		// int ���� double ���Ǵ� Number ��չ������
		// �����޶� Class���� ������ Ϊ <? extends Number>�����Ϊ int��double
		// ���������κ� 'Number' ������
	}
	public BoundedClassReferences() {
		// TODO Auto-generated constructor stub
	}

}
