/* so if matrix is 

     1 2 3                                  7 4 1
     4 5 6    ===== after rotation  ====    8 5 2
     7 8 9                                  9 6 3
     
     method do it first - transpose it
     so a[i][j] = a[j][i], diagonal elements remain same
     
     1 4 7    
     2 5 8
     3 6 9
     
     then just reverse each row and u are done
     
     7 4 1
     8 5 2
     9 6 3
*/

public class RotateMatrix90{
    public static void main(String[] args){
        int[][] mat = new int[3][3];
        int k=1;
        for(int i=0; i<mat.length; i++){
            for(int j=0; j<mat[0].length; j++){
            mat[i][j]=k;
            k++;
            }   
        }
        RotateAndPrint(mat);
    }
    
    public static void RotateAndPrint(int[][] mat){
        //transpose it
        for(int i=0; i<mat.length; i++){
            for(int j=i; j<mat[0].length; j++){
                if(i!=j){
                    int temp = mat[i][j];
                    mat[i][j] = mat[j][i];
                    mat[j][i] = temp;
                }
            }
        }
        
        for(int i=0; i<mat.length; i++){
            for(int j = 0; j<mat[0].length/2; j++){
                int temp = mat[i][j];
                mat[i][j] = mat[i][mat[0].length-j-1];
                mat[i][mat[0].length-j-1] = temp;
            }
        }
        
        // printing the new array
        
        for(int i=0; i<mat.length; i++){
            System.out.println("");
            for(int j=0; j<mat[0].length; j++){
             System.out.print(mat[i][j]+" ");
            }   
        }
    }
}