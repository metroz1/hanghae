package prac;

public class Problem_14 {

    public int solution(int[][] sizes) {
        int maxWidth = 0;
        int maxHeight = 0;
        int tempWidth = 0;
        int tempHeight = 0;
        for (int i = 0; i < sizes.length; i++) {
            tempWidth = Math.max(sizes[i][0], sizes[i][1]);
            maxWidth = Math.max(maxWidth, tempWidth);
            tempHeight = Math.min(sizes[i][0], sizes[i][1]);
            maxHeight = Math.max(maxHeight, tempHeight);
        }
        return maxHeight * maxWidth;
    }
}
