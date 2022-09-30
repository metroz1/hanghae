package prac;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Problem_22 {

//    public int solution(String s) {
//        char[] charArr = s.toCharArray();
//        Map<String, Integer> map = Map.of(
//                "zero", 0,
//                "one", 1,
//                "two", 2,
//                "three", 3,
//                "four", 4,
//                "five", 5,
//                "six", 6,
//                "seven", 7,
//                "eight", 8,
//                "nine", 9
//        );
//        String tempStr = "";
//        String answer = "";
//
//        for(int i = 0; i < charArr.length; i++) {
//            if (map.containsValue(Character.getNumericValue(charArr[i])))
//                answer += charArr[i];
//            else {
//                tempStr += charArr[i];
//                if (map.containsKey(tempStr)) {
//                    answer += map.get(tempStr);
//                    tempStr = "";
//                }
//            }
//        }
//        return Integer.parseInt(answer);
//    }

    public int solution(String s) {
        String[] digits = {"0","1","2","3","4","5","6","7","8","9"};
        String[] alphabets = {"zero","one","two","three","four","five","six","seven","eight","nine"};
        for (int i = 0; i < 10; i++) {
            s = s.replaceAll(alphabets[i], digits[i]);
        }
        return Integer.parseInt(s);
    }
}
