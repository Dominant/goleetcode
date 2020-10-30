package tj.mirboboev.mock;

import java.util.*;

public class PhoneNumberLetterCombinations {
    public List<String> letterCombinations(String digits) {
        Map<Character, List<String>> digitToLetterMap = new HashMap<>();
        digitToLetterMap.put('2', Arrays.asList("a", "b", "c"));

        digitToLetterMap.put('3', Arrays.asList("d", "e", "f"));
        digitToLetterMap.put('4', Arrays.asList("g", "h", "i"));
        digitToLetterMap.put('5', Arrays.asList("j", "k", "l"));

        digitToLetterMap.put('6', Arrays.asList("m", "n", "o"));
        digitToLetterMap.put('7', Arrays.asList("p", "q", "r", "s"));
        digitToLetterMap.put('8', Arrays.asList("t", "u", "v"));
        digitToLetterMap.put('9', Arrays.asList("w", "x", "y", "z"));

        List<String> result = new ArrayList<>();

        char[] digitsArray = digits.toCharArray();

        if (digitsArray.length == 1) {
            return digitToLetterMap.get(digitsArray[0]);
        }



        return result;
    }
}
