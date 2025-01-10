package recursion;

public class IsSudoku {
    public static boolean isItSudoku(int matrix[][]) {

        // Write your code here.

        for(int row = 0;row<9;row++){
            for(int col=0; col<9; col++){

                if(matrix[row][col]==0){
                    for(int num=1;num<=9;num++){

                        if(isvalid(matrix,row,col,num)){
                            matrix[row][col]=num;
                            if(isItSudoku(matrix)){
                                return true;
                            }
                        }
                        matrix[row][col]=0;

                    }
                    return false;
                }


            }
        }
        return true;

    }

    public static boolean isvalid(int matrix[][],int row,int col, int num){

        for(int i=0;i<9;i++){
            if(matrix[row][i]==num || matrix[i][col]==num)
                return false;

        }

        int strow= (row/3)*3;
        int stcol= (col/3)*3;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(matrix[strow+1][stcol+1]==num)
                    return false;
            }
        }

        return true;
    }

    public static void main (String arg[]){
        int[][] matrix = {
                {5, 3, 0, 0, 7, 0, 0, 0, 0},
                {6, 0, 0, 1, 9, 5, 0, 0, 0},
                {0, 9, 8, 0, 0, 0, 0, 6, 0},
                {8, 0, 0, 0, 6, 0, 0, 0, 3},
                {4, 0, 0, 8, 0, 3, 0, 0, 1},
                {7, 0, 0, 0, 2, 0, 0, 0, 6},
                {0, 6, 0, 0, 0, 0, 2, 8, 0},
                {0, 0, 0, 4, 1, 9, 0, 0, 5},
                {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };

        System.out.println(isItSudoku(matrix)+"");
    }
}
