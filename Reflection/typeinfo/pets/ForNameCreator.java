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
				 *  1. ȷʵ��ͨ�� forName��������ֻ��Ҫ�����������ַ������ɵõ������Class��Ϣ
				 *  2. �����漰����ת�ͣ������Ҫ����ΪforName�õ��� class��Ϣ�Ǿ�ȷ�أ���ListҪ���class��Ϣ��ͨ�����͵�
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
