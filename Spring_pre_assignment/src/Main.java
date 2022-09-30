import java.util.*;

public class Main {
    public static void main(String[] args) {
        Main method = new Main();
//        int[] numArray = {1, 3, 5, 9, 2, 4, 8, 0};
//        System.out.println(method.solution1(numArray));
//         여기까지 1번

//        String s = "hang hae ninety nine";
//        System.out.println(method.solution2(s));
//
////         여기까지 2번
//
        String[] arr = {"coke", "water", "glass", "dog", "dog", "yogurt", "vitamin"};
        int n = 2;
        String[] result = method.solution3(arr, n);
        for (String s : result)
            System.out.print(s + " ");

//         여기까지 3번
    }

    public int solution1(int[] numArray) {
        int answer = 0;
        int max = 0;
        int min = 0;

        Set<Integer> numSet = new HashSet<Integer>();
        List<Integer> emptyNum = new ArrayList<>();


        for (int i = 0; i < numArray.length; i++)
            numSet.add(numArray[i]);

        for (int i = 0; i < 10; i++) {
            if (!numSet.contains(i))
                emptyNum.add(i);
        }
        max = Math.max(emptyNum.get(0), emptyNum.get(1));
        min = Math.min(emptyNum.get(0), emptyNum.get(1));

        for (int i = min; i <= max; i++)
            answer += i;

        return answer;
    }

    public String solution2(String s) {
        String answer = "";
        int count = 0;

        for(int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                answer += String.valueOf(s.charAt(i));
            }
            else if (count % 2 == 0) {
                answer += String.valueOf(Character.toUpperCase(s.charAt(i)));
                count++;
            }
            else if (count % 2 == 1) {
                answer += String.valueOf(Character.toLowerCase(s.charAt(i)));
                count++;
            }
        }
        return answer;
    }

    public String[] solution3(String[] arr, int n) {
        String[] answer = {};
        Set<String> wordSet = new HashSet<String>();

        for (int i = 0; i < arr.length; i++) {
            if (wordSet.contains(arr[i])) {
                wordSet.remove(arr[i]);
            }
            else wordSet.add(arr[i]);
        }

        answer = wordSet.toArray(new String[0]);

        for (int i = 0; i < wordSet.size(); i++) {
            answer[i] = answer[i].charAt(n) + answer[i];
        }

        Arrays.sort(answer);

        for (int i = 0; i < answer.length; i++) {
            answer[i] = answer[i].substring(1);
        }
        return  answer;
    }
}