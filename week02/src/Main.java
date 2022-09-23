import java.util.Random;

public class Main {
    public static void main(String[] args) {

//        1번 문제 -----------
//        int var1=5;
//        int var2=2;
//        //double var3=var1/var2;  //현재 Int 타입으로 연산 후 결과만 double 타입에 저장하는 형태
//        double var3 = (int)var1 / var2;  //이렇게 변경
//        int var4=(int)(var3*var2); // 현재 코드를 보면 double var3 = var1 / var2; 부분에서 문제가 발생하고 있다. var1과 var2는 Int 타입 변수이기 때문에 연산 결과 또한 Int 형태(정수)로 돌려준다. 5 / 2 = 2.5에서 소수점을 버린 값인 2를 돌려주게 된다.
//        System.out.println(var4);  //해당 코드를 double var3 = (double)var1 / var2;로 변경하면 나누기 연산 전에 double 타입으로 타입 변환이 일어나기 때문에 소수점까지 연산 결과에 돌려줄 수 있다.

//        2번 문제 ---------
//        int x=10; //x에는 정수 10
//        int y=20; // y에는 정수 20
//        int z = (++x) + (y--); //x는 11로 증가한 다음 연산되고 y는 연산 후 감소
//        System.out.println(z); //++x 혹은 x--와 같은 증감 연산자를 사용할 경우 연산자가 앞에 위치하냐 뒤에 위치하냐에 따라 연산 값이 바뀐다. 앞에 위치할 경우에는 연산을 수행하기 전에 값을 증감시키고, 뒤에 위치할 경우에는 연산을 수행한 다음 값을 증감시킨다.

//        3번 문제 -------

        System.out.println("시작!"); //Math.random() 함수는 double 0보다 크고 1보다 작은 double 형태(큰 범위의 실수)의 값을 돌려주는 메소드이기 때문에 우리가 구하려는 주사위 눈의 값인 1 ~ 6 사이의 값이 나오게 하기 위해서는 다음과 같은 코드가 필요하다.
        int a = 0;
        int b = 0;
        while (a + b != 5) {
            a = (int) (Math.random() * 6) + 1; // (int) (Math.random() * 6) + 1) 이와 같이 계산할 경우 0.0에서 1.0 사이의 값에 6을 곱해주기 때문에 수의 범위가 0.0에서 6.0 사이의 값으로 늘어나고 거기에 최소값인 1을 더해주어 수의 범위를 1.0에서 7.0까지로 만들어 준 다음 int 형태로 타입을 변환해 소수점 자리를 날려준다.
            b = (int) (Math.random() * 6) + 1;

            System.out.println("(" + a + "," + b + ")");
        }
        System.out.println("끝!");

    }
}