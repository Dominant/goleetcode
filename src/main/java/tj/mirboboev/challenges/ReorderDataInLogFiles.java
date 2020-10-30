package tj.mirboboev.challenges;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class ReorderDataInLogFiles {
    public static void main(String[] args) {
        String[] result = reorderLogFiles(new String[]{"a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo","a2 act car"});

        for (String log : result) {
            System.out.print(log + ", ");
        }
    }

    public static String[] reorderLogFiles(String[] logs) {
        ArrayList<String> letterLogs = new ArrayList<>();
        ArrayList<String> digitLogs = new ArrayList<>();

        for (String log : logs) {
            if (isLetterLog(log)) {
                letterLogs.add(log);
            } else {
                digitLogs.add(log);
            }
        }

        letterLogs.sort((a, b) -> {
            String[] a1 = a.split(" ");
            String[] b1 = b.split(" ");
            String a10 = a1[0];
            String b10 = b1[0];
            a1[0] = "";
            b1[0] = "";

            int equals = String.join(" ", a1).compareTo(String.join(" ", b1));

            if (equals == 0) {
                return a10.compareTo(b10);
            }

            return equals;
        });

        letterLogs.addAll(digitLogs);
        String[] result = new String[letterLogs.size()];

        for (int i = 0; i < letterLogs.size(); i++) {
            result[i] = letterLogs.get(i);
        }

        return result;
    }

    private static boolean isLetterLog(String log) {
        boolean spaceSeen = false;
        int pointer = 0;

        Set<Character> digitCharacters = new HashSet<Character>() {{
            add('0');
            add('1');
            add('2');
            add('3');
            add('4');
            add('5');
            add('6');
            add('7');
            add('8');
            add('9');
        }};

        while (!spaceSeen) {
            if (log.charAt(pointer) == ' ') {
                spaceSeen = true;
            }

            pointer++;
        }

        return !digitCharacters.contains(log.charAt(pointer));
    }
}
