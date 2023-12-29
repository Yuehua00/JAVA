/*
Problem
        輸入數字 N (資料型態為 Integer)， 請輸出該數字的所有質因數及其次方。例如 N=360=23 *32 *5。此題數字可能會有質數出現。
Requirement
請撰寫以下兩個 static methods： (未依規定，以 0 分計)

1. boolean [] PrimeArray(long N) {….}
         which returns an array A of Boolean values, where A[i] is true if i is a prime number, otherwise, A[i] is false if i is not a prime number. Note that A.length = N+1; Hint: if n is a prime number, then n * j is not a prime, where j >= 2;

2. String PrimeFactorization(long N) {…}
         which returns a string of prime factorization for the number N. For example, if N = 360, the returned string is “2^3 * 3^2 * 5”.

Input
        輸入有多列，每列有個整數 N，最多 1000 列。

Output
        第一行輸出所有數字中之最大數X及其開根號整數X，其後針對每一組測資數字N， 輸出 N的質因數分解，將數字 N的所有質因數（及其次方）以小到大方式顯示出來，如質因 數之次方數大於 1，以^運算符號顯示，不同質因數間以 * 運算符號互相連接， *運算符號前 後加空格。
*/
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] ans = new String[1000+5];
        long big = 0;
        int cnt = 0;
        boolean[] primeList = PrimeArray(1000001);
        while(in.hasNext()){
            long n = in.nextLong();
            if(n > big) big = n;
            ans[cnt] = PrimeFactorization(n, primeList);
            cnt++;
        }

        System.out.println(big + " " + (int)Math.pow(big, 0.5));
        for(int i = 0; i < cnt; i++){
            System.out.println(ans[i]);
        }
    }

    public static boolean [] PrimeArray(long N){
        boolean[] isPrime = new boolean[(int) (N + 1)];
        for (int i = 2; i <= N; i++) {
            isPrime[i] = true;
        }
        for (int z = 2; z * z <= N; z++){
            if(isPrime[z]){
                for(int j = z*z; j <= N; j += z){
                    isPrime[j] = false;
                }
            }
        }
        return isPrime;
    }

    public static String PrimeFactorization(long N, boolean[] isPrime){
        StringBuilder result = new StringBuilder();
        if(N == 1) result.append("1");
        for(int i = 2; i <= N; i++){
            if(isPrime[i]){
                int cnt = 0;
                while(N % i == 0){
                    cnt++;
                    N /= i;
                }
                if(cnt > 0){
                    result.append(i);
                    if(cnt > 1){
                        result.append("^").append(cnt);
                    }
                    result.append(" * ");
                }
            }
        }

        if(result.length() >= 3){
            result.setLength(result.length() - 3);
        }
        return result.toString();
    }

}
