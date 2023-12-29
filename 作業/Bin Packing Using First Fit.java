/*
Problem
  The bin packing problem is to pack the objects of various weights into containers. 
  Assume each container can hold a maximum of npounds. 
  The program uses an algorithm that places an object into the first bin in which it would fit. 
  Your program should prompt the user to enter the number n, the number of objects m, 
  and the weight of each object. The program displays the total number  of  containers  needed  to  
  pack  the  objects  and  the  contents  of  each  container.  
  Here  is  a sample output of a test case inputting n= 10, m= 6, 
  and the weights of all objects 7 5 2 3 5 8. The output is shown below:
    4 
    Container 1 contains objects with weight 7 2
    Container 2 contains objects with weight 5 3
    Container 3 contains objects with weight 5
    Container 4 contains objects with weight 8
Input
  Each test case has two input lines. The first line contains two integer n and m. 
  The second line contains the weights of all objects. There are many test cases.
Output
  For each test case, the first line outputs the number (k) of bins needed to pack all objects 
  followed by k lines of output in which each line displays the content of each container. 
  There is a new line between two test cases.
*/
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int line = 0;
        while (in.hasNext()) {
            if(line != 0) System.out.println();
            line++;
            int n = in.nextInt(), m = in.nextInt();
            int[] arr = new int[m + 5];
            for (int i = 0; i < m; i++) {
                arr[i] = in.nextInt();
            }
            int cnt = 0;
            Vector<Vector<Integer>> v = new Vector<>();
            for (int i = 0; i < m; i++) {
                v.add(new Vector<>());
            }
            int[] tmp = new int[m];
            int cntans = 0;
            for(int i = 0; i < m; i++){
                for(int j = 0; j < m; j++) {
                    if (tmp[j] + arr[i] <= n) {
                        tmp[j] += arr[i];
                        v.get(j).add(arr[i]);
                        break;
                    }
                }
            }
            for(int i = 0; i < m; i++){
                if(tmp[i] != 0){
                    cntans++;
                }
            }
            System.out.println(cntans);
            for(int i = 0; i < m; i++){
                if(tmp[i] == 0) break;
                int out = i+1;
                System.out.print("Container " + out +" contains objects with weight");
                for(int j = 0; j < v.get(i).size(); j++){
                    System.out.print(" " + v.get(i).get(j));
                }
                System.out.println();
            }
        }
    }
}
