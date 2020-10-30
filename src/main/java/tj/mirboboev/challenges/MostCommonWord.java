package tj.mirboboev.challenges;

import java.util.*;

public class MostCommonWord {
    public static void main(String[] args) {
        System.out.println(new MostCommonWord().mostCommonWord(
                "Bob hit a ball, the hit BALL flew far after it was hit.",
                new String[]{"hit"}
        ));

        System.out.println(new MostCommonWord().mostCommonWord(
                "Bob. hIt, baLl",
                new String[]{"hit", "bob"}
        ));
    }

    public String mostCommonWord(String paragraph, String[] banned) {
        paragraph = paragraph.toLowerCase().replaceAll("[^a-z\\s]", " ").replaceAll("\\s\\s", " ");

        Set<String> bannedSet = new HashSet<>(Arrays.asList(banned));
        Map<String, Integer> frequencyMap = new HashMap<>();

        String mostCommonWord = "";

        for (String word : paragraph.split(" ")) {
            if (bannedSet.contains(word) || word.equals(" ")) {
                continue;
            }

            int wordFrequency = frequencyMap.getOrDefault(word, 0);
            frequencyMap.put(word, wordFrequency + 1);

            if (wordFrequency + 1 > frequencyMap.getOrDefault(mostCommonWord, 0)) {
                mostCommonWord = word;
            }
        }

        return mostCommonWord;
    }
}
