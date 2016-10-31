package typeinfo;

import java.util.Arrays;
import java.util.List;

abstract class Shape {
	void draw() { System.out.println(this + ".draw()");} // 实现了 toString()方法的类，可以直接与 String 类型进行 + 运算
	abstract public String toString();
}


class Circle extends Shape {
	@Override
	public String toString() {return "Circle";}
}

class Square extends Shape {
	@Override
	public String toString() {return "Square";}
}

class Triangle extends Shape {
	@Override
	public String toString() {return "Triangle";}
}

public class Shapes {
	public static void main(String[] args) {
		List<Shape> shapeList = Arrays.asList(
				new Circle(), new Square(), new Triangle()
				);
		for(Shape shape : shapeList) {
			shape.draw();
		}
	}
}