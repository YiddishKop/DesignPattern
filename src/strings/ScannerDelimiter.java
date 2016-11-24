package strings;
import java.util.*;
import java.util.regex.*;

public class ScannerDelimiter {
	public static void main(String[] args) {
		String sca = "12, 42, 78, 99, 42";
		Scanner scanner = new Scanner(sca);
		Scanner scanner1 = new Scanner(sca);
		while (scanner1.hasNextInt()) {
			System.out.println("default: " + scanner1.nextInt());
		}
		scanner.useDelimiter("\\s*,\\s*");
		while (scanner.hasNextInt()) {
			System.out.println(scanner.nextInt());
		}
		Pattern px = scanner.delimiter();
		System.out.println(px);
		MatchResult mr = scanner.match();
	}

}
