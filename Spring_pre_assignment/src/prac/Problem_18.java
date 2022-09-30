package prac;

public class Problem_18 {

    public int[] solution(int[] answers) {
        int firstCount = 0;
        int secondCount = 0;
        int thirdCount = 0;
        int[] first = {1, 2, 3, 4, 5};
        int[] second = {2, 1, 2 ,3 ,2, 4, 2, 5};
        int[] third = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        for (int i = 0; i < answers.length; i++) {
            if (first[i % 5] == answers[i]) firstCount++;
            if (second[i % 8] == answers[i]) secondCount++;
            if (third[i % 10] == answers[i]) thirdCount++;
        }

        if (firstCount == secondCount && secondCount == thirdCount)
             return new int[] {1, 2, 3};
        else if (firstCount == secondCount && secondCount > thirdCount)
            return new int[] {1, 2};
        else  if (firstCount == thirdCount && firstCount > secondCount)
            return new int[] {1, 3};
        else if (secondCount == thirdCount && firstCount < secondCount)
            return new int[] {2, 3};
        else if (Math.max(Math.max(firstCount, secondCount), thirdCount) == firstCount)
            return new int[] {1};
        else if (Math.max(Math.max(firstCount, secondCount), thirdCount) == secondCount)
            return new int[] {2};
        else if (Math.max(Math.max(firstCount, secondCount), thirdCount) == thirdCount)
            return new int[] {3};
        return null;
    }

}
