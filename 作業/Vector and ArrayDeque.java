/*
Problem
  題目內容為給你一組數字，以Vector<Integer>  vector儲存，先升序sort之後，依序以特定方式儲存到ArrayDeque<Integer>  array，
  方式為假設vector的數字為偶數，則加到array的尾端，假設vector的數字為奇數，則加到array的前端，
  且在每組測資結束後以removeFirst()的方式清空ArrayDeque。
Input
  輸入有多筆測資，每行代表一組測資，
  每組測資會輸入一段數字(數字的大小為>0，< 2,147,483,647)，數字的數目不一定，輸入0為一組測資的結束。
Output
  依照ArrayDeque array儲存的順序依序輸出，輸出的值之間請以一個空格分開。

Input
10 1 4 8 5 2 9 7 6 3 0
100 200 300 25 69 85 71 63 22 62 585 25 63 15 15 36 14 36 85 92 62 22 2 1 0
  
Output
9 7 5 3 1 2 4 6 8 10
585 85 85 71 69 63 63 25 25 15 15 1 2 14 22 22 36 36 62 62 92 100 200 300
*/
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Vector<Integer> vector = new Vector<>();
        int n = 0;
        while (in.hasNext()){
            n = in.nextInt();

            if(n == 0){
                Collections.sort(vector);
                ArrayDeque<Integer> array = new ArrayDeque<>(vector.size());
                for(int i = 0; i < vector.size(); i++){
                    if(vector.get(i) % 2 == 1){
                        array.addFirst(vector.get(i));
                    }else{
                        array.addLast(vector.get(i));
                    }
                }
                int blank = 0;
                for (int i : array) {
                    if (blank != 0){
                        System.out.print(" ");
                    }
                    blank++;
                    System.out.print(i);
                }
                System.out.println();
                vector.clear();
                array.clear();
            }else{
                vector.add(n);
            }
        }
    }
}
