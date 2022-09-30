package prac;

public class Problem_23 {

    public String solution(String s, int n) {
//        String[] lowerAlphabet = "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz".split("");
//        String[] upperAlphabet = "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz".toUpperCase().split("");
//        char[] charArr = s.toCharArray();
//        for (int i = 0; i < charArr.length; i++) {
//            for (int j = 0; j < lowerAlphabet.length; j++) {
//
//                if (Character.isLowerCase(charArr[i]))
//                    if (Character.toString(charArr[i]) == lowerAlphabet[j]) {
//                        charArr[i] = lowerAlphabet[j + n].charAt(0);
//                        break;
//                    }
//                else if (Character.isUpperCase(charArr[i]))
//                    if (Character.toString(charArr[i]) == upperAlphabet[j]) {
//                        charArr[i] = upperAlphabet[j + n].charAt(0);
//                        break;
//                    }
//            }
//        }
//        s = new String(charArr);
//        return s;
        String answer = "";
        char[] charArr = s.toCharArray();
        for (int i = 0; i < charArr.length; i++) {
            if (Character.isUpperCase(charArr[i])) {
                charArr[i] = (char) ((charArr[i] - 'A' + n) % 26 + 'A');
            }
            else if (Character.isLowerCase(charArr[i])) {
                charArr[i] = (char) ((charArr[i] - 'a' + n) % 26 + 'a');
            }
            answer += charArr[i];
        }
        return answer;
    }

}
