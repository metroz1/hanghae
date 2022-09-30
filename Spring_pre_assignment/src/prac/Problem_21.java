package prac;

public class Problem_21 {

    public int solution(int[] nums) {
        int count = 0;

        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (isPrimeNum(nums[i] + nums[j] + nums[k])) count++;
                }
            }
        }

        return count;

    }

    public static boolean isPrimeNum(int x) {
        for (int i = 2; i < x - 1; i++) {
            if (x == 2) return true;
            else if (x % i == 0) return false;
        }
        return true;
    }
}
