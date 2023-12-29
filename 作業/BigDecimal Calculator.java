/*
Problem
        Write a program to input an expression string in which the operands and operators are separated by zero or more spaces. For example, 3.5*4+3 and 3.5 + 4 % 3 are acceptable expressions. The operator in the expression might be +, -, *, /, and %. Your program must print out the expression and its computing result. The sample output for the input expression 3.5*4+3 is shown below: 
3.5 * 4 + 3 = 17 
Requirement
        Write a static method BigDecimal calculate(String exp) to compute the expression and return a BigDecimal result. The operands should be stored as BigDecimal in this method. You have to use the arithmetic operators provided by the BigDecimal class to calculate the expression. (未依規定，以 0 分計)

Input 
        There are many input lines. Each line has an input expression Exp. There are three operands and two operators in Exp.

Output
        For each input expression Exp, please output the expression and its computing result. Note that all tokens are separated by a space character. (小數點以下印一位)
  */
import java.math.RoundingMode;
import java.util.*;
import java.math.BigDecimal;
import java.lang.String;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String input = in.nextLine();
            StringTokenizer tokenizer = new StringTokenizer(input, "+-*/%", true);

            List<BigDecimal> numbers = new ArrayList<>();
            String[] op = new String[100];
            int[] have = new int[100];

            BigDecimal total = BigDecimal.ZERO.multiply(BigDecimal.valueOf(1.0));
            int opcnt = 0;
            while(tokenizer.hasMoreTokens()){
                String token = tokenizer.nextToken().trim();
                if(!token.isEmpty()){
                    if(isOperator(token)){
                        op[opcnt] = token;
                        opcnt++;
                    }else{
                        BigDecimal num = new BigDecimal(token);
                        numbers.add(num);
                    }
                }
            }
            int zero = 0, zeroc = 0;
            if(numbers.size() == 1){
                total = numbers.get(0);
                if(opcnt == 1 && op[0].equals("-")) total = total.multiply(BigDecimal.valueOf(-1));
                total = total.setScale(1, RoundingMode.HALF_UP);
                System.out.println(total);
            }else{
                int check = 0, rem = 0;
                BigDecimal remember = BigDecimal.ZERO, out;
                for(int i = 0; i < numbers.size(); i++){
                    out = numbers.get(i);
                    System.out.print(out + " ");
                    if(i < opcnt){
                        System.out.print(op[i] + " ");

                        BigDecimal next = BigDecimal.ZERO;
                        if(check == 0){

                            if(op[i].equals("-")){
                                next = numbers.get(i + 1).multiply(BigDecimal.valueOf(-1));
                                check = 1;
                                have[i + 1] = 1;
                                total = total.add(next);
                            }
                            else if(op[i].equals("*")){
                                next = numbers.get(i).multiply(numbers.get(i + 1));
                                check = 1;
                                have[i] = 1;
                                have[i + 1] = 1;
                                total = total.add(next);
                            }
                            else if(op[i].equals("/")){
                                next = numbers.get(i).divide(numbers.get(i + 1));
                                check = 1;
                                have[i] = 1;
                                have[i + 1] = 1;
                                total = total.add(next);
                            }
                            else if(op[i].equals("%")){
                                next = numbers.get(i).remainder(numbers.get(i + 1));
                                check = 1;
                                have[i] = 1;
                                have[i + 1] = 1;
                                total = total.add(next);

                            }

                        }else {
                            BigDecimal b = BigDecimal.ZERO;
                            if(have[i] == 0){
                                b = numbers.get(i);
                            }else{
                                b = numbers.get(i+1);
                            }

                            if(op[i].equals("-")) {
                                next = b.multiply(BigDecimal.valueOf(-1));
                                have[i+1] = 1;
                            }
                            else if(op[i].equals("*")) {
                                next = remember.multiply(b);
                                have[i + 1] = 1;
                                total = total.subtract(remember);
                            }
                            else if(op[i].equals("/")) {
                                next = remember.divide(b);
                                have[i + 1] = 1;
                                total = total.subtract(remember);
                            }
                            else if(op[i].equals("%")) {
                                next = remember.remainder(b);
                                have[i + 1] = 1;
                                total = total.subtract(remember);
                            }

                            total = total.add(next);
                            check = 0;
                        }
                        remember =next;
                    }

                }
                for(int i = 0; i < numbers.size(); i++){
                    if(have[i] == 0) total = total.add(numbers.get(i));
                    else if (have[i] == 2) {
                        total = total.subtract(numbers.get(i));
                    }
                }

                total = total.setScale(1, RoundingMode.HALF_UP);
                System.out.println("= " + total);

            }
        }
    }
    private static boolean isOperator(String token){
        return "+-*/%".contains(token);
    }
}
