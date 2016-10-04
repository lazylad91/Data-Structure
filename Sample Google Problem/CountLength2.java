import java.util.Stack;
 
public class CountLength2 {
    public class Files {
        public Files(String file, int i, int j) {
            this.fileName = file;
            this.length = i;
            this.noOfSpaces = j;
        }
        String fileName;
        int length;
        int noOfSpaces;
    }
    Stack<Files> files = new Stack<Files>();
     
    public void solution(String S) {
        int sum = 0;
        String[] splitStr = S.split("\n");
        int noOfSpaces = splitStr[0].length() - splitStr[0].trim().length();
        files.push(new Files(splitStr[0], splitStr[0].trim().length() + 1, noOfSpaces));
        for(int i = 1; i < splitStr.length; i++) {
            if(noOfSpaces < splitStr[i].length() - splitStr[i].trim().length()) {
                noOfSpaces = splitStr[i].length() - splitStr[i].trim().length();
                files.push(new Files(splitStr[i], files.peek().length + splitStr[i].trim().length() + 1, noOfSpaces));
            } else {
                while(!files.isEmpty() && files.peek().noOfSpaces >= splitStr[i].length() - splitStr[i].trim().length()) {
                    files.pop();
                }
                noOfSpaces = splitStr[i].length() - splitStr[i].trim().length();
                if(files.empty())
                    files.push(new Files(splitStr[i], splitStr[i].trim().length() + 1, noOfSpaces));
                else
                    files.push(new Files(splitStr[i], files.peek().length + splitStr[i].trim().length() + 1, noOfSpaces));
            }
            if (splitStr[i].contains(".gif") || splitStr[i].contains(".jpeg")) {
                sum += files.peek().length;
            }
        }
        System.out.println(sum);
    }
 
    public static void main(String args[]) {
        CountLength2 s = new CountLength2();
        //String S = "dir1\n dir11\n dir12\n  picture.jpeg\n  dir121\n  file1.txt\ndir2\n file2.gif";
        String s1 = "dir1"+"\n"+" dir11" +"\n"+ " dir12" +"\n"+ "  picture.jpeg" +"\n"+ "  dir121" + "\n" + "   file2.txt" + "\n" + "   file2.jpeg" +"\n"+ "  file1.txt" +"\n"+
                    "dir2" +"\n"+ " file2.gif" ;
        String S = "dir1\n dir11\n  dir111\n   picture.gif\n   text1.txt\n  dir112\n   sample1.jpeg\n dir12\n  sample2.gif";
        s.solution(s1);
    }
}