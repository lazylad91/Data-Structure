public class Nubicabe{
    public static void main(String[] args){
        char[][] puzzle = {{'.','#','2','.','1'},
                            {'.','.','.','#','.'},
            {'.','.','3','#','.'}
        };
                            checkPuzzle(puzzle);
    }
    static void checkPuzzle(char[][] puzzle){
        int rowLength = puzzle.length;
        int colLength = puzzle[0].length;
        for(int i=0; i<puzzle.length; i++){
            for(int j=0; j<puzzle[0].length; j++){
                if(Character.isDigit(puzzle[i][j])){
                    System.out.println("here");
                    System.out.println(check(puzzle,Character.getNumericValue(puzzle[i][j])-1,i,j,rowLength,colLength));
                }
            }
        }
    }
    
    public static boolean  check(char[][] a,int num,int i,int j, int rowLength,int colLength){
        if(num==0)
        return true;
        char temp = a[i][j];
        a[i][j] = '*';
        if(i+1<rowLength && a[i+1][j]!='*' && a[i+1][j] == '#' ){
            num--;
            return check(a,num,i+1,j,rowLength,colLength);
        }
        else if(i-1>=0 && a[i-1][j]!='*' && a[i-1][j] == '#' ){
            num--;
            return check(a,num,i-1,j,rowLength,colLength);
        }
        else if(j+1<colLength && a[i][j+1]!='*' && a[i][j+1] == '#' ){
            num--;
            return check(a,num,i,j+1,rowLength,colLength);
        }
         else if(j-1>0 && a[i][j-1]!='*' && a[i][j-1] == '#' ){
            num--;
            return check(a,num,i,j-1,rowLength,colLength);
        }
        a[i][j] =  temp;
        
        return false;
    }
}