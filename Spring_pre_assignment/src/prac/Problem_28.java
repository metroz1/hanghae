package prac;

public class Problem_28 {

    public int[] solution(int n, int m) {

        int[] answer = new int[2];
        answer[0] = getMaxDivisor(n, m);
        answer[1] = (n * m) / answer[0];
        return answer;
    }
    public static int getMaxDivisor(int n, int m) {
        if (n < m) {
            int temp = n;
            n = m;
            m = temp;
        }
        while(m != 0) {
            int r = n % m;
            n = m;
            m = r;
        }
        return n;
    }
}
