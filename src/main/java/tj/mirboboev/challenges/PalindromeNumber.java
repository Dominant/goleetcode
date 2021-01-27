package tj.mirboboev.challenges;

public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        if (x < 10) {
            return true;
        }

        int reversed = reverse(x);

        while (x > 10) {
            if (x % 10 != reversed % 10) {
                return false;
            }

            x = x / 10;
            reversed = reversed / 10;
        }

        return x == reversed;
    }

    static int reverse(int n) {
        int result = 0;

        while(n >= 10) {
            result = result * 10 + n %10;
            n = n / 10;
        }

        return result * 10 + n;
    }
}
