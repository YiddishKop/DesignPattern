package strings;

/**
 * @author yiddi
 * 程序意义：通过javap -c <.class> 命令来观察底层代码如何处理 string + string 的
 * - 本质上 string + string 依然是使用 StringBuilder.append()方法
 * - 但是每次 + 都会新建一个 StringBuilder 对象(有点像动态数组，一旦容量不够就申请新的？)，如此造成效率极低
 * - 而直接使用 StringBuilder 你可以预先指定容量大小，以此避免重复新建StringBuilder对象
 * - 启发是：在你自己类中的toString()方法中如果要用到循环，那么还是自己用StringBuilder来实现吧
 */
public class WhitherStringBuilder {
	public String implicit(String[] fields) {
		String result = "";
		for (int i = 0; i < fields.length; i++) {
			result += fields[i];
		}
		return result;
	}
	public String explicit(String[] fields) {
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < fields.length; i++) {
			result.append(fields[i]);
		}
		return result.toString();
	}
	public WhitherStringBuilder() {
		// TODO Auto-generated constructor stub
	}

}
