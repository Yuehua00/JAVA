/*
把一個數字反轉並相加的方法很簡單：就是把數字反轉並加上原來的數字。假如這個 和不是一個迴文（指這個數字從左到右和從右到左都相同），就一直重複這個程序。假設開 始的數字是 195，轉換過程如下:

       9339 迴文數字出現了，在這個例子中，經過了 4 次相加後得到了迴文 9339。幾乎對所 有的整數這個方法都會得到迴文，但是也有有趣的例外。196 是第 1 個用這個方法找不到迴 文的數字，然而並沒有證明該迴文不存在。現在給你一個開始的數字，你的任務就是求出經 過多少次相加後，會產生哪一個迴文。對所有的測試資料，你可以假設： 1. 都會有 1 個答案。 2. 在 1000 個相加內都會得到答案。 3. 產生的迴文數字 <= 2 64 -1.

Input
       第1列有一個整數N（0 < N <= 100），代表以下有幾組測試資料。每筆測試資料一列， 各有 1 個整數 P，就是開始的數字。

Output
        對每一測試資料，請輸出 2 個數字：得到迴文所需的最少次數的相加，以及該迴文。
*/
import jdk.jfr.Unsigned;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int i = 0; i < n; i++){
            long num = in.nextLong();
            int time = 0, con = 1;
            num += reverse(num);
            while(con == 1){
                long r = reverse(num);
                if(num != r){
                    num += r;
                    time++;
                }else{
                    con = 0;
                }
            }
            System.out.println((time+1) + " " + num);

        }
    }

    static long reverse(long n){
        long r = 0;
        while(n > 0){
            r = r * 10 + n % 10;
            n /= 10;
        }

        return r;
    }
}
