/*
請撰寫一程式，使用者輸入二個字串，然後顯示二個字串是否為第一個字串的子字串。 
輸入 string s1:ABCD string s2:BC 
輸出 BC is a substring of ABCD


輸入 string s1:ABCD string s2:CA
輸出 CA is not a substring of ABCD
---------------------------------------------------------------------
1.
abcdefgh cd  ->  cd is a substring of abcdefgh
2.
QWERTYUIOP PO  ->  PO is not a substring of QWERTYUIOP
---------------------------------------------------------------------
*/
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        String[] token = input.split(" ");              //因為這題以一個空格分割兩字串，所以這裡用split分割，存到token
        String s1 = token[0], s2 = token[1];

        if(s1.contains(s2)){
            System.out.println(s2 + " is a substring of " + s1);
        }else{
            System.out.println(s2 + " is not a substring of " + s1);
        }

    }
}
