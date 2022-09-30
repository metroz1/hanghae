package prac;

public class Problem_35 {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] decodeArr = new String[n];

        for (int i = 0; i < n; i++) {
            decodeArr[i] = Long.toString(Long.parseLong(toBinary(arr1[i], n)) + Long.parseLong(toBinary(arr2[i], n)));
            int temp = decodeArr[i].length();
            for (int j = 0; j < n - temp; j++) {
                decodeArr[i] = "0" + decodeArr[i];
            }
            decodeArr[i] = decodeArr[i].replaceAll("[1-2]", "#");
            decodeArr[i] = decodeArr[i].replace("0", " ");
        }

        return decodeArr;
    }

    public static String toBinary(int num, int length) {
        String binary = "";

        while (binary.length() != length) {
            binary = (num % 2) + binary;
            if (num != 0)
                num = num / 2;
        }
        return binary;
    }
}
