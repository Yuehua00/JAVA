/*
Problem
  A complex number is a number in the form a+ bi, where aand bare real numbers andiis  √−1. 
  The numbers aand bare known as the real part and imaginary part of the complex number, respectively.
  You  can  perform  addition,  subtraction,  multiplication,  and  division  for  complex numbers 
  using the following formula:
    a + bi + c + di = (a+c) + (b+d)i
    a + bi –(c + di)= (a-c) + (b-d)i
    (a + bi)*(c + di)= (ac-bd) + (bc+ad)i
    (a + bi)/(c + di)= (ac+bd)/(c2+d2) + (bc-ad)i/(c2+d2)
  You can also obtain the absolute value for a complex number using the following formula:
    |𝑎+𝑏𝑖|=√(𝑎^2+𝑏^2)
  Design  a  class  named Complexfor  representing  complex  numbers  and  the  methods add, 
  subtract, multiply, divide,  and abs for  performing  complex  number  operations,  
  and  override toStringmethod for returning a string representation for a complex number. 
  The toString method returns (a+ bi) as a string. If b is 0, it simply returns a. 
  Your Complexclass should also implement the Cloneableinterface.
  Provide  two  constructors Complex()andComplex(a,  b). Complex() creates  a  Complex object 
  for number 0and Complex(a, b)creates a Complex object with a + bi. 
Input
  There are many input lines. Each line is a test case and it has four double values 
  a, b, c, and dcorresponding two complex numbers a + bi and c + di. 
Output
  For each input case, please reference the following sample output case. 
  The output of each test case are separated new lines

Input
3.5 5.5 -3.5 1
1 2 1 -2
  
Output
(3.5 + 5.5i) + (-3.5 + 1.0i) = 6.5i
(3.5 + 5.5i) -(-3.5 + 1.0i) = 7.0 + 4.5i
(3.5 + 5.5i) * (-3.5 + 1.0i) = -17.75 + -15.75i
(3.5 + 5.5i) / (-3.5 + 1.0i) = -0.5094 + -1.7i
|3.5+5.5𝑖|=6.519202405202649↵↵(1 + 2i) + (1 –2i) = 2

(1 + 2i) -(1 –2i) = 4i
(1 + 2i) * (1 –2i) = 5
(1 + 2i) /(1 –2i) = -0.6 + 0.8i
|1+2𝑖|=2.2360679775499790
*/

import java.text.DecimalFormat;
import java.util.*;

class Complex implements Cloneable{
    private double real, imag;
    public Complex(){}
    public Complex(double a){
        this(a, 0);
    }
    public Complex(double a, double b){
        this.real = a;
        this.imag = b;
    }
    public double getReal(){
        return this.real;
    }
    public double getImag(){
        return this.imag;
    }
    public Complex add (Complex c){
        double r = real + c.getReal();
        double i = imag + c.getImag();
        return new Complex(r, i);
    }
    public Complex sub (Complex c){
        double r = real - c.getReal();
        double i = imag - c.getImag();
        return new Complex(r, i);
    }
    public Complex mul(Complex c){
        double r = real * c.getReal() - imag * c.getImag();
        double i = real * c.getImag() + imag * c.getReal();
        return new Complex(r, i);
    }
    public Complex div(Complex c){
        double down = c.getReal() * c.getReal() + c.getImag() * c.getImag();
        double r = (real * c.getReal() + imag * c.getImag()) / down;
        double i = (imag * c.getReal() - real * c.getImag()) / down;
        return new Complex(r, i);
    }
    public double abs(){
        return Math.sqrt(real * real + imag * imag);
    }
    public String anstoString(){
        DecimalFormat df = new DecimalFormat("0.0000"); // Format with 4 decimal places
        String formattedReal = df.format(real);
        String formattedImag = df.format(imag);

        if(imag == 0) return  formattedReal + "";
        else if(real == 0) return formattedImag + "i";
        else return formattedReal + " + " + formattedImag + "i";
    }
    public String toString(){
        DecimalFormat df = new DecimalFormat("0.0000"); // Format with 4 decimal places
        String formattedReal = df.format(real);
        String formattedImag = df.format(imag);
        return "(" + formattedReal + " + " + formattedImag + "i)";
    }
    public Object clone(){
        return new Complex(real, imag);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = 0;
        while (in.hasNext()) {
            if(n != 0) System.out.println();
            n++;
            double a = in.nextDouble();
            double b = in.nextDouble();
            Complex n1 = new Complex(a, b);
            a = in.nextDouble();
            b = in.nextDouble();
            Complex n2 = new Complex(a, b);
            Complex ans = n1.add(n2);
            System.out.println(n1.toString() + " + " + n2.toString() + " = " + ans.anstoString());
            ans = n1.sub(n2);
            System.out.println(n1.toString() + " - " + n2.toString() + " = " + ans.anstoString());
            ans = n1.mul(n2);
            System.out.println(n1.toString() + " * " + n2.toString() + " = " + ans.anstoString());
            ans = n1.div(n2);
            System.out.println(n1.toString() + " / " + n2.toString() + " = " + ans.anstoString());
            DecimalFormat df = new DecimalFormat("0.0000");
            double absn1 = n1.abs();
            String Absn1 = df.format(absn1);
            DecimalFormat df2 = new DecimalFormat("0.0000"); // Format with 4 decimal places
            String formattedReal = df2.format(n1.getReal());
            String formattedImag = df2.format(n1.getImag());
            System.out.println("|" + formattedReal + " + " + formattedImag + "i| = " + Absn1);

        }
    }
}
