package prac;

import java.util.ArrayList;
import java.util.List;

public class Problem_15 {

    public int[] solution(int[] arr) {
        int temp = -1; // arr 원소의 값이 0~9 이기 때문에 0이 아닌 -1로 비교에 사용할 값 정해줌
        List<Integer> tempArray = new ArrayList<Integer>(); // 중복 제외한 값을 저장할 리스트

        for (int i = 0; i < arr.length; i++) {
            if (temp != arr[i]) {  // 이전 값과 이번 값이 동일하지 않으면 문자열에 원소 값 추가하고 비교 값에 현재 값 넣어줌
                tempArray.add(arr[i]);
                temp = arr[i];
            }
        }
        int[] answer = tempArray.stream().mapToInt(i -> i).toArray(); // ArrayList 타입을 Int[]로 변환
        return answer;
    }
}
