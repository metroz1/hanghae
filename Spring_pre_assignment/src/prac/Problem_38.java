package prac;

public class Problem_38 {
    public String solution(String s) {
        String answer = "";
        String[] str = s.split(" ");
        int maxVal = Integer.MIN_VALUE;
        int minVal = Integer.MAX_VALUE;

        for (int i = 0; i < str.length; i++) {
            int val = Integer.parseInt((str[i]));

            maxVal = Math.max(maxVal, val);
            minVal = Math.min(minVal, val);
        }
        answer = minVal + " " + maxVal;

        return answer;
    }
}
