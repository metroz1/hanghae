package prac;

public class Problem_30 {
    public int solution(int n) {
        if (n % 2 == 1) return 2;
        else {
            for (int i = 2; i <= n / 2; i++) {
                if (n % i == 1)
                    return i;
            }

            return n - 1;
        }
    }
}