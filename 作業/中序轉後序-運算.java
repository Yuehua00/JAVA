/*
輸入
  每組測資會給予不一定長度的算式，符號包含+,-,*,/,(,),%。
  程式要求 (未依規定以0分記)
    1. Write a Class XXXX (name it yourself) (which is not the Main class)  for computing the input expression.
    2. Class XXXX must include the following three static methods
        ​​String[] AAAA(String s) which returns an array of string tokens for the input expession s.
        String[] BBBB(String s) which returns an array of string tokens (Postfixe Expression) for the input expression s. Note that BBBB() can call AAAA().
        BigDecimal CCCC(String s) which returns the computing result of input expresdion s. Note that CCCC() can call AAAA() and BBBB().
        Please give a meaningful name for AAAA, BBBB, and CCCC.
輸出
  輸出算式的答案(BigDecimal)。
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
                        stack.push(a.divide(b));
                        break;
                    case "%":
                        stack.push(a.remainder(b));
                        break;
                }
            } else {
                stack.push(new BigDecimal(token));
            }
        }

        return stack.pop();
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String input = in.nextLine();
            BigDecimal result = ExpressionEvaluator.evaluateExpression(input);
            result = result.setScale(2, RoundingMode.HALF_UP);
            System.out.println(result);
        }
    }
}
