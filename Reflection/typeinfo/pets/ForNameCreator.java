//: typeinfo/pets/ForNameCreator.java
package typeinfo.pets;
import java.util.*;

public class ForNameCreator extends PetCreator{
	private static List<Class<? extends Pet>> types =
			new ArrayList<Class<? extends Pet>>();
	// Types that you want to be randomly created:
	private static String[] typeNames = {
			"typeinfo.pets.Mutt",
			"typeinfo.pets.Pug",
			"typeinfo.pets.EgyptianMau",
			"typeinfo.pets.Manx",
			"typeinfo.pets.Rat",
			"typeinfo.pets.Mouse",
			"typeinfo.pets.Hamster",
	};
	
	@SuppressWarnings("unchecked")
	private static void loader() {
		try {
			for (String name : typeNames) {
				/*
				 *  1. 确实，通过 forName方法，我只需要给出类名的字符串即可得到该类的Class信息
				 *  2. 这里涉及向上转型，这很重要。因为forName得到的 class信息是精确地，而List要求的class信息是通用类型的
				 */
				types.add((Class<? extends Pet>)Class.forName(name));
			}
		}catch(ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
	static {loader();}
	public List<Class<? extends Pet>> types(){return types;}
}
