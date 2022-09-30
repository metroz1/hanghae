package prac;

import java.util.*;

public class Problem_19 {

    public String[] solution(String[] strings, int n) {
        List<String> arr = new ArrayList<>();
        String[] answer = new String[strings.length];

        for (int i = 0; i < strings.length; i++) {
            arr.add(strings[i].charAt(n) + strings[i]);
        }
        Collections.sort(arr);

        for (int i = 0; i < arr.size(); i++) {
            arr.set(i,arr.get(i).substring(1));
            answer[i] = arr.get(i);
        }

        return answer;

    }

}
