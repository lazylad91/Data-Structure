public class Parentheses
{
    public static int balancedParentheses(String str){
        char[] charArray = str.toCharArray();
        int leftCount = 0;
        int rightCount = 0;
        for(char c : charArray){
            if(c=='(')
            leftCount++;
            else
            rightCount++;
            if(rightCount>leftCount)
            return -1;
        }
        if(rightCount!=leftCount)
        return -1
        return leftCount;
    }
}

 