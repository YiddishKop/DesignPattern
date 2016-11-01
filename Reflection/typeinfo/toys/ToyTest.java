package typeinfo.toys;

interface HasBatteries{}
interface Waterproof{}
interface Shoots{}
interface YuanLong{}

class Toy{
	Toy() {}   
	// 如果想通过 newInstance() 来创建 Toy 对象则必须有默认的 constructor
	// 否则会产生实例化失败异常
	// TODO 通过 Java 的反射功能 API 可以摆脱这种限制 --- 用任意的构造器来动态的创建类的对象
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
			// 使用 newInstance() 创建类，必须带有默认的构造器
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

