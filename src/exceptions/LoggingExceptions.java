package exceptions;
import java.util.logging.*;
import java.io.*;

/**
 * @author yiddi
 * �������壺�����log��¼�쳣��Ϣ,logger�����õ��쳣���CTOR����
 */
class LoggingException extends Exception{
	// ʵ��֤����getLogger()��Ķ�������û��ʲôʵ������
	private static Logger logger = Logger.getLogger("LoggingException");
	
	public LoggingException() {
		/* ������ôһ�������ӵĶ�������ʵ������� ��ջ�켣���������logger����Ϊ��־
		 * ��ջ�켣�� -> PrintWriter -> StringWriter -> ��logger��
		 * ���ƺ�����������⣬
		 * 0. loggerֻ�ܼ�¼ String ��Ϣ��Ϊ��־
		 * 1. StringWriter ��  String �й���: .toString()
		 * 2. PrintWriter û��ֱ���� String ������ϵ�����ԡ��󶨡�һ��StringWriter
		 * 3. ջ�켣ֻ�ܴ���� PrintWriter
		 */
		StringWriter trace = new StringWriter();  // ����һ��StringWriter	 
		printStackTrace(new PrintWriter(trace));  // ��ջ�켣��ӡ�� PrintWriter
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
