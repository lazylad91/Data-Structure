/* Set the row i and coloumn j zero if mat[i][j] =0
Simplest way is note down the row and coloumn and keep iterating and in the end again iterate it and make 
everything zero. If you do it in while 1st iteration and then whole matrix will turn into 0.
for recording rows and coloumn to  be mark zero, first way is u can take 2 vector, which will keep track of it
To do this in o(1) space - use first row and coloum for this purpose. 
like if a[i][j] = 0 then set a[i][0] and a[o][j] = 0
also take 2 boolean variable - first row and first coloum - set them true if any element in first row 
or coloum is zero. We cannot make first row and coloumn zero as we are using them to make
other element zero. In the end we will do this.
*/
public class SetMatrixZeroes{
    public static void main(String[] args){
        int[][] a = new int[4][4];
        for(int i=0; i<4; i++){
            for(int j=0; j<4; j++){
                a[i][j]=1;
            }
        }
        a[0][1]=0;
        a[2][0]=0;
        a[3][3]=0;
        setZeroes(a);
    }
    
    public static void setZeroes(int[][] a){
        boolean fc=false;
        boolean fr=false;
        for(int i=0; i<a.length; i++){
            for(int j=0; j<a[0].length; j++){
                if(a[i][j]==0){
                    if(i==0) fr=true;
                    if(j==0) fc=true;
                    a[i][0]=0;
                    a[0][j]=0;
                }
            }
        }
            for(int i=1; i<a.length; i++){
                for(int j=1; j<a[0].length; j++){
                    if(a[i][0]==0 || a[0][j]==0)
                        a[i][j]=0;
                }
            }
            if(fr){
                for(int i=0; i<a[0].length; i++){
                    a[0][i]=0;
                }
            }
            if(fc){
                for(int i=0; i<a.length; i++){
                    a[i][0]=0;
                }                
            }
            for(int i=0; i<a.length; i++){
                System.out.println("");
                for(int j=0; j<a[0].length; j++){
                System.out.print(a[i][j]+" ");
                }   
            }
        }
}
    
    