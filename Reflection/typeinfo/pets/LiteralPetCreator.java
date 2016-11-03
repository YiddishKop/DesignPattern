//: typeinfo/pets/LiteralPetCreator.java
// Using class literals.
package typeinfo.pets;
import java.util.*;

/*
 * 这个PetCreator的扩展类与 ForNameCreator最大的不同就在于前者使用
 * 类字面常量<类名>.class直接获得Class信息，后者使用Class.forName(<String classname>)获得Class信息
 * 两者不同之处：
 * 1. 字面常量不会立即进行初始化，而forName会理解进行；
 * 2. 字面常量需要借助类名，forName需要借助类名的字符串
 * ------------------------------------------------
 * 为什么ForNameCreator需要静态初始化块，而LiteralPetCreator 不需要？
 * - 因为ForName需要借助 类名的字符串才能获得Class信息
 * - 而Literal字面常量的方式直接给定了所有的类的字面常量
 * - 换言之， ForName方式多了一步。 需要在使用ForNameCreator的types之前
 * - 确保他已经被初始化（通过类名字符串得到对应类的Class信息）
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
