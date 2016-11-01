package typeinfo.toys;

interface HasBatteries{}
interface Waterproof{}
interface Shoots{}
interface YuanLong{}

class Toy{
	Toy() {}   
	// �����ͨ�� newInstance() ������ Toy �����������Ĭ�ϵ� constructor
	// ��������ʵ����ʧ���쳣
	// TODO ͨ�� Java �ķ��书�� API ���԰����������� --- ������Ĺ���������̬�Ĵ�����Ķ���
	Toy(int i) {}
}

class FancyToy extends Toy
implements HasBatteries, Waterproof, Shoots, YuanLong {
	FancyToy(){super(1);}
}

public class ToyTest{
	static void printInfo(Class cc) {
		System.out.println("Class name: " + cc.getName() + 
				       " is interface? [" + cc.isInterface() + "]");
		System.out.println("Simple name: " + cc.getSimpleName());
		System.out.println("Canonical name: " + cc.getCanonicalName());
	}
	public static void main(String[] args) {
		Class c = null;
		try {
			c = Class.forName("typeinfo.toys.FancyToy");
		} catch (ClassNotFoundException e) {
			System.out.println("Can not find FancyToy");
			System.exit(1);
		}
		printInfo(c);
		for(Class face : c.getInterfaces()) {printInfo(face);}
		Class up = c.getSuperclass();
		Object obj = null;
		try {
			obj = up.newInstance();
			// ʹ�� newInstance() �����࣬�������Ĭ�ϵĹ�����
		} catch (InstantiationException e) {
			System.out.println("Can not instantiate");
			System.exit(1);
		} catch (IllegalAccessException e) {
			System.out.println("Can not access");
			System.exit(1);
		}
		printInfo(obj.getClass());
	}
}

