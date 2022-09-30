package prac;

public class Problem_39 {
    public int solution(int n) {
        int answer = 0;
        int dif = 1;
        while (n > 0) {
            if (n % dif == 0)
                answer = answer + 1;
            n = n - dif;
            dif++;
        }
        return answer;
    }
}
