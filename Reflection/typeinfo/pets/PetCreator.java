//: typeinfo/pets/PetCreator.java
// Creates random sequences of Pets.
package typeinfo.pets;
import java.util.*;

public abstract class PetCreator {
	private Random rand = new Random(47);
	// the list of the different types of Pet to create;
	// �����ʾList�е�Ԫ����Class��Ϣ���������Class��Ϣ�ǹ��� Pet�����
	public abstract List<Class<? extends Pet>> types();
	public Pet randomPet() { // Create one random Pet
		int n = rand.nextInt(types().size()); 
		// TODO ? diff between nextInt(bound) and nextInt()
		try {
			return types().get(n).newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			throw new RuntimeException();
		}  // TODO ? ��һֱûע�⵽���������жԳ���������ֵ�ġ�����ʽ�����á���д��
	}
	
	public Pet[] createArray(int size) {
		Pet[] result = new Pet[size];
		for (int i = 0; i < size; i++) {
			result[i] = randomPet();
		}
		return result;
	}
	public ArrayList<Pet> arrayList(int size){ 
		// ��һ�����飬��ӵ�Java�������ݽṹ  ArrayList�У�
		// �﷨��ʽ��Collections.addAll(arrayList, ����)
		ArrayList<Pet> result = new ArrayList<Pet>();
		Collections.addAll(result, createArray(size));
		return result;
	}
}
