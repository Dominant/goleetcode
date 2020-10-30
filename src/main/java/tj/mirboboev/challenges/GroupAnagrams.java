package tj.mirboboev.challenges;

import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {
        groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"});
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> hashmap = new HashMap<>();

        for (String word : strs) {
            String wordKey = sort(word);
            List<String> wordSets = hashmap.getOrDefault(wordKey, new ArrayList<>());
            wordSets.add(word);
            hashmap.put(wordKey, wordSets);
        }

        for (String wordKey : hashmap.keySet()) {
            List<String> words = new ArrayList<>(hashmap.get(wordKey));
            result.add(words);
        }

        return result;
    }

    public static String sort(String word) {
        char[] chars = word.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
