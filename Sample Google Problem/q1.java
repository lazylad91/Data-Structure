import java.util.*;
import java.io.*;

public class q1 {
	public static void main(String args[]) {
		System.out.println("Enter no:: ");
		Scanner sc = new Scanner(System.in);
		int st = sc.nextInt();
		System.out.println();
		int result = findSmallest(st);
		System.out.println("========================");
		System.out.println("The answer is: " + result);
	}

	public static int findSmallest(int arg1) {
		String arg = String.valueOf(arg1);
		// base condition - if input string is null
		if (arg == null || arg.length() == 0 || arg.length() == 1)
			return 0;

		int n = arg.length();
		int min = 0;
		int i = 0;
		while (i + 1 < n) {
			ArrayList<Integer> list = new ArrayList<>();
			//before comparison-copy numbers
			if (i > 0) {
				for (int k = 0; k < i; k++) {
					list.add(Character.getNumericValue(arg.charAt(k)));
				} 
			}

			// comparison part
			if (Character.getNumericValue(arg.charAt(i)) > Character.getNumericValue(arg.charAt(i + 1))) {
				list.add(Character.getNumericValue(arg.charAt(i)));
			} else {
				list.add(Character.getNumericValue(arg.charAt(i + 1)));
			}

			// after comparison, add remaining number to the list.
			for (int j = i + 2; j < n; j++) {
				list.add(Character.getNumericValue(arg.charAt(j)));
			}

			// convert list to the integer.
			StringBuilder strbul = new StringBuilder();
			Iterator<Integer> iter = list.iterator();
			while (iter.hasNext()) {
				strbul.append(iter.next());
			}
			int number = Integer.parseInt(strbul.toString());
			System.out.println(number);

			// min stores the smallest number of all iterations
			min =(min==0?number:Math.min(min, number));
			i++;
		}
		return min;
	}
}