public class StaticBlock {
	public static void main(String args[]) {
		for (int i = 0; i < 5; i++) {
			new Duck();
		}
		
		for (int i = 0; i < 5; i++) {
			Goose.myInt++;    // static initialization block
			Goose.myMethod(); // static initialization block
			new Goose();      
			// 这三条语句都会执行,但是 static initialization block 仅仅执行一次
			// 原因是static initialization “仅在类被加载时执行”，而何时类被加载呢？
			// 整个 JVM 的生命周期，每个类仅仅会被加载一次，就是在该类访问静态变量or方法时
			// CTOR也是静态方法。
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