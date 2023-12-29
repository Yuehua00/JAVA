/*
Problem
        If you have good observations skills, you may found that building a Magic Square is simple. A Magic Square has only an odd number N of rows and columns where N < 100. A Magic Square is created by integer numbers in the range from 1 to N2 , with a peculiar property, the “sum of the numbers” in each row, column and diagonal are the same.

For the case n = 3,
M. Square          Rows               Columns         Diagonals
4 9 2              4+9+2 = 15     4+3+8 = 15      2+5+8 = 15
3 5 7              3+5+7 = 15     9+5+1 = 15      4+5+6 = 15
8 1 6              8+1+6 = 15     2+7+6 = 15 
Input
        Each line contains an Integer N denoting an N * N Magic Square.
Output
       如果 N 是偶數則輸出 ”It is not an odd number. ”。 如果 N 是奇數則先輸出直橫列的加總數字，再輸出 N * N 數字陣列,每個數字以%5d 格 式輸出。每組測資間請空一行。
  */
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int line = 0;
        while (in.hasNext()){
            if(line > 0) System.out.println();
            line++;
            int n = in.nextInt();
            if(n % 2 == 0){
                System.out.println("It is not an odd number.");
            }else {
                int[][] mq = new int[n][n];
                int row = n - 1, col = n / 2, total = 0;
                mq[row][col] = 1;

                for (int i = 2; i <= n * n; i++) {
                    row++;
                    col++;
                    if (row == n) row = 0;
                    if (col == n) col = 0;
                    if (mq[row][col] == 0) mq[row][col] = i;
                    else {
                        row = (row - 2 + n) % n;
                        col = (col - 1 + n) % n;
                        mq[row][col] = i;
                    }
                }
                for(int i = 0; i < n; i++) total += mq[0][i];
                System.out.println(total);
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        System.out.printf("%5d", mq[i][j]);
                    }
                    System.out.println();
                }
            }

        }
    }
}
