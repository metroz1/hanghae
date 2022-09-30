package prac;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


public class Problem_16 {

    public int[] solution(int[] numbers) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                set.add(numbers[i] + numbers[j]);
            }
        }
        Integer[] tempArray = set.toArray(new Integer[0]);

        int[] answer = set.stream().mapToInt(i -> i).toArray();
        Arrays.sort(answer);

        return answer;
    }
}
