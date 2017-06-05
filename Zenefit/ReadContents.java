/*Please write a program that can read the contents of any directory (and it’s subdirectories) in
the filesystem, and display the contents sorted in order of file size to System.out. The
directory to search should be passed as a parameter to the “main” method of the program.
The output should show the full path of the file, the file name, and the file size
*/
package exercise1;

import java.io.File;
import java.util.*;


/**
 * Created by Sagar on 4/4/2017.
 */
public class ReadContents {
    static List<File> fileList = new ArrayList<>();;
    static class FileSizeComparator implements Comparator<File> {
        public int compare( File a, File b ) {
            Long aSize = a.length();
            Long bSize = b.length();
            return aSize.compareTo(bSize);
        }
    }

    public static void main(String[] args){
        String folderpath = args[0];
        ReadContents obj = new ReadContents();
        File folderreference = new File(folderpath);
        obj.listFilesForFolder(folderreference);
        System.out.println("LIST: "+fileList);
        obj.sortFilesAndPrint();
    }

    int i =0;
    public void listFilesForFolder(final File folder) {
        for (File fileEntry : folder.listFiles()) {
            if (fileEntry.isDirectory()) {
                listFilesForFolder(fileEntry);
            } else {
                fileList.add(fileEntry);
                System.out.println("Adding +++++++++++++++++++++++++++++ "+i+" "+fileEntry.getName());
                i++;
            }
        }
    }

    public void sortFilesAndPrint(){
        System.out.println("LISTSIZE: "+fileList.size());
        Collections.sort(fileList, new FileSizeComparator());


        for (File file:fileList){
            System.out.println("File Size: "+file.length()+ "\nFile Name: "+file.getName()+ " \nFile Path: "+file.getAbsolutePath());
            System.out.println();
        }
    }


}