package holding;
import java.util.*;
import static net.mindview.util.Print.*;

public class PrintingContainers {
	static Collection fill(Collection<String> collection) {
		collection.add("rat");
		collection.add("cat");
		collection.add("dog");
		collection.add("dog");
		return collection;
	}
	static Map fill(Map<String, String> map) {
		map.put("rat", "Fuzzy");
		map.put("cat", "Rags");
		map.put("dog", "Bosco");
		map.put("dog", "Spot");
		return map;
	}
	public static void main(String[] args) {
		// List
		System.out.println(fill(new ArrayList<String>()));
		System.out.println(fill(new LinkedList<String>()));
		// Set
		System.out.println(fill(new HashSet<String>()));
		System.out.println(fill(new TreeSet<String>()));
		System.out.println(fill(new LinkedHashSet<String>()));
		// Map
		System.out.println(fill(new HashMap<String, String>()));
		System.out.println(fill(new TreeMap<String, String>()));
		System.out.println(fill(new LinkedHashMap<String, String>()));
	}
}