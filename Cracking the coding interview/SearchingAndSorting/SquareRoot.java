public class Solution {  
    public int mySqrt(int x) {
        long low = 0;
        long high = x;
        long mid = 0;
        // We Need this as we want to save the floor value
        long ans = 0;
        long num = (long)x;
        if (0 == x || 1 == x ) return x;
        while(low <= high){   
            
         mid = low + (high-low)/2;
           //System.out.println(mid);
            if(mid*mid == num){
                return (int)mid;
            }
            else if(mid*mid < num ){
               // System.out.println("i am in this");
               // We need to save the last mid value whose square is less then number
               // as if mid is 3 and num = 10 - this loop will execute as low = 3 and high =4
               // after this low will be updated ie low = 4 and high = 4 for this mid = 4
               // Now we will go to next to condition as 16 > 10 and then high = 3 and low = 4
               // Which means end of while loop and mid = 4 which doesnt make sense
                ans = mid;
                low = mid+1;
            }
            else{
               //System.out.println("low is"+low);
               //System.out.println("high is"+high);
                high = mid-1;
            }
        }
        
        return (int)ans;
    }
}