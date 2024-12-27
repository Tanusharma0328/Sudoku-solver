public class sudoku{
    private static final int size = 9;
    public static void main(String[] args){
        int[][] board = {
            {5,3,0,0,7,0,0,0,0},
            {6,0,0,1,9,5,0,0,0},
            {0,9,8,0,0,0,0,6,0},
            {8,0,0,0,6,0,0,0,3},
            {4,0,0,8,0,3,0,0,1},
            {7,0,0,0,2,0,0,0,6},
            {0,6,0,0,0,0,2,8,0},
            {0,0,0,4,1,9,0,0,5},
            {0,0,0,0,8,0,0,7,9}
        };

        if(solvesudoku(board)) {
            System.out.println("Solved sudoku:");
            printboard(board);
        }else{
            System.out.println("no solution exist.");
        }
    }
    public static boolean solvesudoku(int[][] board)
    {
        for(int row=0; row<size; row++)
        {
            for(int col=0; col<size; col++)
            {
                if(board[row][col] == 0)
                {
                for(int num=1; num<=size; num++)
                {
                    if(issafe(board, row,col,num))
                    {
                        board[row][col] = num;

                        if(solvesudoku(board))
                        {
                            return true;
                        }
                        board[row][col] = 0;
                    }
                }
                return false;
            }
            }
        }
        return true;
    }

    public static boolean issafe(int[][] board, int row, int col, int num){
        for(int x=0; x<size; x++){
            if(board[row][x] == num){
                return false;
            }
        }
        for(int x=0; x<size; x++){
            if(board[x][col] == num){
                return false;
            }
        }
        int startrow = row - row%3;
        int startcol = col - col %3;
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if(board[startrow + i][startcol + j] == num){
                    return false;
                }
            }
        }
        return true;
    }
    public static void printboard(int[][] board) 
    {
        for(int row = 0; row < 3; row++)
        {
            for(int r=0; r<3; r++)
            {
                for(int col = 0; col < 3; col++)
                {
                    for(int c=0; c<3; c++)
                    {
                        System.out.print(board[row * 3 + r][col * 3 + r] + " ");
                    }
                    System.out.print(" ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }
}