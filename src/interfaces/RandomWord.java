package interfaces;
import java.io.IOException;
import java.nio.*;
import java.util.*;

public class RandomWord implements Readable{
	private static Random rand = new Random(47);
	private static final char[] capitals = 
			"ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
	private static final char[] lowers = 
			"abcdefghijklmnopqrstuvwxyz".toCharArray();
	private static final char[] vowels = 
			"aeiou".toCharArray();
	private int count;
	
	public RandomWord(int count) {
		this.count = count;
	}

	@Override
	public int read(CharBuffer cb) throws IOException {
		if (count-- == 0) {
			return -1;
		}
		cb.append(capitals[rand.nextInt(capitals.length)]);
		for (int i = 0; i < 4; i++) {
			cb.append(vowels[rand.nextInt(vowels.length)]);
			cb.append(lowers[rand.nextInt(lowers.length)]);
		}                   
		cb.append(" ");
		return 4;
	}
	public static void main(String[] args) {
		Scanner s = new Scanner(new RandomWord(4));
		while (s.hasNext()) {
			System.out.println(s.next());
		}
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			System.out.println(sc.next() + " : display");
		}
	}
}
