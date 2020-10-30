package tj.mirboboev.challenges;

import java.util.*;

public class MeetingRoomsII {
    public static void main(String[] args) {
        System.out.println(minMeetingRooms(new int[][]{{0, 30}, {5, 10}, {15, 20}}));
        System.out.println(minMeetingRooms(new int[][]{{7, 10}, {2, 4}}));
        System.out.println(minMeetingRooms(new int[][]{{5, 8}, {6, 8}}));
        System.out.println(minMeetingRooms(new int[][]{{2, 11}, {6, 16}, {11, 16}}));
    }

    public static int minMeetingRooms(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }

        if (intervals.length == 1) {
            return 1;
        }

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> result = mergeSortedInterval(intervals);

        return result.size();
    }

    public static List<int[]> mergeSortedInterval(int[][] intervals) {
        List<int[]> result = new ArrayList<>();

        Set<Integer> merged = new HashSet<>();
        merged.add(0);



        return result;
    }
}
