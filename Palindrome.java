import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Palindrome {

	public static void main(String[] args) {
		String word = "level mom racecar radar";
		List<String> lStrings = new ArrayList<>();

		String[] wordsArr = word.split(" ");
		int index = 0;
		for (String val : wordsArr) {

			char[] check = val.toCharArray();
			String rev = "";
			int c = val.length();

			for (int i = c; i > 0; i--) {
				rev = rev + check[i - 1];
			}
			if (val.equalsIgnoreCase(rev)) {
				lStrings.add(rev);
			}
		}
		System.out.println(lStrings);
		int largestString = lStrings.get(0).length();
		for (int i = 0; i < lStrings.size(); i++) {
			if (lStrings.get(i).length() > largestString) {
				largestString = lStrings.get(i).length();
				index = i;
			}
		}
		System.out.println(lStrings.get(index) + " " + "is the longest String");
	}
}
