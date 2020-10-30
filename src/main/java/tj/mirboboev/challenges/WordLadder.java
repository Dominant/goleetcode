package tj.mirboboev.challenges;

import java.util.*;

public class WordLadder {
    public static void main(String[] args) {
        System.out.println(new WordLadder().ladderLength("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog")));
        System.out.println(new WordLadder().ladderLength("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log")));
        System.out.println(new WordLadder().ladderLength("hot", "dog", Arrays.asList("hot", "dog")));
        System.out.println(new WordLadder().ladderLength("hot", "dog", Arrays.asList("hot", "dog", "dot")));
        System.out.println(new WordLadder().ladderLength("a", "c", Arrays.asList("a", "b", "c")));
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordsSet = new HashSet<>(wordList);
        Set<String> excludedSet = new HashSet<>();
        Queue<String> queue = new ArrayDeque<>();

        if (!wordsSet.contains(endWord)) {
            return 0;
        }

        int count = 0;

        queue.add(beginWord);
        excludedSet.add(beginWord);

        if (wordsSet.contains(beginWord)) {
            count++;
        }

        while (!queue.isEmpty()) {
            String word = queue.poll();
            List<String> combinations = wordCombinations(word);
            Set<String> wordCombinationsSet = new HashSet<>(combinations);

            if (wordCombinationsSet.contains(endWord)) {
                return count + 1;
            }

            for (String comb : combinations) {
                if (comb.equals(endWord)) {
                    return count + 1;
                }

                if (wordsSet.contains(comb) && !excludedSet.contains(comb)) {
                    queue.add(comb);
                    excludedSet.add(comb);
                    count++;
                    break;
                }
            }
        }

        return 0;
    }

    public static List<String> wordCombinations(String word) {
        List<String> combinations = new ArrayList<>();

        for (int j = 0; j < word.length(); j++) {
            for (int i = 97; i <= 122; i++) {
                String combination = word.substring(0, j) + (char) i + word.substring(j + 1);

                if (combination.equals(word)) {
                    continue;
                }

                combinations.add(combination);
            }
        }

        return combinations;
    }
}
