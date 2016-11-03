//: typeinfo/pets/PetCreator.java
// Creates random sequences of Pets.
package typeinfo.pets;
import java.util.*;

public abstract class PetCreator {
	private Random rand = new Random(47);
	// the list of the different types of Pet to create;
	// 这个表示List中的元素是Class信息，而且这个Class信息是关于 Pet父类的
	public abstract List<Class<? extends Pet>> types();
	public Pet randomPet() { // Create one random Pet
		int n = rand.nextInt(types().size()); 
		// TODO ? diff between nextInt(bound) and nextInt()
		try {
			return types().get(n).newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			throw new RuntimeException();
		}  // TODO ? 我一直没注意到“抽象类中对抽象函数返回值的【空想式】引用”的写法
	}
	
	public Pet[] createArray(int size) {
		Pet[] result = new Pet[size];
		for (int i = 0; i < size; i++) {
			result[i] = randomPet();
		}
		return result;
	}
	public ArrayList<Pet> arrayList(int size){ 
		// 把一个数组，添加到Java内置数据结构  ArrayList中，
		// 语法格式：Collections.addAll(arrayList, 数组)
		ArrayList<Pet> result = new ArrayList<Pet>();
		Collections.addAll(result, createArray(size));
		return result;
	}
}
