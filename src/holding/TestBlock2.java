package holding;

public class TestBlock2 {
	public TestBlock2 tryBlock2() {
		return new TestBlock2() {
//			System.out.println("hello");
			int value = 3;
			public boolean hasBuild() {
				return false;
			}
			public void printB() {
				System.out.println("hi, i'm here, please heeeeeelp meeeeee");
			}
		};
	}
	public static void main(String[] args) {
		TestBlock2 tb2 = new TestBlock2();
		TestBlock2 tb = tb2.tryBlock2();
	}
}
