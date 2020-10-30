package tj.mirboboev.challenges;

import java.util.Stack;

public class BasicCalculatorII {
    public static void main(String[] args) {
        System.out.println(calculate("3+2*2"));
        System.out.println(calculate(" 3/2 "));
        System.out.println(calculate(" 3+5 / 2 "));
        System.out.println(calculate("1 + 1"));
        System.out.println(calculate("0-2147483647"));
    }

    public static int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        s = s.replaceAll("\\s", "");

        char[] chars = s.toCharArray();
        int num = 0;
        String nextNum;

        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];

            if (Character.isDigit(c)) {
                num = num * 10 + Character.getNumericValue(c);
            } else {
                switch (c) {
                    case '-':
                        stack.push(num);
                        nextNum = nextNum(chars, i + 1);
                        i += nextNum.length();
                        stack.push(-1 * Integer.parseInt(nextNum));
                        break;
                    case '+':
                        stack.push(num);
                        break;
                    case '*':
                        stack.push(num);
                        nextNum = nextNum(chars, i + 1);
                        i += nextNum.length();
                        stack.push(stack.pop() * Integer.parseInt(nextNum));
                        break;
                    case '/':
                        stack.push(num);
                        nextNum = nextNum(chars, i + 1);
                        i += nextNum.length();
                        stack.push(stack.pop() / Integer.parseInt(nextNum));
                        break;
                }
                num = 0;
            }

            if (i == chars.length - 1) {
                stack.push(num);
            }
        }

        int sum = 0;

        if (stack.isEmpty()) {
            sum = num;
        }

        while (!stack.isEmpty()) {
            sum += stack.pop();
        }

        return sum;
    }

    private static String nextNum(char[] chars, int i) {
        StringBuilder num = new StringBuilder();
        for (int j = i; j < chars.length; j++) {
            char c = chars[j];

            if (Character.isDigit(c)) {
                num.append(c);
            } else {
                break;
            }
        }

        return num.toString();
    }
}
