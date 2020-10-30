package tj.mirboboev.challenges;

import java.util.Stack;

public class BaseballGame {
    public static void main(String[] args) {
        System.out.println(new BaseballGame().calPoints(new String[]{"5","2","C","D","+"}));
        System.out.println(new BaseballGame().calPoints(new String[]{"5","-2","4","C","D","9","+","+"}));
        System.out.println(new BaseballGame().calPoints(new String[]{"1"}));
    }

    public int calPoints(String[] ops) {
        int sum = 0;

        Stack<Integer> stack = new Stack<>();

        for (String op : ops) {
            switch (op) {
                case "+":
                    Integer val1 = stack.pop();
                    Integer val2 = stack.peek();
                    stack.push(val1);
                    stack.push(val2 + val1);
                break;
                case "D":
                    Integer lastRoundScore = stack.peek();
                    stack.push(lastRoundScore * 2);
                break;
                case "C":
                    stack.pop();
                break;
                default:
                    stack.push(Integer.valueOf(op));
            }
        }

        while (!stack.empty()) {
            sum += stack.pop();
        }

        return sum;
    }
}
