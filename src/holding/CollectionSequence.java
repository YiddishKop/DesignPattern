package holding;
import typeinfo.pets.*;
import java.util.*;

public class CollectionSequence extends AbstractCollection<Pet>{
	private Pet[] pets = Pets.createArray(8); // 首先这个类持有Pet对象
	@Override
	public int size() {
		return pets.length;
	}
	@Override
	public Iterator<Pet> iterator() {
		return new Iterator<Pet>() {
			private int index = 0;
			public boolean hasNext() {
				return index < pets.length;
			}
			public Pet next() {return pets[index++];}
			public void remove() { // Not implemented
				throw new UnsupportedOperationException();
			}
		};
	}
	

}
