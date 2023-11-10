/*
利用自然數公式( e = 1 + 1/(1!) + 1/(2!) + .....+1/n!) 
撰寫一程式， 輸入n求e值
---------------------------------------------------
輸入
  1.
    100
  2.
    1
輸出
  1.
    2.7182818284590455
  2.
    2.0
---------------------------------------------------
*/

import java.util.Scanner;

class CalculateE {
    double e = 1.0;
    int n;

    public CalculateE(int n) {
        this.n = n;
    }

    public double cal() {
        double factorial = 1.0;
        for (int i = 1; i <= n; i++) {
            factorial *= i;
            e += 1.0 / factorial;
        }
        return e;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        CalculateE e = new CalculateE(n);
        System.out.println(e.cal());
    }
}
