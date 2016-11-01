
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

abstract class Shape {
	// ΪHW6 ����һ�� boolean ������ʾ�Ƿ񱻱�ʶ
	boolean mark = false;
	void draw() { System.out.println(this + ".draw()");} // ʵ���� toString()�������࣬����ֱ���� String ���ͽ��� + ����
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
	 * HW4: �޸�ǰһ����ϰ������ĳ�����ִ������ת��֮ǰ������ instanceof ��Ԫ�������������
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
	 * HW5: ʵ��shaps.java�е�rotate(Shape)�����������ж�������ת���ǲ���Circle������ǣ��Ͳ�ִ�У�
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
	 * HW6: �޸�shapes.java ʹ��������ܽ�ĳ���ض����ͣ��ࣩ��������״�����󣩶�����ʶ��������ͨ�����־����
	 *      ÿһ��������shape���toString()����Ӧ���ܹ�ָ��Shape�Ƿ񱻱�ʶ��
	 *      ** �ҵ�ʵ����Ҫ����������һ�������� c �� �����ʶ��ĳһ�����͵�
	 */
	static void mark(Collection<Shape> c, String spMark) { // Collection��Ĳ���Ҳ������Ӧ�þ��󻯣�
		                                                   // �Ա�ʶ��ϣ���������Ĳ�����һ�����洢ʲô�����ġ�����
		for(Shape shape : c) {
			if (spMark == shape.getClass().getSimpleName()) { // ÿһ�������ڵ�shape�������shape�Ƚ� simpleName
				                                              // �����ͬ�������״�����󣩵��� mark ��Ϊ true
				shape.mark = true;
			}
		}
	}
	
	/*
	 * HW8: дһ�������� ���������������Ϊ���������ܹ����ݹ须��ӡ���ö������ڵļ̳���ϵ�е�������
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
	 * HW9: �޸�ǰһ��ϰ���������������Class.getDecalaredFields() ����ӡһ�����е���������Ϣ
	 */
	public static void getFields(Object obj) {
		Object[] fields = obj.getClass().getDeclaredFields();
		for (Object object : fields) {
			System.out.println(obj + "'s field: " + object);
		}
	}
	/*
	 * HW10: дһ�������ж�char ���龿���Ǹ��������ͻ���һ������
	 */
	public static void checkCharArray() {
		char[] charArry = new char[]{'s','e','t'};    // ������δ���ִ���׳��쳣��ʵ����ʧ�ܣ�����char�����ǻ����������ͣ������Ƕ���
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