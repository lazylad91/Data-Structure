/*
   You are given a listing of directories and files in a file system. Each directory and file has a name, which is a non-empty
string consisting of alphanumerical characters. Additionally, the name of each file contains a single dot character; the part
of the name starting with the dot is called the extension. Directory names do not contain any dots. All the names are case-
sensitive.
Each entry is listed on a separate line. Every directory is followed by the listing of its contents indented by one space
character. The contents of the root directory are not indented.
Here is a sample listing:
dir1
 dir11
 dir12
  picture.jpeg
  dir 121
   file1.txt
dir2
 file2.gif
We have three files (picture.jpeg, file1.txt and file2.gif) and six directories (dir1, dir11, dir12, dir121, dir2 and the
root directory). Directory dir12 contains two files (picture.jpeg and file1.txt) and an empty directory (dir121). The root
directory contains two directories (dir1 and dir2).
The absolute path of a directory is a string containing the names of directories which have to be traversed (from the root
directory) to reach the directory, separated by slash characters. For example, the absolute path to the directory dir121 is
dir1/dir12/dir121". Note that there is no "drive letter", such as "C: ", and each absolute path starts with a slash. The
absolute path of a root directory is The image files are the files with extensions .jpeg, .png or .gif (and only these extensions). We are only interested in directories that directly contain image files (that is, without looking in their subdirectories). We want to find the total length
of the absolute paths to all the directories that directly contain at least one image file. For example, in the file system
described above there are two directories that directly contain image files: "/dir1/dir12" and "Mia". Directory "/dir1"
doesn't directly contain any image files. The total length of the absolute paths "/dir1/dir12" and "/dir2" is 11 + 5 = 16.
Write a function:

int solution(char *S);

that, given a string S consisting of N characters which contains the listing of a file system, returns the total of lengths (in
characters) modulo 1,000,000,007 of the absolute paths to all the directories directly containing at least one image file. For
example, given the sample listing shown above, the function should return 16, as explained above. If there are no image
files in the listing, the function should return 0.
Assume that:
N is an integer within the range [1..3,000,000];
string S consists only of alphanumerical characters (a-z and/or A-Z and/or 0-9), spaces, dots (.) and end-
of-line characters;
string S is a correct listing of a file system contents.

Complexity:
expected worst-case time complexity is 0(N);
expected worst-case space complexity is 0(N) (not counting the storage required for input arguments). 
*/

import java.util.*;
import java.io.*;

class CountLength1{
    public static void main(String args[]){
        String s = "dir1"+"\n"+" dir11" +"\n"+ " dir12" +"\n"+ "  picture.jpeg" +"\n"+ "  dir121" + "\n" + "   file2.txt" + "\n" + "   file2.jpeg" +"\n"+ "  file1.txt" +"\n"+
                    "dir2" +"\n"+ " file2.gif" ;
         String S1 = "dir1\n dir11\n  dir111\n   picture.gif\n   text1.txt\n  dir112\n   sample1.jpeg\n dir12\n  sample2.gif";
        System.out.println(S1);
        System.out.println(giveLength(S1));
        System.out.println(s);
        System.out.println(giveLength(s));
    }
    
    public static int giveLength(String s){
        ArrayList<String> listOfPath = new ArrayList<String>();
        HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
        String[] sArray = s.split("\n");
        int result=0;
        for(int i=0; i<sArray.length; i++){
            int spaceLength = sArray[i].length() - sArray[i].trim().length();
            System.out.println("Space Length is"+ spaceLength);
            if(sArray[i].contains(".gif")||sArray[i].contains(".jpeg")){
                // spaces nikalo or agar 2 space hai list[0].length list[1].length mein add kar do
                /*for(int j=0;j<spaceLength;j++){
                    System.out.println("route is "+listOfPath.get(j));
                    result = result+listOfPath.get(j).length();
                }*/
                System.out.println(sArray[i].trim());
                result = result + sArray[i].trim().length()+1+hm.get(spaceLength-1);
                System.out.println(result);
            }
            else{
            // string nikalo space count karo aur jitni space us index pe value daal do
            // until u find and gif or jpeg
                listOfPath.add(spaceLength,"/"+sArray[i].trim());
                if(hm.containsKey(spaceLength-1)){
                    hm.put(spaceLength,sArray[i].trim().length()+1+hm.get(spaceLength-1));
                }
                else{
                    hm.put(spaceLength,sArray[i].trim().length()+1);
                }
            }
        }
        return result;
    }
}