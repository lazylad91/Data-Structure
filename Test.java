import java.util.Scanner;
public class Test {
    public static void main(String[] args) {
        int value = readParameter(args);
        Integer out = solve(value);
        print(out);
    }

    /** Reads arguments from command line **/
    private static int readParameter(String[] args) {
        int value = -1;
        try (Scanner in = new Scanner(System.in)) {
            value = in .nextInt();
        }
        return value;
    }

    /** Prints the result 1- if the binary representation is positive, else 0 **/
    private static void print(Integer result) {
        System.out.println(result);
    }

    /** Checks if the the binary representation is Palindrome **/
    private static Integer solve(int valueToFind) {
        Integer result = null;

        //convert the user input to its binary representation
        String binaryrepresentation = convertIntToBinary(valueToFind);
        System.out.println("binaryrepresentation " + binaryrepresentation);
        //checks if the binary representation is Palindrome
        boolean isPalindrome = checkPalindrome(binaryrepresentation);

        if (isPalindrome) result = 1;
        else result = 0;

        return result;
    }

    /**Checks if the the String representation of the binary number is Palindrome**/
    public static boolean checkPalindrome(String str) {
        int n = str.length();
        for (int i = 0; i < n / 2; i++)
            if (str.charAt(i) != str.charAt(n - i - 1)) return false;
        return true;
    }

    /**Converts the given number to its binary representation**/
    public static String convertIntToBinary(int n) {
        String s = "";
        while (n > 0) {
            s = ((n % 2) == 0 ? "0" : "1") + s;
            n = n / 2;
        }
        return s;
    }
}