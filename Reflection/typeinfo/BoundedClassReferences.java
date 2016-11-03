package typeinfo;

public class BoundedClassReferences {
	public static void main(String[] args) {
		Class<? extends Number> bounded = int.class;
		bounded = double.class;
		bounded = Number.class;
		// int 或者 double 都是从 Number 扩展出来的
		// 这里限定 Class引用 的类型 为 <? extends Number>，其可为 int、double
		// 或者其他任何 'Number' 的子类
	}
	public BoundedClassReferences() {
		// TODO Auto-generated constructor stub
	}

}
