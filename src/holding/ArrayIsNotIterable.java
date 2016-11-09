package holding;
import java.util.*;

public class ArrayIsNotIterable {
	static <T> void test(Iterable<T> ib) {
		for(T t : ib) {
			System.out.println(t + " ");
		}
	}
	
}
