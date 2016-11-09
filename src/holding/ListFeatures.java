package holding;
import typeinfo.pets.*;
import java.util.*;
import static net.mindview.util.Print.*;

public class ListFeatures {
	public static void main(String[] args) {
		Random rand = new Random(47); // 47 只是一个 random seed，相同的seed每次都会产生相同的随机序列
		                              // 如果想产生完全的（伪）随机，就不带任何参数，这样会花费系统 1 nanoTime的时间
		List<Pet> pets = Pets.arrayList(7);
		System.out.println("1: " + pets);
		Hamster h = new Hamster();
		pets.add(h); // List会自动扩容
		System.out.println("2: " + pets);
		System.out.println("3: " + pets.contains(h));  // 测试list是否包含某个元素
		pets.remove(h);                                // 测试list删除某个元素
		Pet p = pets.get(2);
		System.out.println("4: " + p + " " + pets.indexOf(p)); // 根据对象引用来获取对象位置索引
		                                                       // 想删除某个 list 中的元素，必须先获取其索引
		Pet cymric = new Cymric();
		System.out.println("5: " + pets.indexOf(cymric));
		System.out.println("5: " + pets.remove(cymric));
		pets.add(3, new Mouse()); // 在某个索引位置插入一个元素，原来这个位置存放的元素及其之后的元素，向后移动一个索引位置
		System.out.println("9: " + pets);
		List<Pet> sub = pets.subList(1, 4); // 在原有list基础上(没有拷贝形成新的list)，设置 head 和 tail 指针，形成一个“新”list
		                                    // 但是要注意，并没有【新建成】一个list
		System.out.println("subList " + sub);
		System.out.println("10: " + pets.containsAll(sub));
		Collections.sort(sub); // In-place sort，是说Collection的排序算法不需要占用额外的空间
		System.out.println("sorted subList: " + sub);
		System.out.println("10.1: " + pets); // 对子列表进行的所有改动，在原列表中都会表现出来
		System.out.println("11: " + pets.containsAll(sub)); // 这个几乎是确定的，但是这里想说的是，containsAll是对
		                                                    // 元素级别的，不关乎元素顺序
		Collections.shuffle(sub, rand); // 对某个容器(sub)基于某个随机种子(rand)进行洗牌
		System.out.println("shuffled subList: " + sub);
		List<Pet> copy = new ArrayList<Pet>(pets); // 利用现有容器对新容器进行初始化
		                                           // 这种方法在所有容器中都适用，list与list，set与list，ets..
		                                           // TODO 但这个仍然只是拷贝了一个新的【引用】，所以不能叫【对象容器】
		                                           // 应该叫【引用容器】
		System.out.println("a new reference? == " + (pets.get(0) == copy.get(0)));
		System.out.println("a new reference? equals " + (pets.get(0).equals(copy.get(0))));
		sub = Arrays.asList(pets.get(1), pets.get(4)); // asList
		System.out.println("sub: " + sub);
		System.out.println("12: " + pets.containsAll(sub));
		copy.retainAll(sub);
		System.out.println("13: " + copy);// 谁调用的 retailAll(),其结果就保存在谁里【原有内容全清除】
		copy = new ArrayList<Pet>(pets);  // 重新从pets创建一个新的ArrayList
		copy.remove(2);                   // remove by index
		copy.removeAll(sub);
		System.out.println("15: " + copy);
		copy.set(1, new Mouse());
		System.out.println("16: " + copy);
		copy.addAll(2, sub);
		System.out.println("17: " + copy);
		System.out.println("18: " + pets.isEmpty());
		pets.clear();
		System.out.println("19: " + copy);
		pets.addAll(Pets.arrayList(4));
		System.out.println("20: " + pets);
		Object[] o = pets.toArray();
		System.out.println("21: " + o[3]);
		Pet[] pa = pets.toArray(new Pet[0]);// 这个传递的是一个对象引用，那么返回值就是以此为元素类型的数组
		
	}
	public ListFeatures() {
		// TODO Auto-generated constructor stub
	}

}
