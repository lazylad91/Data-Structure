import java.io.*;
import java.util.*;
import java.net.*;


public class FindCompany{
    
    //output file name
    private static final String FILENAME = "output.txt";

    private static StringBuilder resultString = new StringBuilder();
    
    public static void main(String[] args){
        readFileLines();
        writeOutput();
    }
    
    public static void readFileLines(){
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("/home/ubuntu/workspace/FinalPractice/task1.txt"));
            String line = br.readLine();
            while (line != null) {
                resultString.append(line);
                resultString.append("\t");
                resultString.append(findCompanyName(line));
                resultString.append("\n");
                line = br.readLine();
            }
        } 
        catch(Exception ex){
            ex.printStackTrace();
        }
        finally {
            if(br!=null){
                try{
                    br.close();
                }
                catch(Exception ex){
                    ex.printStackTrace();
                }                
            }
        }        
    }
    
    
    public static String findCompanyName(String line){
        String[] tokens = line.split(" ");
        StringBuilder  sb = new StringBuilder();
        List<String> reverseList = new ArrayList<String>();
        List<String> tokenList = Arrays.asList(tokens);
        Collections.reverse(tokenList);
        for(String token : tokenList){
            if(Character.isLetter(token.charAt(0)) && Character.isUpperCase(token.charAt(0))){
                reverseList.add(token);
            }
            else{
                break;
            }
        }
        for(int i=reverseList.size()-1; i>=0; i--){
            sb.append(reverseList.get(i));
            sb.append(" ");
        }
        return sb.toString();
    }
    
    public static void writeOutput(){
        BufferedWriter bw = null;
		FileWriter fw = null;

		try {

			String content = resultString.toString();

			fw = new FileWriter(FILENAME);
			bw = new BufferedWriter(fw);
			bw.write(content);

			System.out.println("Done");

		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				if (bw != null)
					bw.close();

				if (fw != null)
					fw.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}

		}

    }
}