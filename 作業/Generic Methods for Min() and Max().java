/*
請設計一個程式，能夠利用
public static <E extends Comparable<E>> E min(ArrayList<E> list) 與
public static <E extends Comparable<E>> E max(ArrayList<E> list)
將輸入的值放入ArrayList，並利用上述的Method找出arrayList中最小與最大的元素。
Input:
  題目一開始會輸入資料型態，其後的arrayList請依照輸入的資料型態儲存。資料型態分為Integer、Double、Charactor、String。
  不論輸入的資料型態為何，其後輸入的arrayList物件都有10個。
Output
  請輸出ArrayList中最小與最大的元素(double請輸出至小數點第三位)

Input
Integer
25 10 60 25 9 1 2 75 3 25

Character
G B a C r q J H I k

Output
1
75

B
r
*/
import java.util.*;

public class Main{
    public static <E extends Comparable<E>> E min(ArrayList<E> list) {
        E min = list.get(0);
        for(E element : list){
            if(element.compareTo(min) < 0){
                min = element;
            }
        }
        return min;
    }
    public static <E extends Comparable<E>> E max(ArrayList<E> list){
        E max = list.get(0);
        for(E elememt : list){
           if(elememt.compareTo(max) > 0){
               max = elememt;
           }
        }
        return max;
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String type = in.next();

        if(type.equals("Integer")){
            ArrayList<Integer> arrayList = new ArrayList<>();
            for(int i = 0; i < 10; i++){
                arrayList.add(in.nextInt());
            }
            System.out.println(min(arrayList));
            System.out.println(max(arrayList));
        }else if(type.equals("Double")){
            ArrayList<Double> arrayList = new ArrayList<>();
            for(int i = 0; i < 10; i++){
                arrayList.add(in.nextDouble());
            }
            System.out.printf("%.3f\n",min(arrayList));
            System.out.printf("%.3f\n", max(arrayList));
        }else if(type.equals("Character")){
            ArrayList<Character> arrayList = new ArrayList<>();
            for(int i = 0; i < 10; i++){
                arrayList.add(in.next().charAt(0));
            }
            System.out.println(min(arrayList));
            System.out.println(max(arrayList));
        }else if(type.equals("String")){
            ArrayList<String> arrayList = new ArrayList<>();
            for(int i = 0; i < 10; i++){
                arrayList.add(in.next());
            }
            System.out.println(min(arrayList));
            System.out.println(max(arrayList));
        }

    }

}
