import java.util.HashMap;
import java.util.Map;

public class CountOfWords {

	public static void main(String[] args) {
		String text = "How much wood could a woodchuck chuck if a woodchuck could chuck wood was looking for";

		int count = 0;
		String temp = null;

		Map<String, Integer> map = new HashMap<String, Integer>();

		String[] wordsArr = text.split(" ");

		for (String val : wordsArr) {
			String word = val.toLowerCase();
			if (map.containsKey(word)) {
				count = map.get(word);
				map.put(word, count + 1);
			} else {
				map.put(word, 1);
			}
		}
		System.out.println(map);
	}
}