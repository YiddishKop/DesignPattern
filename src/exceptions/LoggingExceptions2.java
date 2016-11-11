package exceptions;
import static net.mindview.util.Print.*;
import java.util.logging.*;
import java.io.*;

/**
 * @author yiddi
 * 程序意义：这个异常logger程序区别于直接放在异常类的CTOR中
 *         而是把记录logger这个功能做成一个函数，函数接收一个异常对象作为参数
 *         利用 logger,printStackTrace,StringWriter,PrintWriter，记录
 *         调用该函数时的产生异常的栈轨迹到日志中。
 *       - 所以这个函数应该放在 catch 块中用作【异常处理】
 */
public class LoggingExceptions2 extends Exception{
	private static Logger logger = Logger.getLogger("LoggingExceptions2");
	static void logException(Exception e) {
		StringWriter trace = new StringWriter();
		e.printStackTrace(new PrintWriter(trace));
		logger.severe(trace.toString());
	}
	public static void main(String[] args) {
		try {
			throw new NullPointerException();
		} catch (NullPointerException e) {
			logException(e);
		}	
	}
}
