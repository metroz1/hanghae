package prac;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Problem_40 {
    public int solution(int[][] board, int[] moves) {
        int count = 0;
        List<Stack<Integer>> field = new ArrayList<Stack<Integer>>();
        Stack<Integer> bucket = new Stack<Integer>();

        for (int i = 0; i < board.length; i++) {
            field.add(i, new Stack<Integer>());
            for (int j = board.length - 1; j >= 0; j--) {
                if (board[j][i] != 0) {
                    field.get(i).push(board[j][i]);
                }
            }
        }

        for (int i = 0; i < moves.length; i++) {
            if (field.get(moves[i] - 1).isEmpty())
                continue;
            int pickVal = field.get(moves[i] - 1).pop();
            if (bucket.size() > 0 && pickVal == bucket.peek()) {
                bucket.pop();
                count = count + 2;
            }
            else
                bucket.push(pickVal);
        }
        return count;
    }
}
