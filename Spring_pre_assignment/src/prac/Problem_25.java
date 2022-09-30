package prac;

public class Problem_25 {

    public int solution(int left, int right) {
        int sum = 0;
        int divisorNumber = 0;
        for (int i = left; i <= right; i++) {

            divisorNumber = divisorNum(i);

            if (divisorNumber % 2 == 0) sum += i;
            else if (divisorNumber % 2 == 1) sum -= i;

        }
        return sum;
    }

    public static int divisorNum(int num) {
        int count = 0;
        for (int i = 1; i * i <= num; i++) {
            if (i * i == num) count++;
            else if (num % i == 0) count += 2;
        }
        System.out.println(count);
        return count;
    }

//        int answer = 0;
//
//        for (int i = left; i <= right; i++) {
//            if (i % Math.sqrt(i) == 0) answer -= i;
//            else answer += i;
//        }
//
////        return answer;
//    }
}
