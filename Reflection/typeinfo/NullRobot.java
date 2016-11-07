package typeinfo;
import java.lang.reflect.*;
import java.util.*;
import net.mindview.util.*;

class NullRobotProxyHandler implements InvocationHandler{
	/*
	 * ����������ģʽ��ͬ��
	 * 1. - ��������ģʽ��proxied����ͨ��CTOR�Ĳ�����ó�ʼ��ֵ�ģ�����֮������������ǲ��̶��ģ���������
	 *    ����һ�����͵Ķ�����ֻ��Ҫ��������Ͷ����������Ϊ����������CTOR�������뼴�ɡ�
	 *    - ��ԡ��ն��󡻵Ĵ���ģʽ��proxied�ǹ̶��Ĳ���ģ��Ѿ���ָ��ΪNRobot�ˡ�NRobot��һ��ʵ����Robot
	 *    �� Null�ӿڵ� ˽���ڲ��࣬�ⲿ���ɼ������ж�Robot�ӿڵ�ʵ�ֶ���ԡ��ն��󡱵������������⴦��
	 *    ��CTOR����Ҫ�����ǳ�ʼ����һ��˽����---һ����ʾ�����ĸ���Ŀն��󡻵��ַ�����
	 * 2. - ��������ģʽ�� proxied ����ָ��һ�����ⲿ���Ķ���
	 *    - ��ԡ��ն��󡻵Ĵ���ģʽ��proxied���ڲ��ṩ�ġ�
	 * 3. - ��������ģʽ��ֻ��һ��˽����
	 *    - ����ԡ��ն��󡻵Ĵ���ģʽ������һ�� nullName��˽������������ʶ�ǡ����ĸ���Ŀն��󡻡�
	 */
	private String nullName;
	private Robot proxied = new NRobot();         // ������ƺ�����˼��ÿһ��Handler���󱻴������������һ��NRobot����Ĵ���
	                                              // ���һ��Ǵ��Ÿ��Ի���Ϣ��NRobot
	                                              // ���ɵĴ�������ĳ������������ת����������Ի���NRobot�������������������
	public NullRobotProxyHandler(Class<? extends Robot> type) {
		nullName = type.getSimpleName() + " NullRobot";
	}
	private class NRobot implements Null, Robot{  // ԭ����Ĵ���
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
 * ��֮ǰ�Ĵ�����⡻
 * ��Խ�ԡ������Ĺ�����⣬�����뱻�����ߣ�ʵ���ǡ��ֵܡ���ϵ��
 * ����� NullObject�ն�����ԭ����֮��Ĺ�ϵ��
 * ���԰� �ն��� ���� ����������ô newProxyInstance() �����ľ��� ���ն���
 * ����ȷ����⡻
 * NRobot�����Ǳ�Handler��˽�ء������ġ����á��������֮࣬���Է���Handler�ڲ����������������ڲ���
 * ����Ϊ��������������˭����������Handler�����գ�ͨ��CTOR�Ĳ������ܣ��͵��ã�invoke���ġ�
 * NRobotʵ�ֵ�ʲô�ӿڣ��� newProxyInstance()�ĵڶ�����ҲӦ�ø���NRobot�ĽŲ�ʵ��ʲô�ӿڡ�
 * NRobot���ʵ�֡����Ի����� ����ÿ����ͬ��Robot����ġ��ն�����α�ʶ����Handler���¼�һ��˽����
 * ����proxid�Ѿ�ȷ������ôHandler���CTRO����Ϊ��������Ի���Ϣ��ʶ������---ͨ��������ʼ�����
 * String���͵�˽����
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
				 * ����ͨ����ģʽ���÷���ͬ��
				 * ��ͨ����ģʽ����ͨ���Դ���ĵ��ã���ʶ�����ı������ߵĵ���
				 * �����������õ������ն��󣩶���
				 */
				newNullRobot(SnowRemovalRobot.class)}; 
	
		for (Robot bot : bots) {
			Robot.Test.test(bot);
		}
	}

}
