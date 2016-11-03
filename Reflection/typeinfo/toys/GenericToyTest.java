package typeinfo.toys;

public class GenericToyTest {
	public static void main(String[] args) throws Exception{
		Class<FancyToy> ftClass = FancyToy.class;
		// produces exact type:
		FancyToy fancyToy = ftClass.newInstance();
		Class<? super FancyToy> up = ftClass.getSuperclass();
		// This won't compile:
//		Class<Toy> up2 = ftClass.getSuperclass();
		//上面这句是异常的，尽管这非常奇怪
		// Only produce Object:
		Object obj = up.newInstance();
	}
	public GenericToyTest() {
		// TODO Auto-generated constructor stub
	}

}
