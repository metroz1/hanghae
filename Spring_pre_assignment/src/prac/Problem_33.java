package prac;

import java.util.HashMap;

public class Problem_33 {
    public int solution(int n, int[] lost, int[] reserve) {
        int count = 0;
        HashMap<Integer, Integer> studentMap = new HashMap<Integer, Integer>();

        for (int i = 1; i <= n; i++)
            studentMap.put(i, 1);

        for(int student : lost)
            studentMap.put(student, studentMap.get(student) - 1);

        for(int student : reserve)
            studentMap.put(student, studentMap.get(student) + 1);

        for(int i = 1; i <= n; i++) {
            int gymClothesNum = studentMap.get(i);

            if (i != n) {
                int nextGymClothesNum = studentMap.get(i + 1);
                switch (gymClothesNum) {
                    case 1:
                        count++;
                        break;

                    case 0:
                        if (nextGymClothesNum == 2) {
                            studentMap.put(i, studentMap.get(i) + 1);
                            studentMap.put(i + 1, studentMap.get(i + 1) - 1);
                            count++;
                        }
                        break;

                    case 2:
                        if (nextGymClothesNum == 0) {
                            studentMap.put(i, studentMap.get(i) - 1);
                            studentMap.put(i + 1, studentMap.get(i + 1) + 1);
                            count++;
                        }
                        else count++;
                        break;

                }
            }
            else if (i == n && gymClothesNum >= 1) {
                count++;
            }
        }
        return count;
    }

}
