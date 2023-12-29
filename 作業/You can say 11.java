/*
給你一個正整數 N，判定它是否是 11 的倍數。提示: 在這裡，我們需要用到一個關於 11 倍
數的小常識，那就是：11 倍數的「奇數位數字和」與「偶數位數字和」兩者的差必定為 11 的
倍數。
Input Format
每列資料有一個正整數 N，N 最大可能到 1000 位數。若 N = 0 代表輸入結束
Output Format
先輸出奇數的和與偶數位的和，再對每一個輸入的數，輸出是否為 11 的倍數。輸出格式請
參考 Sample Output
Technical Specification
注意！本題必須使用 char[] or String 儲存數入之正整數。
  */
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int odd = 0, even = 0;
            //Scanner scanner = new Scanner(System.in);
            String input = in.nextLine();

            for(int j = input.length()-1; j >= 0; j--){
                if(j % 2 == 0){
                    odd += input.charAt(j) - 48;
                }else{
                    even += input.charAt(j) - 48;
                }
            }
            if(input.length() % 2 == 0){
                int tmp = odd;
                odd = even;
                even = tmp;
            }
            System.out.println(odd + " " + even);
            if(Math.abs(odd - even) % 11 == 0){
                System.out.println(input + " is a multiple of 11.");
            }else{
                System.out.println(input + " is not a multiple of 11.");
            }
        }


    }

}
