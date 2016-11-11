package exceptions;
import static net.mindview.util.Print.*;
import java.util.logging.*;
import java.io.*;

/**
 * @author yiddi
 * �������壺����쳣logger����������ֱ�ӷ����쳣���CTOR��
 *         ���ǰѼ�¼logger�����������һ����������������һ���쳣������Ϊ����
 *         ���� logger,printStackTrace,StringWriter,PrintWriter����¼
 *         ���øú���ʱ�Ĳ����쳣��ջ�켣����־�С�
 *       - �����������Ӧ�÷��� catch �����������쳣����
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
