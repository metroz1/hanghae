package prac;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;


public class Problem_32 {
    // 실패율 = 스테이지 도달 했으나 클리어 x 유저수 / 스테이지 도달한 유저수
    // 전체 스테이지의 개수 N, 사용자가 현재 멈춰있는 스테이지의 번호가 담긴 배열 stages
    // 실패율이 높은 스테이지부터 내림차순으로 스테이지 번호가 들어있는 배열 return
    public int[] solution(int N, int[] stages) {
        HashMap<String, Integer> stayMap = new HashMap<>();
        HashMap<String, Integer> clearMap = new HashMap<>();
        double[][] failureRate = new double[N][2];
        for (int i = 1; i <= N + 1; i++) { // 해쉬맵 초기 세팅
            stayMap.put(Integer.toString(i), 0);
            clearMap.put(Integer.toString(i), 0);
        }
        for(int i = 0; i < stages.length; i++) { //스테이지 별 클리어한 사람 수와 머물러 있는 사람 수를 각각 해쉬맵에 넣어줌
            stayMap.put(Integer.toString(stages[i]), stayMap.get(Integer.toString(stages[i])) + 1);
            for (int j = 1; j <= stages[i]; j++)
                clearMap.put(Integer.toString(j),clearMap.get(Integer.toString(j)) + 1);
        }
        for (int i = 1; i <= failureRate.length; i++) {
            String str = Integer.toString(i);
            failureRate[i - 1][0] = i;
            double a = (double) stayMap.get(str);
            double b = (double) clearMap.get(str);
            if (a == 0 || b == 0)
                failureRate[i - 1][1] = 0.0;
            else
                failureRate[i - 1][1] = a / b;
        }

        Arrays.sort(failureRate, new Comparator<double[]>() {
            @Override
            public int compare(double[] o1, double[] o2) {
                return Double.compare(o2[1], o1[1]);
            }
        });
        int[] answer = new int[failureRate.length];
        for (int i = 0; i < N; i++) {
            answer[i] = (int)failureRate[i][0];
        }
        return answer;
    }

}
