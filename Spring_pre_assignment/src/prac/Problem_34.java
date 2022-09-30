package prac;

import java.util.HashMap;

public class Problem_34 {
    public int solution(int[] nums) {
        HashMap<Integer, Integer> phoneketmonMap = new HashMap<Integer, Integer>();

        for (int i = 0; i < nums.length; i++) {
            if (phoneketmonMap.containsKey(nums[i])) {
                phoneketmonMap.put(nums[i], phoneketmonMap.get(nums[i]) + 1);
            } else {
                phoneketmonMap.put(nums[i], 1);
            }
        }

        if (nums.length / 2 < phoneketmonMap.size())
            return nums.length / 2;

        else return phoneketmonMap.size();
    }
}
