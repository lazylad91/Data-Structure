/*-Atvt hrqgse, Cnikg
Your friend, Alice*/
public class Encrypted{
    public static void main(String args[]){
        String enString = "-Atvt hrqgse, Cnikge" ;
        String deString = "YourfriendAlicez";
        String cipherText = enString.split("-")[1];
        System.out.println(cipherText);
        cipherText = cipherText.replace(" ","");
        cipherText = cipherText.replace(",","");
        System.out.println(cipherText);
        char[] charArray = deString.toCharArray();
        int i=0;
        StringBuilder stb = new StringBuilder();
        for(char c : cipherText.toCharArray()){
            int ascOrig = charArray[i];
            if(Character.isLowerCase(c)){
               int ascCipher = c;
                int diff = ascCipher-ascOrig;
                int key=0;
                if(ascCipher>=ascOrig&&diff>=0&&diff<=9){
                    key = ascCipher-ascOrig;
                }
                else{
                    key = 'z'-ascOrig;
                    key = key+(ascCipher-96);
                }
                stb.append(key);
                System.out.println(key);
                //System.out.println("uppercase - "+asc);
            }
            else{
                int ascCipher = c;
                int diff = ascCipher-ascOrig;
                int key=0;
                if(ascCipher>=ascOrig&&diff>=0&&diff<=9){
                    key = ascCipher-ascOrig;
                }
                else{
                    key = 'Z'-ascOrig;
                    key = key+(ascCipher-64);
                }
               // System.out.println(key);
                stb.append(key);
            }
            i++;
        }
        System.out.println(stb.toString());
        String keyStringFull = stb.toString();
        String finalKey = "";
        for(int j=1; j<=keyStringFull.length()/2;j++){
            String compareFirst = keyStringFull.substring(0,j);
            String compareSecond = keyStringFull.substring(j,2*j);
            if(compareFirst.equals(compareSecond)){
                finalKey = compareFirst;
            }
        }
        System.out.println(finalKey);
        
      
    StringBuilder stb1 = new StringBuilder();
    char[] finalKeyArray = finalKey.toCharArray();
    int k=0;
    enString = "Bjj rwkcs dwpyp fwz ovors wxjs vje tcez fqg";
    for(char ch : enString.toCharArray()){
       if(Character.isLetter(ch)){
           //System.out.println("letter "+ch);
            int keyValue = Integer.parseInt(finalKeyArray[k]+"");
            System.out.println("key value act is "+keyValue);
            
            int ascCh = ch;
            System.out.println("ascch value act is "+ascCh);
              /*        char-key and then check the range
                if char-key >=CapitalA
                append char-key 
                else
                remaingkeyvalue=Key-char-CapitalA+1
                append CapitalZ-remaingkeyvalue;*/
            if(Character.isLowerCase(ch)){
                if(ascCh-keyValue>=97){
                    char finalChar = (char)(ascCh-keyValue);
                    stb1.append(finalChar);
                }
                else{
                    int remaingkeyvalue = keyValue-(ascCh-97)-1;
                    stb1.append((char)(122-remaingkeyvalue));
                }
            }
            else{
                if(ascCh-keyValue>=65){
                    System.out.println("ascCh" + ascCh);
                    System.out.println("keyValue" + keyValue);
                    stb1.append((char)(ascCh-keyValue));
                }
                else{
                    System.out.println("ascCh" + ascCh);
                    System.out.println("keyValue" + keyValue);
                    int remaingkeyvalue = keyValue-(ascCh-65)-1;
                    stb1.append((char)(90-remaingkeyvalue));
                }
            }
            k++;
           if(k==finalKeyArray.length)  k=0;
       }
       else{
           //System.out.println("character "+ch);
           stb1.append(ch);
       }
       
    }
    
    System.out.println(stb1.toString());
}
    
    
}