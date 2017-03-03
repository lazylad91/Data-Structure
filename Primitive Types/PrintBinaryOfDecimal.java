public class PrintBinaryOfDecimal {
 public static void main(String args[]){
        System.out.println(printBinary(.50));
  }
  public static String printBinary(double num){
      if(num>=1 || num <=0)
      return "Error";
      StringBuilder sb = new StringBuilder();
      sb.append(".");
      while(num>0){
      double r = num * 2;
      System.out.println(num);
      System.out.println(r);
          if(r>=1){
             sb.append("1");
             num = r-1;
          }
          else{
              sb.append("0");
              num = r;
          }
      }
      return sb.toString();
  }
 }