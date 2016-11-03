package typeinfo;
import java.util.*;

class Initable{
	static final int staticFinal = 47;
	static final int staticFinal2 = 
			ClassInitialization.rand.nextInt(1000);
	static {
		System.out.println("Initializing Initable");
	}
}

class Initable2{
	static int staticNonFinal = 147;
	static {
		System.out.println("Initializing Initable2");
	}
}

class Initable3{
	static int staticNonFinal = 74;
	static {
		System.out.println("Initializing Initable3");
	}
}

public class ClassInitialization {
	public static Random rand = new Random(47);
	public static void main(String[] args) throws Exception{
		Class initable = Initable.class;                    // 类字面常量并不会引起初始化
		System.out.println(initable);                       // 但是类字面常量确实获得了 Class 对象的引用
		System.out.println("After creating Initable ref");
		// Does not trigger initialization:
		System.out.println(Initable.staticFinal);           // 如果 static final域 是编期常量，则不需要初始化就可以被读取
		// Does trigger initialization:
		System.out.println(Initable.staticFinal2);          // 如果 static final域 不是编译期常量，比如依赖其他类的信息，则引起初始化
		// Does trigger initialization:
		System.out.println(Initable2.staticNonFinal);       // 如果不是 final 则引起初始化
		Class initable3 = Class.forName("Initable3");       // forName会直接引起初始化
		System.out.println("After creating Initable3 ref");
		System.out.println(Initable3.staticNonFinal);
	}
}
