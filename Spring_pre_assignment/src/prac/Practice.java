package prac;

import java.io.*;
import java.util.*;

public class Practice {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int num = N;
        int count = 0;

        String strN = "";
        String temp = "";

        do  {
            if ( N == 0) {
                count++;
                break;
            }
            strN = Integer.toString(N);

            if (N < 10)
                strN = temp + "0";

            temp = Integer.toString(Character.getNumericValue(strN.charAt(0)) + Character.getNumericValue(strN.charAt(1)));
            strN = N % 10 + Character.toString(temp.charAt(temp.length() - 1));
            N = Integer.parseInt(strN);
            count++;
        }while (N != num);
        bw.write(count + "");
        bw.flush();
    }







    public String solutionOne(int a, int b) {
        String answer = "";
        String[] day = {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"}; // 2016년 1월 1일은 금요일이기 때문에 배열의 값을 금요일부터 시작
        int[] dateNum = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};; // 1월부터 12월까지 일수를 저장
        int dateAll = 0; // 총 일수를 구할 변수
        for (int i = 0; i < a - 1; i++) {  // 입력 받은 달 보다 한달 전(a - 1)까지의 모든 일수를 구해줌
            dateAll = dateAll + dateNum[i];
        }

        dateAll += (b - 1); // 원하는 달의 원하는 날짜 값 - 1을 더해줌
        answer = day[dateAll % 7];
        return answer;
    }

    public int[] solutionTwo(int[] arr, int divisor) { // arr의 element 중 divisor로 나누어 떨어지는 값들을 구하는 문제
        ArrayList<Integer> temp = new ArrayList<Integer>(); // 기본 배열의 경우에는 크기가 늘어나지 않기 때문에 ArrayList로 선언

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % divisor == 0) { // 나머지가 0인 arr의 element만 temp에 추가함
                temp.add(arr[i]);
            }
        }
        if (temp.isEmpty()) {
            temp.add(-1);  // 빈 배열일 경우(나누어 떨어지는 값이 없을 경우)
        }
        int[] answer = new int[temp.size()]; // 새로운 int 타입 배열을 만들어 값을 넣어줌

        for (int i = 0; i < temp.size(); i++) {
            answer[i] = temp.get(i);
        }
        Arrays.sort(answer);
        return answer;
    }

    public String solutuonThree(int n) {
        String answer = "";
        for (int i = 0; i < n; i++) {

            if (i % 2 == 0) { // 홀수인지 짝수인지 판별
                answer += "수";
            }
            else {
                answer += "박";
            }
        }

        return answer;
    }

    public String solutionFour(String[] participant, String[] completion) {
        String answer = "";
        Arrays.sort(participant); // 두 배열을 모두 정렬하여 같은 인덱스인데 값이 다른 경우 그 값을 반환
        Arrays.sort(completion);
        for (int i = 0; i < participant.length; i++)
        {
            if (i == participant.length - 1) {
            answer = participant[i];
            return answer;
        }

            else if(!(participant[i].equals(completion[i])))
            {
                answer = participant[i];
                return answer;
            }

        }

        return answer;
    }

    public String solutionFive(String s) {
        String answer = "";
        int count = 0;

        for(int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                count = -1;
                answer += String.valueOf(s.charAt(i));
            }
            else if (count % 2 == 0) {
                answer += String.valueOf(Character.toUpperCase(s.charAt(i)));
            }
            else if (count % 2 == 1) {
                answer += String.valueOf(Character.toLowerCase(s.charAt(i)));
            }
            count++;
        }
        return answer;
    }

    public int solutionSix(int n) {
        int answer = 0;

        String temp = Integer.toString(n);
        for (int i = 0; i < temp.length(); i++) {
            answer += Character.getNumericValue(temp.charAt(i));
        }

        return answer;
    }

    public int[] solutionSeven(long n) {
        int[] answer = {};
        String temp = Long.toString(n);
        answer = new int[temp.length()];

        for (int i = temp.length(); i > 0; i--) {
            answer[temp.length() - i] = Character.getNumericValue(temp.charAt(i - 1));
        }
        return answer;
    }

    public long solutionEight(long n) {
        long answer = 0;
        String temp = Long.toString(n);
        char[] arr = temp.toCharArray();
        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder(new String(arr));

        answer = Long.parseLong(sb.reverse().toString());
        return answer;
    }

    public long solutionNine(long n) {
        if (Math.pow((int) Math.sqrt(n),2) == n) return (long) Math.pow(Math.sqrt(n) + 1, 2);
        return -1;
    }

    public int[] solutionTen(int[] arr) {
        if (arr.length == 1)
            return new int[] {-1};
        int[] answer = new int[arr.length - 1];

        int min = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (min > arr[i])
                min = arr[i];
        }
        int index = 0;
        for (int i = 0; i < arr. length; i++) {
            if (arr[i] != min) {
                answer[index] = arr[i];
                index++;
            }
        }

        return answer;
    }

    public int solutionEleven(int num) {
        int count = 0;
        long longNum = num; // int로 선언할 경우 int의 값 범위를 벗어날 경우 결과에 오류가 있을 수 있음.
        for (int i = 0; i < 500; i++) {

            if (longNum == 1) return count;
            else if (longNum % 2 == 0) longNum = longNum / 2;
            else longNum = longNum * 3 + 1;
            count++;
            System.out.print(count + " " + longNum);
            System.out.println();
        }
        return -1;
    }







//        String str1 = "AB";
//        Problem_23 pb = new Problem_23();
//        String str2 = pb.solution(str1, 1);
//
//        System.out.println(str2);
//        int[] nums = {3,3,3,2,2,2};
//
//
//        Problem_34 pb = new Problem_34();
//        System.out.println(pb.solution(nums));
//
//        int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
//        String hand = "right";
//
//        Problem_36 pb = new Problem_36();
//
//        System.out.println(pb.solution(numbers, hand));
        //[######, ###  #, ##  ##, #### , #####, ### # ]
        //[######,###  #,"##  ##"," #### "," #####","### # "]

       /* Problem_29 pb = new Problem_29();
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        int[] result = pb.solution(array, commands);
        for (int e : result) {
            System.out.print(e + " ");*/


//        System.out.println(animals);  // [monkey, cat, dog] 로 출력된다. -> 추가한 순서가 상관이 없으며 출력 할 때 마다 다른 순서로 나옴.

//        animals.remove("cat"); // 전달 받은 값을 삭제한다. 메소드 타입은 boolean으로 삭제가 되었다면 True 값을 리턴하고 존재하지 않는다면 False를 리턴한다.
//        animals.add("cat");
//        animals.add("dog");
//        animals.add("monkey");
//        animals.add("cow");
//        animals.add("pig");
//        animals.add("horse");
//
//        ArrayList<String> arr = new ArrayList<>();
//        arr.add("cow");
//        arr.add("pig");
//
//        animals.removeAll(arr); // removeAll은 Collection 타입(상속 받은 타입 포함)을 매개 변수로 받아 일치하는 element를 모두 삭제.
//
//        System.out.println(animals);
//
//        animals.clear();
//        System.out.println(animals);

}
