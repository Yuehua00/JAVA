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
