package prac;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Problem_31 {
    public int solution(int n) {
        int count = 0;

        List<Integer> primeArr = new ArrayList<Integer>();
        for (int i = 2; i <= n; i++) {
            if (i == 2 || i == 3 || i == 5) {
                primeArr.add(i);
            }
            else {
                for (int j = 0; j < primeArr.size(); j++) {
                    if (i % primeArr.get(j) == 0)  {
                        break;
                    } else if (Math.sqrt(i) < primeArr.get(j)) {
                        primeArr.add(i);
                        break;
                    }
                }
            }
        }
        return primeArr.size();
    }
}
