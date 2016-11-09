package holding;
import java.util.*;

public class TestListRef {
	public static void main(String[] args) {
		String[] words = ("I want to be a smart man").split(" ");
		List<String> as = Arrays.asList(words);
		List<String> ls = new ArrayList(as);
		System.out.println("words: " + words);
		System.out.println("asList: " + as);
		System.out.println("arrayList: " + ls);
		System.out.println("asList vs String[]: " + as.get(0).equals(words[0]));
		System.out.println("arrayList vs String[]: " + ls.get(0).equals(words[0]));
		System.out.println("asList vs arrayList: " + as.get(0).equals(ls.get(0)));
		System.out.println("asList vs String[]: " + as.get(0)==words[0]);
		System.out.println("arrayList vs String[]: " + ls.get(0)==words[0]);
		System.out.println("asList vs arrayList: " + as.get(0)==ls.get(0));
		// 更改String[],看变化
		words[0] = "Who";
		System.out.println("as: "+as.get(0));
		System.out.println("ls: "+ls.get(0));
	}
	public TestListRef() {
		// TODO Auto-generated constructor stub
	}

}
