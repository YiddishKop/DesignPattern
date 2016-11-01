class Candy{
	static { System.out.println("Loading Candy");}
	// 静态初始化语句块 仅仅在类被加载的时候调用一次。
}

class Gum{
	static { System.out.println("Loading Gum");}
}

class Cookie{
	static { System.out.println("Loading Cookie");}
}

public class SweetShop {
	/*
	 * HW7: 修改SweetShop.java, 使得每种类型对象的创建由命令行参数控制。即，如果命令行
	 * 是  'java Sweetshop Candy' ，那么只有Candy对象被创建。注意你是如何通过命令行参数
	 * 来控制加载哪个 Class 对象的。
	 */
	public static Object createObject(String c) {
		try { // 注意 return 语句必须出现在每个 try 和 catch 块中，参照 if else 里的return
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
		// 注意 在执行命令行的时候， 类名是不算做args内的
		// 比如 java SweetShop xxx yyy zzz
		// 这里 xxx = args[0]; yyy = args[1]; zzz = args[2];
//		new Candy();
		System.out.println("After creating Candy");
		try {
			Class.forName("Gum");
			// 这条语句返回一个 Class 的引用
			// 这条语句的副作用是：如果Gum类没有加载，则加载该类到JVM
		}catch(ClassNotFoundException e) {
			System.out.println("Couldn't find Gum");
		}
	
		System.out.println("After Class.forName(\"Gum\")");
		new Cookie();
		System.out.println("After creating Cookie");
	}
}
