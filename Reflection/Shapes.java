
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

abstract class Shape {
	// 为HW6 增加一个 boolean 变量表示是否被标识
	boolean mark = false;
	void draw() { System.out.println(this + ".draw()");} // 实现了 toString()方法的类，可以直接与 String 类型进行 + 运算
	abstract public String toString();
}


class Circle extends Shape {
	private int priv;
	String pack;
	public char publ;
	
	@Override
	public String toString() {return "Circle" + "[be marked: " + mark + "]";}
}

class Square extends Shape {
	@Override
	public String toString() {return "Square" + "[be marked: " + mark + "]";}
}

class Triangle extends Shape {
	@Override
	public String toString() {return "Triangle" + "[be marked: " + mark + "]";}
}

class Rhomboid extends Shape {
	@Override
	public String toString() {return "Rhomboid" + "[be marked: " + mark + "]";}
}

public class Shapes {
	/*
	 * HW4: 修改前一个练习，让你的程序在执行向下转型之前先运用 instanceof 二元操作符检查类型
	 */
	public static void castChecker(Shape sp) {
		if (sp instanceof Circle) {
			System.out.println("sp is a Circle");
			Circle c = (Circle)sp;
		}else {
			System.out.println("Can not cast sp to Circle");
		}
	}
	
	/*
	 * HW5: 实现shaps.java中的rotate(Shape)方法，让他判断它所旋转的是不是Circle（如果是，就不执行）
	 */
	static void rotate(Shape sp) {
		Class cc = sp.getClass();
		if (cc.getSimpleName() == "Circle") {
			return;
		}else {
			System.out.println(sp + " Rotate");
		}
	}
	
	/*
	 * HW6: 修改shapes.java 使这个程序能将某个特定类型（类）的所有形状（对象）都“标识”出来（通过设标志）。
	 *      每一个导出的shape类的toString()方法应该能够指出Shape是否被标识。
	 *      ** 我的实现需要传入这里有一个集合类 c 和 我想标识的某一个类型的
	 */
	static void mark(Collection<Shape> c, String spMark) { // Collection类的参数也可以且应该具象化，
		                                                   // 以标识我希望传进来的参数是一个“存储什么东西的”容器
		for(Shape shape : c) {
			if (spMark == shape.getClass().getSimpleName()) { // 每一个容器内的shape都与参数shape比较 simpleName
				                                              // 如果相同，则该形状（对象）的域 mark 置为 true
				shape.mark = true;
			}
		}
	}
	
	/*
	 * HW8: 写一个方法， 他接收任意对象作为参数，并能够『递归』打印出该对象所在的继承体系中的所有类
	 */
	public static void getFamily(Object obj) {
		Class sup = obj.getClass().getSuperclass();
		if(sup == null) {
			System.out.println("Null");
		}else {
			try {
				System.out.print(obj + "'s superClass is: ");
				getFamily(sup.newInstance());
			} catch (InstantiationException | IllegalAccessException e) {
				System.out.println("Instantiation Error or IllegalAccess");
			}
		}
	} 
	
	/*
	 * HW9: 修改前一练习，让这个方法是用Class.getDecalaredFields() 来打印一个类中的域的相关信息
	 */
	public static void getFields(Object obj) {
		Object[] fields = obj.getClass().getDeclaredFields();
		for (Object object : fields) {
			System.out.println(obj + "'s field: " + object);
		}
	}
	/*
	 * HW10: 写一个程序，判断char 数组究竟是个基本类型还是一个对象。
	 */
	public static void checkCharArray() {
		char[] charArry = new char[]{'s','e','t'};    // 下面这段代码执行抛出异常，实例化失败，所以char数组是基本数据类型，而不是对象。
		try {
			System.out.println(charArry.getClass().newInstance());
		} catch (InstantiationException e) {
			System.out.println("instantiation error, " + "char[] is primitive type");
		} catch (IllegalAccessException e) {
			System.out.println("can not access");
		}
		Integer it = 0;
		try {
			System.out.println(it.getClass().newInstance());
		} catch (InstantiationException e) {
			System.out.println("instantiation error, " + "Integer is primitive type");
		} catch (IllegalAccessException e) {
			System.out.println("can not access");
		}
		String st = " ";
		try {
			System.out.println(st.getClass().newInstance() + "string is an Object");
		} catch (InstantiationException e) {
			System.out.println("instantiation error");
		} catch (IllegalAccessException e) {
			System.out.println("can not access");
		}
	}
	public static void main(String[] args) {
		List<Shape> shapeList = Arrays.asList(
				new Circle(), new Square(), new Triangle(), new Circle(), new Rhomboid()
				);
		mark(shapeList, "Circle");		// test code for HW6
		for(Shape shape : shapeList) {
			shape.draw();
			rotate(shape);              // test code for HW5
			System.out.println(shape);  // test code for HW6
		}
		getFields(new Circle());	    // test code for HW9
		checkCharArray();               // test code for HW10
	}
}