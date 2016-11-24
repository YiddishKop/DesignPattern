package strings;
import java.util.regex.*;
import net.mindview.util.*;

/**
 * @author yiddi
 *
 */
public class TheReplacements {
	public static void main(String[] args) throws Exception{//main函数再抛异常，就直接抛给console
		String s = TextFile.read("TheReplacements.java");
		// match the specially commented block of text above:
		Matcher mInput = Pattern.compile("/\\*!(.*)!\\*/", Pattern.DOTALL).matcher(s);
		if (mInput.find()) {
			s = mInput.group(1);// captured by parentheses
		}
		// replace two or more spaces with a single space:
		s = s.replaceAll(" {2,}", " ");
		// replace one or more spaces at the beginning of each
		// line with no spaces. Must enable MULTILINE mode:
		s = s.replaceAll("(?m)^ +", "");
		System.out.println(s);
		s = s.replaceFirst("[aeiou]", "(VOWEL1)");
		StringBuffer sbuf = new StringBuffer();
		Pattern p = Pattern.compile("[aeiou]");
		Matcher m = p.matcher(s);
		// process the find information as you
		// perform the replacements:
		while (m.find()) {
			m.appendReplacement(sbuf, m.group().toUpperCase());
			Matcher.quoteReplacement(s);
		}
		m.appendTail(sbuf);
		System.out.println(sbuf);
	}
	public TheReplacements() {
		// TODO Auto-generated constructor stub
	}

}
