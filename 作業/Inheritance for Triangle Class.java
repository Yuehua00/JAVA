/*
Input
請先輸入3個邊的線段長(double)
輸入顏色(String)
再輸入是否為填滿值(Boolean)
Output
依序輸出三角形的面積、周長、顏色及是否為填滿值

Input
1.0 1.5 1.0
yellow
true

Output
Triangle: side1 = 1.0 side2 = 1.5 side3 = 1.0
The area is 0.49607837082461076
The perimeter is 3.5
yellow
true
*/
import java.util.*;
abstract class GeometricObject{
    private String color;
    private Boolean F;
    public GeometricObject(){
        this.color = "White";
        this.F = false;
    }
    protected GeometricObject(String color, Boolean f){
        this.color = color;
        this.F = f;
    }
    public void setColor(String str){
        this.color = str;
    }
    public String getColor(){
        return color;
    }
    public void filed(Boolean f){
        this.F = f;
    }
    public Boolean getF(){
        return F;
    }
    public abstract double area();
    public abstract double perimeter();

}
class Traingle extends GeometricObject{
    protected double a, b, c;
    public Traingle(double a, double b, double c){
        this.a = a;
        this.b = b;
        this.c = c;
    }
    public double area(){
        double s = (a + b + c) / 2.0;
        return Math.sqrt(s * (s-a) * (s-b) * (s-c));
    }
    public double perimeter(){
        return a + b + c;
    }
}
public class Main{

    public static void main(String[] args){
        
        Scanner in = new Scanner(System.in);
        
        double a = in.nextDouble();
        double b = in.nextDouble();
        double c = in.nextDouble();
        String color = in.next();
        Boolean F = in.nextBoolean();

        Traingle triangle = new Traingle(a, b, c);
        triangle.setColor(color);
        triangle.filed(F);
        
        System.out.println("Triangle: side1 = " + triangle.a + " side2 = " + triangle.b + " side3 = " + triangle.c);
        System.out.println("The area is " + triangle.area());
        System.out.println("The perimeter is " + triangle.perimeter());
        System.out.println(triangle.getColor());
        System.out.println(triangle.getF());
    }
}
