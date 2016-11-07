package typeinfo;
import java.lang.reflect.*;
import java.util.*;
import net.mindview.util.*;

class NullRobotProxyHandler implements InvocationHandler{
	/*
	 * 与其他代理模式不同：
	 * 1. - 其他代理模式，proxied域是通过CTOR的参数获得初始化值的，换言之，被代理对象是不固定的，他可以是
	 *    任意一个类型的对象，你只需要把这个类型对象的引用作为代理处理器的CTOR参数传入即可。
	 *    - 针对『空对象』的代理模式，proxied是固定的不变的，已经被指定为NRobot了。NRobot是一个实现了Robot
	 *    和 Null接口的 私有内部类，外部不可见。所有对Robot接口的实现都真对“空对象”的意义做了特殊处理。
	 *    而CTOR的主要作用是初始化另一个私有域---一个表示『是哪个类的空对象』的字符串。
	 * 2. - 其他代理模式， proxied 都是指向一个『外部』的对象。
	 *    - 针对『空对象』的代理模式，proxied是内部提供的。
	 * 3. - 其他代理模式，只有一个私有域
	 *    - 而针对『空对象』的代理模式，多了一个 nullName的私有域。它用来标识是『是哪个类的空对象』。
	 */
	private String nullName;
	private Robot proxied = new NRobot();         // 这样设计很有意思，每一次Handler对象被创建，都会伴随一个NRobot对象的创建
	                                              // 而且还是带着个性化信息的NRobot
	                                              // 生成的代理，调用某个函数，都会转发到这个个性化的NRobot对象，由这个对象来调用
	public NullRobotProxyHandler(Class<? extends Robot> type) {
		nullName = type.getSimpleName() + " NullRobot";
	}
	private class NRobot implements Null, Robot{  // 原对象的代理
		public String name() { return nullName; }
		public String model() { return nullName; }
		public List<Operation> operation(){
			return Collections.emptyList();
		}
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		return method.invoke(proxied, args);
	}
}

/* 
 * 『之前的错误理解』
 * 跨越对“代理”的固有理解，代理与被代理者，实际是“兄弟”关系，
 * 这很像 NullObject空对象与原对象之间的关系。
 * 所以把 空对象 当成 “代理”，那么 newProxyInstance() 产生的就是 “空对象”
 * 『正确的理解』
 * NRobot对象是被Handler“私藏”起来的“永久”被代理类，之所以放在Handler内部，而不是其他类内部，
 * 是因为，『被代理者是谁？』就是由Handler来接收（通过CTOR的参数接受）和调用（invoke）的。
 * NRobot实现的什么接口，在 newProxyInstance()的第二参数也应该跟随NRobot的脚步实现什么接口。
 * NRobot如何实现“个性化”？ 就是每个不同的Robot子类的“空对象”如何标识，在Handler中新加一个私有域，
 * 由于proxid已经确定，那么Handler类的CTRO就是为这个“个性化信息标识”服务---通过参数初始化这个
 * String类型的私有域。
 */
public class NullRobot { 
	
	public static Robot newNullRobot(Class<? extends Robot> type) {
		return (Robot)Proxy.newProxyInstance(
				NullRobot.class.getClassLoader(), 
				new Class[] {Null.class, Robot.class}, 
				new NullRobotProxyHandler(type));
	}
	
	public static void main(String[] args) {
		Robot[] bots = {
				new SnowRemovalRobot("SnowBee"), 
				/*
				 * 与普通代理模式的用法不同：
				 * 普通带例模式，是通过对代理的调用，来识别具体的被代理者的调用
				 * 而这里，就是想得到代理（空对象）而已
				 */
				newNullRobot(SnowRemovalRobot.class)}; 
	
		for (Robot bot : bots) {
			Robot.Test.test(bot);
		}
	}

}
