package strings;
import java.util.*;


/**
 * @author yiddi
 * 程序意义： 展示 formatter 如何精确控制【最小位置长度】和【最大内容长度】的
 * - %[flag][width][.precision] s/d/f
 * - flag 空出表示右对齐，“-”表示左对齐
 * - width 表示占用的【最小位置长度】，即使内容长度为0，也会占用这么多“位置”
 * - precision 表示占用的【最大内容长度】，超过就不显示了
 */
public class Receipt {
	private double total = 0;
	private Formatter f = new Formatter(System.out);
	public void printTitle() {
		f.format("%-15s %5s %10s\n", "Item", "Q", "Price");
		f.format("%-15s %5s %10s\n", "----", "---", "-----");
	}
	public void print(String name, int qty, double price) {
		f.format("%-15.15s %5d %10.2f\n", name, qty, price);
		total += price;
	}
	public void printTotal() {
		f.format("%-15s %5s %10.2f\n", "Tax", "", total*0.06);
		f.format("%-15s %5s %10s\n", "", "", "-----");
		f.format("%-15s %5s %10.2f\n", "Total", "", total*1.06);
	}
	public static void main(String[] args) {
		Receipt receipt = new Receipt();
		receipt.printTitle();
		receipt.print("Jack's Magic Beans", 4, 4.25);
		receipt.print("Printcess peas", 3, 5.1);
		receipt.print("Three Bears Porridge", 1, 14.29);
		receipt.printTitle();
	}
}
