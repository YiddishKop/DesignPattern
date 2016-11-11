package exceptions;
import java.util.logging.*;
import java.io.*;

/**
 * @author yiddi
 * 程序意义：如何用log记录异常信息,logger被内置到异常类的CTOR里面
 */
class LoggingException extends Exception{
	// 实践证明，getLogger()里的东西，并没有什么实际意义
	private static Logger logger = Logger.getLogger("LoggingException");
	
	public LoggingException() {
		/* 搞了这么一长串复杂的东西，其实就是想把 【栈轨迹】传输给【logger】作为日志
		 * 【栈轨迹】 -> PrintWriter -> StringWriter -> 【logger】
		 * 我似乎可以这样理解，
		 * 0. logger只能记录 String 信息作为日志
		 * 1. StringWriter 与  String 有关联: .toString()
		 * 2. PrintWriter 没法直接与 String 产生关系，所以【绑定】一个StringWriter
		 * 3. 栈轨迹只能传输给 PrintWriter
		 */
		StringWriter trace = new StringWriter();  // 创建一个StringWriter	 
		printStackTrace(new PrintWriter(trace));  // 把栈轨迹打印到 PrintWriter
		                                          // Prints formatted representations of objects to a text-output stream
		logger.severe(trace.toString());          // log a severe message
	}
}

public class LoggingExceptions {
	public static void main(String[] args) {
		try {
			throw new LoggingException();
		} catch (LoggingException e) {
			System.err.println("Caught " + e);
		}
		try {
			throw new LoggingException();
		} catch (LoggingException e) {
			System.err.println("Caught " + e);
		}
	}
}
