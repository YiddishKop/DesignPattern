package typeinfo;
import java.util.*;

public class SnowRemovalRobot implements Robot{
	private String name;
	public SnowRemovalRobot(String name) {
		this.name = name;
	}
	public String name() {return name;}
	public String model() {return "SnowBot Series 11";}
	public List<Operation> operation(){
		return Arrays.asList(
				new Operation() {  // 这种用法真是神奇的很，可疑直接new 接口，并在后面的大括号中实现接口的函数。
					public String description() {
						return name + " can shovel snow";
					}
					public void command() {
						System.out.println(name + " shoveling snow");
					}
				},
				new Operation() {
					public String description() {
						return name + " can chip ice";
					}
					public void command() {
						System.out.println(name + " chipping ice");
					}
				},
				new Operation() {
					public String description() {
						return name + " can clear the roof";
					}
					public void command() {
						System.out.println(name + " clearing roof");
					}
				});
	}
	public static void main(String[] args) {
		Robot.Test.test(new SnowRemovalRobot("Slusher"));
	}
}
