package holding;

public class TestBlock {
	public int x;
	{
		x = 0;
		System.out.println("I'm out of the tryBlock()");
	}
	public void tryBlock() {
		{
			x = 1;
			System.out.println("I'm in the tryBlock()");
		}
	}
	public static void main(String[] args) {
		TestBlock tb = new TestBlock();
		tb.tryBlock();
	}
}
