package tj.mirboboev.challenges;

import java.util.*;

public class TopKFrequentWords {
    public static void main(String[] args) {
        System.out.println(topKFrequent(new String[]{"i", "love", "leetcode", "i", "love", "coding"}, 2));
    }

    public static List<String> topKFrequent(String[] words, int k) {
        List<String> result = new ArrayList<>();
        Map<String, Integer> frequencyMap = new HashMap<>();

        for (String word : words) {
            int frequency = frequencyMap.getOrDefault(word, 0);
            frequencyMap.put(word, frequency + 1);
        }

        PriorityQueue<WordFrequency> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());

        frequencyMap.forEach((w, f) -> {
            priorityQueue.add(new WordFrequency(f, w));
        });

        for (int i = 0; i < k; i++) {
            result.add(priorityQueue.poll().word);
        }

        return result;
    }

    public static class WordFrequency implements Comparable {
        int frequency;
        String word;

        WordFrequency(int frequency, String word) {
            this.frequency = frequency;
            this.word = word;
        }


        @Override
        public int compareTo(Object o) {
            if (o == this) {
                return 0;
            }

            boolean equalFrequency = this.frequency == ((WordFrequency) o).frequency;

            if (equalFrequency) {
                return -1 * this.word.compareTo(((WordFrequency) o).word);
            }

            return this.frequency - ((WordFrequency) o).frequency;
        }
    }
}
