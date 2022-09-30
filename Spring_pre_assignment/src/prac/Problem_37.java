package prac;

public class Problem_37 {
    public int solution(String dartResult) {
        int[] score = new int[3];
        int scoreIdx = 0;
        int answer = 0;
        int tempScore = 0;

        for (int i = 0; i <= dartResult.length(); i++) {

            if (i == dartResult.length()) {
                score[scoreIdx] = tempScore;
                break;
            }
            char pick = dartResult.charAt(i);
            if (pick == '#') {
                tempScore = -tempScore;
            }
            else if (pick == '*') {
                if (scoreIdx > 0) {
                    score[scoreIdx - 1] = (score[scoreIdx - 1]) * 2;
                    tempScore = tempScore * 2;
                } else {
                    tempScore = tempScore * 2;
                }
            }
            else if (pick == 'D')
                tempScore = (int) Math.pow(tempScore, 2);
            else if (pick == 'T')
                tempScore = (int) Math.pow(tempScore, 3);
            else if (pick == 'S')
                tempScore = (int) Math.pow(tempScore, 1);
            else {
                if (pick == '1' && dartResult.charAt(i + 1) == '0') {

                    if (i == 0) {
                        tempScore = 10;
                        i++;
                    }

                    else {
                        score[scoreIdx] = tempScore;
                        scoreIdx++;
                        tempScore = 10;
                        i++;
                    }
                }
                else if (i > 0) {
                    score[scoreIdx] = tempScore;
                    scoreIdx++;
                    tempScore = Character.getNumericValue(pick);

                }
                else
                    tempScore = Character.getNumericValue(pick);
            }

        }
        for (int i = 0; i < score.length; i++) {
            answer += score[i];
        }
        return answer;
    }
}
