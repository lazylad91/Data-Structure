/*You are given an integer X. You must choose two adjacent digits and replace them with the larger of these two digits.

For example, from the integer X = 233614, you can obtain:
33614 (by replacing 23 with 3);
23614 (by replacing 33 with 3 or 36 with 6);
23364 (by replacing 61 with 6 or 14 with 4);

You want to find the smallest number that can be obtained from X by replacing two adjacent digits with the larger of the two. In the above example, the smallest such number is 23364.

Write a function:

class Solution {public int solution (int X);}
that, given a positive integer X, returns the smallest number that can be obtained from X by replacing two adjacent digits with the larger of the two.

For example, given X = 233614, the function should return 23364, as explained above.

Assume that:

X is an integer within the range [10..1,000,000,000].
In your solution, focus on correctness. The performance of your solution will not be the focus of the assessment.*/

import java.util.*;
import java.io.*;

public class FindMinimum {
    
    public static void main(String args[]){
  
        System.out.println("Enter no:: ");
		Scanner sc = new Scanner(System.in);
		int st = sc.nextInt();
		System.out.println();
		int result = findMinimum(st);
		System.out.println("========================");
		System.out.println("The answer is: " + result);
    }
    
    public static int findMinimum(int n){
        int low=0,mid=0,high=0;
        String ns = String.valueOf(n);
        int len = ns.length();
        int i=0;
        while(i<len-2){
            if((ns.charAt(i)>=ns.charAt(i+1)) && (ns.charAt(i+1) > ns.charAt(i+2))){
                low=i;
                mid=i+1;
                high=i+2;
                break;
            }
            i++;
        }
        StringBuilder sb = new StringBuilder(ns);
        if(low!=mid){
            sb.deleteCharAt(mid);
        }
        else{
            if(ns.charAt(len-2)>ns.charAt(len-1)){
                sb.deleteCharAt(len-1);
            }
            else{
                sb.deleteCharAt(len-2);
            }
        }
        
        return Integer.parseInt(sb.toString());
    }
}