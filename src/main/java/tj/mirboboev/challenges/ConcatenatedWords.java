package tj.mirboboev.challenges;

import java.util.*;

public class ConcatenatedWords {
    public static void main(String[] args) {
        List<String> result = new ConcatenatedWords().findAllConcatenatedWordsInADict(
                new String[]{"cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"}
        );

        System.out.println(result);
    }

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> result = new ArrayList<>();
        Set<String> wordSet = new HashSet<>(Arrays.asList(words));
        Map<String, Boolean> cache = new HashMap<>();

        for (String word : words) {
            if (concatedByOtherWords(word, wordSet, cache)) {
                result.add(word);
            }
        }

        return result;
    }

    boolean concatedByOtherWords(String word, Set<String> words, Map<String, Boolean> cache) {
        if (cache.containsKey(word)) {
            return cache.get(word);
        }

        for (int i = 0; i < word.length(); i++) {
            String left = word.substring(0, i);
            String right = word.substring(i);

            if (words.contains(left)) {
                if ((words.contains(right) || concatedByOtherWords(right, words, cache))) {
                    cache.put(word, true);
                    return true;
                }
            }
        }

        cache.put(word, false);
        return false;
    }
}
