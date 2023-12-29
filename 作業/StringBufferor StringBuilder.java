/*
Problem
  輸入一個字串，並將字串其中的片段取代，再將其反轉輸出。Note: 取代後的字串將不包含原始字串。
Input
  先輸入一個數字N，代表總共有多少組測試資料。每組測資都會有三行字串。先輸入一行原始字串，再輸入需要被取代的字串，
  最後輸入取代用的字串，所有字串均允許有空格輸入。
Output
  對每一組測試資料，請輸出最後取代完成字串的反轉字串。Note: 取代後的字串將不包含原始字串。

Input
3
BA122DC12FE
12
31
?era uoy ohW
era uoy↵uoy era
!gniog peek tsuJ
gniog peek
pu evig
  
Output
EF13CD133AB
Who are you?
Just give up!
*/
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();  

        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(in.nextLine());
            String s1 = in.nextLine();
            String s2 = in.nextLine();

            while (sb.indexOf(s1) != -1) {
                sb.replace(sb.indexOf(s1), sb.indexOf(s1) + s1.length(), s2);
            }

            sb.reverse();
            System.out.println(sb);
        }
    }
}
