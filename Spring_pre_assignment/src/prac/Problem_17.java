package prac;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Problem_17 {

    public int[] solution(int[] lottos, int[] winNums) {

        int[] answer = new int[2];
        Integer[] tempArray = Arrays.stream(winNums).boxed().toArray(Integer[]::new);
        Set<Integer> winNumsSet = new HashSet<Integer>(Arrays.asList(tempArray));

//        Set winNumsSet = new HashSet<>();

//        for (int e : winNums)
//            winNumsSet.add(e);

        int acc_count = 0;
        int zero_count = 0;
        for (int i = 0; i < lottos.length; i++) {
            if (lottos[i] == 0)
                zero_count++;

            else if (winNumsSet.contains(lottos[i])) {
                acc_count++;
            }
        }
        if (zero_count + acc_count > 1) {
            answer[0] = 7 - (zero_count + acc_count);
        }
        else answer[0] = 6;

        if (acc_count > 1) {
            answer[1] = 7 - acc_count;
        }
        else answer[1] = 6;

        return answer;
    }

}
