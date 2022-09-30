package prac;

public class Problem_26 {

    public int solution(int n) {
        int answer = 0;

        if (n == 0) return answer;
        else if (n == 1) return 1;

        for (int i = 2; i <=  n / 2; i++) {
            if (n % i == 0) answer += i;
        }
        answer += 1 + n;
        return answer;
    }


}
