/*
Description
A Latin square is an n-by-n array filled with n different Latin letters, each occurring exactly once in each row and once in each column.
Write a program that prompts the user to enter the number n and the array of characters, as shown in the sample output, and checks if the input array is a Latin square. The characters are the first n characters starting from A.
 
Input
Enter number n, and enter n rows of letters separated by spaces.
0 < n <= 26, all the letters in square are A ~ Z.
Input is terminated by a set where n = -1. This set should not be processed.
 
Output
Recognize if it is Latin Square or not. There are 2 different kinds of your answers:
The input array is a Latin square
The input array is not a Latin square
Overall, just check if it is Latin square or not.

  4↵
A B C D↵ The input array is a Latin square↵
B A D C↵
C D B A↵
D C A B↵
↵
3↵
B C A↵ The input array is not a Latin square
B A C↵
C B A↵
↵
3↵
B A C↵  The input array is a Latin square↵
A C B↵
C B A↵
↵
4↵
D C B A↵  The input array is not a Latin square
J A V A↵
U C C U↵
P P A P↵
↵
-1↵
  */
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int line = 0;
        while (in.hasNext()) {
            int n = in.nextInt();
            int not = 0, cnt = 0;
            int[] eng = new int[26+5];
            if(n == -1){
                break;
            }else{

                char[][] arr = new char[n][n];
                boolean noinput = false;
                for(int i = 0; i < n; i++){
                    for(int j = 0; j < n; j++){
                        if(!in.hasNext()){
                            noinput = true;
                            break;
                        }
                        char thiseng = in.next().charAt(0);
                        arr[i][j] = thiseng;
                        if(eng[thiseng - 'A'] == 0){
                            eng[thiseng - 'A']++;
                            cnt++;
                        }
                    }
                    if(noinput) break;
                }
                if(!noinput){
                    for(int i = 0; i < n; i++){
                        for(int j = 0; j < n; j++){
                            for(int k = 0; k < n; k++){
                                if(arr[i][j] == arr[i][k] && j != k){
                                    not = 1;
                                    break;
                                }
                                if(arr[i][j] == arr[k][j] && i != k){
                                    not = 1;
                                    break;
                                }
                            }
                            if(not == 1) break;
                        }
                        if(not == 1) break;
                    }
                }

                if(not == 1 || cnt > n || noinput) System.out.println("The input array is not a Latin square.");
                else System.out.println("The input array is a Latin square.");

            }
        }
    }
}
