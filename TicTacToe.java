import java.util.Scanner;
public class TicTacToe {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        char[][] board = new char[3][3];
        char currentPlayer = 'X';
        initializeBoard(board);
        while (true){
            printBoard(board);
            System.out.println("Player " + currentPlayer + ", enter row(1-3): ");
            int row = input.nextInt() - 1;
            System.out.println("Player " + currentPlayer + ", enter column(1-3): ");
            int col = input.nextInt() - 1;
            if (board[row][col] == ' '){
                board[row][col] = currentPlayer;
                if (chekWin(board, currentPlayer)){
                    printBoard(board);
                    System.out.println("player " + currentPlayer + "wins!");
                    break;
                } else if (checkTie(board)) {
                    printBoard(board);
                    System.out.println("Game is a tie");
                    break;
                }else {
                    currentPlayer = currentPlayer == 'X' ? 'O' : 'X';
                }
            }else {
                System.out.println("That spot is already taken, please try again.");
            }
        }
    }
    public static void initializeBoard(char[][] board){
        for (int row = 0; row< 3; row++){
            for (int col = 0; col<3; col++){
                board[row][col] = ' ';
            }
        }
    }
    public static void printBoard(char [][] board){
        System.out.println("----------");
        for (int row =0; row < 3; row++){
            //System.out.println("|");
            for (int col = 0; col < 3; col++){
                System.out.println(board [row][col] + " | ");
            }
            System.out.println("------");
        }
    }
    public static boolean chekWin(char[][] board, char player){
        for ( int i = 0; i < 3; i++){
            if (board [i][0] == player && board[i][1] == player && board[i][2] == player){
                return true;
            } else if (board[0][i] == player && board[1][i] == player && board[2][i] == player) {
                return true;
            }
        }
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true;
        } else if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true;
        }
        return false;
    }
    public static boolean checkTie(char[][] board){
        for (int row = 0; row <3 ; row++){
            for (int col = 0; col < 3; col++){
                if (board[row][col]==' '){
                    return false;
                }
            }
        }
        return true;
    }
}