/*
作業三 - Area of Convex Polygon
成績: 0 / 倒扣: 0.8
Problem Description
      A polygon is convex if it contains any line segments that connects two points of the polygon.
      Write a program that prompts the user to enter the number of points in a convex polygon,enter the points clockwise, then display the area of the polygon.

      Hint: The area of a convex polygon with N points can be computed using the areas of N − 2
      triangles.
Input Format
      There are many test cases. Each test case has two lines. The first line has an integer N indicating that the convex polygon has N points. The second line has 2N double values, where 
      each point corresponds two values x coordinate and y coordinates.
      
Output Format
    Print out the area of convex polygon for each test case. There is a new line between two test cases.
Requirement
    1.  Define a Triangle Class cosisting of 3 points (Point or Point2D) and provide a method to compute its area.
    2. Define a ConvexPolygon Class consiting all points and provide a method compute its area.

------------------------------------------------------------------
Input :
  3
  0 3 4 0 0 0
  7
  -12 0 -8.5 10 0 11.4 5.5 7.8 6 -5.5 0 -7 -3.5 -13.5
Output :
  6.000

  292.575
-------------------------------------------------------------------
*/
import java.util.*;
import java.awt.geom.Point2D;

class Triangle{
    Point2D p1, p2, p3;
    public Triangle(Point2D a, Point2D b, Point2D c){
        this.p1 = a;
        this.p2 = b;
        this.p3 = c;
    }
    public double comArea(){     //海龍公式
        double l12 = Math.sqrt(Math.pow((p1.getX() - p2.getX()), 2) + Math.pow((p1.getY() - p2.getY()), 2));
        double l23 = Math.sqrt(Math.pow((p3.getX() - p2.getX()), 2) + Math.pow((p3.getY() - p2.getY()), 2));
        double l13 = Math.sqrt(Math.pow((p1.getX() - p3.getX()), 2) + Math.pow((p1.getY() - p3.getY()), 2));
        double s = (l12 + l13 + l23)/2;
        return Math.sqrt(s * (s-l12) * (s-l23) * (s-l13));
    }
}
class ConvexPolygon{
    Point2D[] arr;
    public ConvexPolygon(Point2D[] point){
        this.arr = point;
    }
    public double comArea(){
        double area = 0;
        for(int i = 1; i < arr.length - 1; i++){
            Triangle tri = new Triangle(arr[0], arr[i], arr[i+1]);
            area += tri.comArea();
        }
        return area;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int line = 0;
        while(in.hasNext()){
            if(line > 0) System.out.println();
            line++;
            int n = in.nextInt();
            Point2D[] arr = new Point2D[n];
            for (int i = 0; i < n; i++) {
                double x = in.nextDouble();
                double y = in.nextDouble();
                arr[i] = new Point2D.Double(x, y);
            }
            ConvexPolygon conP = new ConvexPolygon(arr);
            System.out.printf("%.3f\n", conP.comArea());

        }
    }
}
