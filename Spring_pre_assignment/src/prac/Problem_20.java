package prac;

import java.util.Arrays;

public class Problem_20 {

    public String solution(String s) {
        char[] arr = s.toCharArray();
        Arrays.sort(arr);

        String answer = new StringBuilder(new String(arr)).reverse().toString();

        return answer;
    }
}
