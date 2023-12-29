/*
Problem
  請定義一個整數座標點(Point)類別，此Point類別可實作Comparable介面，兩點P1與P2之比較原則如下：
    P1 < P2   if P1到原點(0,0)的距離（distance）< P2到原點的距離
    如P1與P2到原點的距離相等
      P1 < P2   if P1之X座標＜P2之X座標
      如P1與P2之X座標相等，P1 < P2if P1之Y座標＜P2之Y座標
  Hint: 如Point無實作Comparable介面，可實作Comparator 物件，排序時可以使用。
Input
  本題會有多筆測資，每筆測資先輸入數字N，代表有N個座標點，接著輸入N行資料，每行有兩整數分別代表X座標與Ｙ座標。
Output
  輸出上述(x,  y)由小到大的排序，以及x+y相加最大的值與點位
  ex:  max  num:  19518 point(9829,9689)，每組輸出以空白行隔開。(詳細請見Sample Output)

Sample Input
3
1 3
6 2
2 6
6
5 6
1 2
4 3
2 3
6 5
3 4

Sample Output
(1,3)
(2,6)
(6,2)
max num: 8
point: (6,2)
  
(1,2)
(2,3)
(3,4)
(4,3)
(5,6)
(6,5)
max num: 11
point: (6,5)
*/
import java.awt.geom.Point2D;
import java.util.*;
import java.lang.Object;
import java.util.Comparator;

class Point implements Comparator<Point> {
    private int a, b;
    void setPoint(int a, int b){
        this.a = a;
        this.b = b;
    }
    public int getA(){
        return this.a;
    }
    public int getB(){
        return this.b;
    }
    public double getDis(){
        return Math.pow((this.getA()), 2) + Math.pow(this.getB(), 2);
    }
    public int compare(Point p1, Point p2) {
        double dis1 = p1.getDis();
        double dis2 = p2.getDis();

        if (dis1 < dis2) {
            return -1;
        } else if (dis1 > dis2) {
            return 1;
        } else {
            if (p1.getA() < p2.getA()) {
                return -1;
            } else if (p1.getA() > p2.getA()) {
                return 1;
            } else {
                return Integer.compare(p1.getB(), p2.getB());
            }
        }
    }
    public String toString(){
        return ("(" + this.getA() + "," + this.getB() + ")");
    }

}

public class Main {
    public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            int cnt = -1;
            while (in.hasNext()) {
                if(cnt != -1) System.out.println();
                cnt++;
                int n = in.nextInt();

                Point maxP = new Point();
                int max = 0;
                Point[] arr = new Point[n];
                for(int i = 0; i < n; i++){
                    int a = in.nextInt(), b = in.nextInt();
                    Point temp = new Point();
                    temp.setPoint(a, b);
                    arr[i] = temp;

                }
                Arrays.sort(arr, new Point());
                Point now = new Point();
                for(int i = 0; i < n; i++){

                    //System.out.println("(" + now.getA() + ", " + now.getB() + ")");
                    System.out.println(arr[i]);
                    max = arr[i].getA() + arr[i].getB();
                    maxP = arr[i];
                }

                System.out.println("max num: " + max);
                System.out.println("point:" + maxP);

        }

    }
}
