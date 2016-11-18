package strings;
import java.util.*;


/**
 * @author yiddi
 * �������壺 չʾ formatter ��ξ�ȷ���ơ���Сλ�ó��ȡ��͡�������ݳ��ȡ���
 * - %[flag][width][.precision] s/d/f
 * - flag �ճ���ʾ�Ҷ��룬��-����ʾ�����
 * - width ��ʾռ�õġ���Сλ�ó��ȡ�����ʹ���ݳ���Ϊ0��Ҳ��ռ����ô�ࡰλ�á�
 * - precision ��ʾռ�õġ�������ݳ��ȡ��������Ͳ���ʾ��
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
