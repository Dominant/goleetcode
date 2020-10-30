package tj.mirboboev.challenges;

import java.util.*;

public class PartitionLabels {
    public static void main(String[] args) {
        System.out.println(partitionLabels("ababcbacadefegdehijhklij"));
    }

    public static List<Integer> partitionLabels(String S) {
        List<Integer> result = new ArrayList<>();
        List<Interval> intervals = mergeIntervals(partitionIntervals(S));

        for (Interval interval : intervals) {
            result.add(interval.end - interval.start + 1);
        }

        return result;
    }

    private static List<Interval> mergeIntervals(List<Interval> intervals) {
        List<Interval> result = new ArrayList<>();

        if (intervals.size() == 0) {
            return result;
        }

        if (intervals.size() == 1) {
            return Arrays.asList(intervals.get(0));
        }

        Interval currentInterval = intervals.get(0);

        for (int i = 1; i < intervals.size(); i++) {
            Interval nextInterval = intervals.get(i);
            if (currentInterval.end == currentInterval.start) {
                result.add(currentInterval);
                currentInterval = nextInterval;
            } else if (currentInterval.end > nextInterval.start) {
                currentInterval.end = Math.max(currentInterval.end, nextInterval.end);
            } else {
                result.add(currentInterval);
                currentInterval = nextInterval;
            }
        }

        result.add(currentInterval);

        return result;
    }

    public static List<Interval> partitionIntervals(String s) {
        Map<Character, Interval> intervalMap = new HashMap<>();
        List<Interval> intervals = new ArrayList<>();

        int i = 0;

        for (char character : s.toCharArray()) {
            Interval characterInterval = intervalMap.get(character);

            if (characterInterval == null) {
                characterInterval = new Interval(i, i);
                intervalMap.put(character, characterInterval);
                intervals.add(characterInterval);
            } else {
                characterInterval.end = i;
            }

            i++;
        }

        return intervals;
    }

    public static class Interval {
        int start;
        int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "Interval{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }
}
