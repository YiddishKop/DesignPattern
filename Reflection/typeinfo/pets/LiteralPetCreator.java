//: typeinfo/pets/LiteralPetCreator.java
// Using class literals.
package typeinfo.pets;
import java.util.*;

/*
 * ���PetCreator����չ���� ForNameCreator���Ĳ�ͬ������ǰ��ʹ��
 * �����泣��<����>.classֱ�ӻ��Class��Ϣ������ʹ��Class.forName(<String classname>)���Class��Ϣ
 * ���߲�֮ͬ����
 * 1. ���泣�������������г�ʼ������forName�������У�
 * 2. ���泣����Ҫ����������forName��Ҫ�����������ַ���
 * ------------------------------------------------
 * ΪʲôForNameCreator��Ҫ��̬��ʼ���飬��LiteralPetCreator ����Ҫ��
 * - ��ΪForName��Ҫ���� �������ַ������ܻ��Class��Ϣ
 * - ��Literal���泣���ķ�ʽֱ�Ӹ��������е�������泣��
 * - ����֮�� ForName��ʽ����һ���� ��Ҫ��ʹ��ForNameCreator��types֮ǰ
 * - ȷ�����Ѿ�����ʼ����ͨ�������ַ����õ���Ӧ���Class��Ϣ��
 */
public class LiteralPetCreator extends PetCreator {
  // No try block needed.
  @SuppressWarnings("unchecked")
  public static final List<Class<? extends Pet>> allTypes =
    Collections.unmodifiableList(Arrays.asList(
      Pet.class, Dog.class, Cat.class,  Rodent.class,
      Mutt.class, Pug.class, EgyptianMau.class, Manx.class,
      Cymric.class, Rat.class, Mouse.class,Hamster.class));
  // Types for random creation:
  private static final List<Class<? extends Pet>> types =
    allTypes.subList(allTypes.indexOf(Mutt.class),
      allTypes.size());
  public List<Class<? extends Pet>> types() {
    return types;
  }	
  public static void main(String[] args) {
    System.out.println(types);
  }
} /* Output:
[class typeinfo.pets.Mutt, class typeinfo.pets.Pug, class typeinfo.pets.EgyptianMau, class typeinfo.pets.Manx, class typeinfo.pets.Cymric, class typeinfo.pets.Rat, class typeinfo.pets.Mouse, class typeinfo.pets.Hamster]
*///:~
