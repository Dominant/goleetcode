package tj.mirboboev.challenges;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortCharactersByFrequency {
    public static void main(String[] args) {
        System.out.println(frequencySort("tree"));
    }

    public static String frequencySort(String s) {
        Map<Character, Integer> frequencyMap = new HashMap<>();

        for (char c : s.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        List<Character> characterList = new ArrayList<>(frequencyMap.keySet());
        characterList.sort((a, b) -> frequencyMap.get(b) - frequencyMap.get(a));

        StringBuilder builder = new StringBuilder();

        for (char c : characterList) {
            for (int i = 0; i < frequencyMap.get(c); i++) {
                builder.append(c);
            }
        }

        return builder.toString();
    }
}
