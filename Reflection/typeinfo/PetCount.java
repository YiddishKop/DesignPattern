package typeinfo;
import typeinfo.pets.*;
import java.util.*;

public class PetCount {
	static class PetCounter extends HashMap<String, Integer> { // 注意如何指定HashMap中的 key 和 value 的类型
		public void count(String type) {                       // 这个函数的主要作用是给根据是否匹配『键』来增加『值』
			Integer quantity = get(type);
			if (quantity == null) {
				put(type, 1);
			} else {
				put(type, quantity + 1); 
			}
		}
	}
		public static void
		countPets(PetCreator creator) {
			PetCounter counter = new PetCounter();
			for (Pet pet : creator.createArray(20)) {
				System.out.println(pet.getClass().getSimpleName());
				if(pet instanceof Pet) counter.count("Pet");
				if(pet instanceof Dog) counter.count("Dog");
				if(pet instanceof Mutt) counter.count("Mutt");
				if(pet instanceof Pug) counter.count("Pug");
				if(pet instanceof Cat) counter.count("Cat");
				if(pet instanceof EgyptianMau) counter.count("EgyptianMau");
				if(pet instanceof Manx) counter.count("Manx");
				if(pet instanceof Rodent) counter.count("Rodent");
				if(pet instanceof Rat) counter.count("Rat");
				if(pet instanceof Mouse) counter.count("Mouse");
				if(pet instanceof Hamster) counter.count("Hamster");
			}
			// show the counts:
			System.out.println();
			System.out.println(counter);
		}
		public static void main(String[] args) {
			countPets(new ForNameCreator());
		}
}

