/*
Problem
  要求你輸入一個運算式字串S，請先將字串S分割成多個tokens，先將所有運算元(operand) tokes依序輸出，
  再輸出運算符號(operator) token，最後輸出計算結果，運算符號有+、-、*及/。
Input
  本題輸入有多筆測資，每筆測資會輸入一個運算式字串，token之間以空白字元分開，每個運算式會有3個運算元及2個運算符號。
Output
  先輸出運算式中之運算元(operand)  token，再輸出運算符號(operator)  token，輸出token之間以空白字元分開，
  最後輸出計算結果，小數點以下印兩位，正數請印出正號(+)。每筆測資輸出間，以空白行分開。

Sample Input
3 + 2 / 8
2 * 5 + 20
2 -20 / 5

Sample Output
3 2 8 + /
+3.252 
  
5 20 * +
+30.00
  
2 20 5 -/
-2.00
*/

import java.math.RoundingMode;
import java.util.*;
import java.math.BigDecimal;

class ExpressionEvaluator {
    public static String[] tokenizeExpression(String s) {
        StringTokenizer tokenizer = new StringTokenizer(s, "+-*/%()", true);
        List<String> tokens = new ArrayList<>();
        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken().trim();
            if (!token.isEmpty()) {
                tokens.add(token);
            }
        }
        return tokens.toArray(new String[0]);
    }

    public static String[] infixToPostfix(String s) {
        String[] tokens = tokenizeExpression(s);
        Stack<String> op = new Stack<>();
        op.push("#");
        List<String> postfix = new ArrayList<>();

        for (String token : tokens) {
            switch (token) {
                case "(":
                    op.push("#");
                    break;
                case ")":
                    while (!op.peek().equals("#")) {
                        postfix.add(op.pop());
                    }
                    op.pop();
                    break;
                case "*":
                case "/":
                case "%":
                    while (!op.peek().equals("#")) {
                        if (op.peek().equals("*") || op.peek().equals("/") || op.peek().equals("%")) {
                            postfix.add(op.pop());
                        } else {
                            break;
                        }
                    }
                    op.push(token);
                    break;
                case "+":
                case "-":
                    while (!op.peek().equals("#")) {
                        postfix.add(op.pop());
                    }
                    op.push(token);
                    break;
                default:
                    postfix.add(token);
                    break;
            }
        }

        while (!op.peek().equals("#")) {
            postfix.add(op.pop());
        }

        return postfix.toArray(new String[0]);
    }

    public static BigDecimal evaluateExpression(String s) {
        String[] postfix = infixToPostfix(s);
        Stack<BigDecimal> stack = new Stack<>();

        for (String token : postfix) {
            if ("+-*/%".contains(token)) {
                BigDecimal b = stack.pop();
                BigDecimal a = stack.pop();
                switch (token) {
                    case "+":
                        stack.push(a.add(b));
                        break;
                    case "-":
                        stack.push(a.subtract(b));
                        break;
                    case "*":
                        stack.push(a.multiply(b));
                        break;
                    case "/":
                        stack.push(a.divide(b, 20, RoundingMode.HALF_UP));
                        //stack.push(a.divide(b));
                        break;
                    case "%":
                        stack.push(a.remainder(b));
                        break;
                }
            } else {
                stack.push(new BigDecimal(token));
                System.out.print(token + " ");
            }
        }

        return stack.pop();
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int line = 0;
        while (in.hasNext()) {
            if(line != 0) System.out.println();
            line++;
            String input = in.nextLine();
            BigDecimal result = ExpressionEvaluator.evaluateExpression(input);
            result = result.setScale(2, RoundingMode.HALF_UP);
            StringTokenizer tokenizer = new StringTokenizer(input, "+*-/%", true);
            int blank = 0;
            while (tokenizer.hasMoreTokens()){

                String token = tokenizer.nextToken();
                if(isOperator(token)) {
                    if(blank != 0) System.out.print(" ");
                    blank++;
                    System.out.print(token);
                }
            }
            System.out.println();
            if(result.compareTo(BigDecimal.ZERO) > 0) System.out.println("+" + result);
            else System.out.println(result);
        }
    }
    private static boolean isOperator(String token){
        return "+*/-%".contains(token);
    }
}
