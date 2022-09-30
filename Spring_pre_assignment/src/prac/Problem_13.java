package prac;

import java.util.Calendar;

public class Problem_13 {

    public int solution(int n) {
        String temp = "";
        int answer = 0;

        while (true) {

            if (n < 3) {
                temp += n;
                break;
            }
            temp += n % 3;
            n = n / 3;
        }
        for(int i = temp.length(); i > 0; i--) {
            answer += Character.getNumericValue(temp.charAt(i - 1)) * Math.pow(3, temp.length() - i);
        }
        return answer;
    }
}

