package prac;

public class HarshadNumber {

    public boolean solution(int x) {
        String temp = Integer.toString(x);
        int count = 0;
        for (int i = 0; i < temp.length(); i++) {
            count += Character.getNumericValue(temp.charAt(i));
        }
        if (x % count == 0) return true;
        else return false;
    }
}
