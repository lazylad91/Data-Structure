import java.io.*;
import java.util.Scanner;

public class CodingQuestion {
    
    /**
     *  5 3     0 0 0 0 0
        1 2 100 100 100 0 0 0 
        2 5 100 100 200 100 100 100
        3 4 100 100 200 200 200 100
    
**/


    public static void main(String args[]){
        System.out.println("hello");
    Scanner scanner = new Scanner(System.in);
        String inputLine = scanner.nextLine();
        String[] inputarr = inputLine.split("\\s+");
        int n = Integer.parseInt(inputarr[0]);
        int m = Integer.parseInt(inputarr[1]);
/*    int m = 3; // no of test cases
    int n = 5; // no of elements in list*/
    int[] listArr = new int[n];
    int maxValue = 0;
    // Initializing array
    for(int i=0; i<n;i++){
        listArr[i]=0; 
    }
    for(int i=0; i<m; i++){
         String inputLine2 = scanner.nextLine();
        String[] inputarr2 = inputLine2.split("\\s+");
        int a = Integer.parseInt(inputarr2[0])-1;
        int b = Integer.parseInt(inputarr2[1])-1;
        int k = Integer.parseInt(inputarr2[2]);
       System.out.println(a +" " + b + " " + k);
       if(b<=k){
         while(a<=b){
           listArr[a]+=k;
           if(listArr[a]>maxValue)
                maxValue=listArr[a];
            a++;
         }
       }
      }
      System.out.println("answer is"+ maxValue);
    }
}

/*    4 3
2 3 603 
1 1 286
4 4 882 */