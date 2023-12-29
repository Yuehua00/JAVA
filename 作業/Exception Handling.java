/*
public static String Dec2Hex (int dec) 以及
public static int hex2Dec(String hexString) 方法
注意當進入 Hex2Dec 的字串非十六進位字元時
要編譯 MyNumberFormatException
class MyNumberFormatException extends Exception {}

主程式：
try {
int num = hex2Dec(String hexString);
}
catch (MyNumberFormatException ex) {
System.out.println(ex.getwrongmessage());
}

錯誤判斷
public hex2Dec(String str)
throws MyNumberFormatException {
if(字元不符合16進位)
throw new MyNumberFormatException(....);
}


input
先輸入十進位數字
再輸入兩組16進為字串
Output
利用Dec2Hex輸出轉換後的十六進位數字
剩餘兩組字串利用Hex2Dec輸出轉換後的十進位數字，
若輸入的字串非16進位字元，
請在MyNumberFormatException中輸出"String is no HEX"

Input
2596
ABC
G

25
AGGF
5A

Output
A24
2748
String is no HEX

19
String is no HEX
*/
import java.math.BigInteger;
import java.util.*;

class MyNumberFormatException extends Exception {
    private final String wrong;
    public MyNumberFormatException(String msg){
        this.wrong = msg;
    }
    public String getwrongmessage(){
        return wrong;
    }
}

public class Main {
    public static String Dec2Hex (int dec){
        return Integer.toHexString(dec).toUpperCase();
    }

    public static int hex2Dec(String hexString) throws MyNumberFormatException{
        int decimalvalue = 0;
        for(int i = 0; i < hexString.length(); i++){
            char c = hexString.charAt(i);
            if(!Character.isDigit(c) && (c < 'A' || c > 'F')){
                throw new MyNumberFormatException("String is no HEX");
            }
            else if(!Character.isDigit(c)){
                decimalvalue = decimalvalue * 16 + c - 'A' + 10;
            }else{
                decimalvalue = decimalvalue * 16 + c - '0';
            }
        }
        return decimalvalue;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int cnt = 1;
        try {
            while (in.hasNext()) {
                if(cnt == 1){
                    int n = in.nextInt();
                    String line = in.nextLine();
                    String ans = Dec2Hex(n);
                    cnt++;
                    System.out.println(ans);
                }else{
                    String hexString = in.nextLine();
                    int num = hex2Dec(hexString);
                    System.out.println(num);
                }
            }
        }
        catch (MyNumberFormatException ex) {
            System.out.println(ex.getwrongmessage());
        }
    }
}
