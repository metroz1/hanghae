package prac;

import java.util.HashMap;

public class Problem_36 {

    public String solution(int[] numbers, String hand) {
        int[] leftHandPlace = {3, 0};
        int[] rightHandPlace = {3, 2};
        String answer = "";

        HashMap<String, int[]> keyPad = new HashMap<String, int[]>() {{
            put("1", new int[]{0, 0});
            put("2", new int[]{0, 1});
            put("3", new int[]{0, 2});
            put("4", new int[]{1, 0});
            put("5", new int[]{1, 1});
            put("6", new int[]{1, 2});
            put("7", new int[]{2, 0});
            put("8", new int[]{2, 1});
            put("9", new int[]{2, 2});
            put("0", new int[]{3, 1});
        }};

        for (int i = 0; i < numbers.length; i++) {
            int[] touchNum = keyPad.get(Integer.toString(numbers[i]));
            if (numbers[i] % 3 == 1) {
                answer = answer + "L";
                leftHandPlace = touchNum.clone();
            } else if (numbers[i] % 3 == 0 && numbers[i] != 0) {
                answer = answer + "R";
                rightHandPlace = touchNum.clone();
            } else {
                int leftHandDistance = Math.abs(leftHandPlace[0] - touchNum[0]) + Math.abs(leftHandPlace[1] - touchNum[1]);
                int rigthHandDistance = Math.abs(rightHandPlace[0] - touchNum[0]) + Math.abs(rightHandPlace[1] - touchNum[1]);

                if (leftHandDistance < rigthHandDistance) {
                    answer = answer + "L";
                    leftHandPlace = touchNum.clone();
                } else if (leftHandDistance > rigthHandDistance) {
                    answer = answer + "R";
                    rightHandPlace = touchNum.clone();
                } else if (hand.equals("right")) {
                    answer = answer + "R";
                    rightHandPlace = touchNum.clone();
                } else if (hand.equals("left")) {
                    answer = answer + "L";
                    leftHandPlace = touchNum.clone();
                }
            }
        }
        return answer;
    }
}
