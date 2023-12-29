/*
Input
  先輸入數字N，代表總共有多少組測試資料，每組測試資料會依序輸入三個座標點(皆為double)，分別為x1,y1, x2,y2, x3,y3。
Output
  請判斷三個座標點是否可以形成三角形，若可以則由小到大輸出三角形其三條邊長(到小數點第三位)，再輸出其面積(到小數點第三位)。若不行，則輸出”Just Line!”

Input
2
0 0 0 3 4 0
1 1 2 2 3 3
  
Output
3.000 4.000 5.000 6.000
Just Line!
*/
import java.awt.geom.Point2D;
import java.util.Scanner;

class Triangle {
    private Point2D.Double point1;
    private Point2D.Double point2;
    private Point2D.Double point3;

    public Triangle(Point2D.Double point1, Point2D.Double point2, Point2D.Double point3) {
        this.point1 = point1;
        this.point2 = point2;
        this.point3 = point3;
    }

    private double distance(Point2D.Double p1, Point2D.Double p2) {
        return Math.sqrt(Math.pow(p1.getX() - p2.getX(), 2) + Math.pow(p1.getY() - p2.getY(), 2));
    }

    public boolean isTriangle() {
        double side1 = distance(point1, point2);
        double side2 = distance(point2, point3);
        double side3 = distance(point3, point1);

        return (side1 + side2 > side3) && (side2 + side3 > side1) && (side3 + side1 > side2);
    }

    public void printInfo() {
        if (isTriangle()) {
            double[] sides = {distance(point1, point2), distance(point2, point3), distance(point3, point1)};
            java.util.Arrays.sort(sides);

            System.out.printf("%.3f %.3f %.3f ", sides[0], sides[1], sides[2]);

            double s = (sides[0] + sides[1] + sides[2]) / 2.0;
            double area = Math.sqrt(s * (s - sides[0]) * (s - sides[1]) * (s - sides[2]));

            System.out.printf("%.3f\n", area);
        } else {
            System.out.println("Just Line!");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        for (int i = 0; i < N; i++) {
            double x1 = scanner.nextDouble();
            double y1 = scanner.nextDouble();
            double x2 = scanner.nextDouble();
            double y2 = scanner.nextDouble();
            double x3 = scanner.nextDouble();
            double y3 = scanner.nextDouble();

            Point2D.Double point1 = new Point2D.Double(x1, y1);
            Point2D.Double point2 = new Point2D.Double(x2, y2);
            Point2D.Double point3 = new Point2D.Double(x3, y3);

            Triangle triangle = new Triangle(point1, point2, point3);
            triangle.printInfo();
        }
    }
}
