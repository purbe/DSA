package recursion;
import java.util.ArrayList;
public class NQueens {
    public static void solve(int [][]board,int row,ArrayList<ArrayList<Integer>>sol,int n){

        if(row==n){
            sol.add(construct(board));
            return ;
        }

        for(int col=0;col<n;col++){

            if(isValid(board,row,col,n)){
                board[row][col]=1;

                solve(board, row+1, sol, n);

                board[row][col]=0;
            }

        }

    }

    public static boolean isValid(int[][] board,int row,int col,int n){

        for(int i=0;i<row;i++){
            if(board[i][col]==1)
                return false;
        }

        for(int i=row-1,j=col-1;i>=0&&j>=0;i--,j--){
            if(board[i][j]==1)
                return false;
        }

        for(int i=row-1,j = col + 1; i >= 0 && j < n; i--, j++){
            if(board[i][j]==1)
                return false;
        }

        return true;


    }
    public static ArrayList<Integer> construct(int[][] board) {
        ArrayList<Integer> configuration = new ArrayList<>();
        for (int[] row : board) {
            for (int cell : row) {
                configuration.add(cell); // Add each cell to the list
            }
        }
        return configuration;
    }

    public static ArrayList<ArrayList<Integer>> nQueens(int n)
    {

        int[][] board = new int [n][n];
        ArrayList<ArrayList<Integer>> sol = new ArrayList<>();

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j]=0;
            }
        }

        solve(board,0,sol,n);

        return sol;

    }
}
